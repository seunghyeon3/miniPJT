package com.edu.CommentController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.edu.VO.CommentVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/commnetServlet")
public class CommentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// .do 파일을 list에 담아서 사용하기 위함
	HashMap<String, Controller> list = null;

	// 싱글톤(싱글톤 객체로 gatherModel 쓰면 됨)
	GatherModel getModel = GatherModel.getInstance();

	public CommentServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		list = new HashMap<String, Controller>();

		//사용안함(insert)
		list.put("/CommentServlet/insertComment.do", new insertCommentController());
		list.put("/CommentServlet/deleteComment.do", new deleteCommentController());
		list.put("/CommentServlet/modifyComment.do", new updateCommentController());

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String cmd = req.getParameter("cmd");
		int boardId = Integer.parseInt( req.getParameter("boardId"));


		// cmd null일떄 예외처리 방식 재정의
		if (cmd == null) {
			cmd = "a";
		}
		if (cmd.equals("comment")) {
			List<CommentVO> commentList = getModel.getOneComment(boardId);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			res.getWriter().print(gson.toJson(commentList).toString());
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String cmd = req.getParameter("cmd");
		//filter json 이라 재정의
		res.setContentType("text/html;charset=utf-8");
		// cmd null일떄 예외처리 방식 재정의
		if (cmd == null) {
			cmd = "a";
		}
		//JSONObject obj = new JSONObject();
		
		if (cmd.equals("delete")) {
			
			int commId = Integer.parseInt(req.getParameter("commId"));
			int boardId = Integer.parseInt(req.getParameter("boardId"));
			
			getModel.deleteComment(commId, boardId);
		
		} else if (cmd.equals("modify")) {
			CommentVO vo = new CommentVO();
			vo.setBoardId(Integer.parseInt(req.getParameter("boardId")));
			vo.setCommentId(Integer.parseInt(req.getParameter("commId")));
			vo.setCommentContent(req.getParameter("commVal"));
			vo.setMemberId("A");
			System.out.println(vo);
			getModel.updateComment(vo);			
			
		} else if (cmd.equals("insert")) {

			String commData = req.getParameter("commdata");
			int boardId = Integer.parseInt(req.getParameter("boardId"));
			CommentVO vo = new CommentVO();
			vo.setCommentContent(commData);
			vo.setBoardId(boardId);
			//테스트용
			vo.setMemberId("A");
		
			getModel.insertComment(vo);
		}

		
	}

}
