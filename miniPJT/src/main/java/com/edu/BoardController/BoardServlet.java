package com.edu.BoardController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.BoardVO;
import com.edu.VO.CommentVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//@WebServlet("경로") ->web.xml에서도 경로를 지정 가능하고, 아래의 내용처럼도 경로를 지정 가능

//서블릿 페이지(요청 데이터를 화면에 출력해주기 위해서 사용.. 대표적으로 get/post 방식 사용

// get -> url에 데이터를 넣어서 전송(서버에서 데이터 요청시 쓰임)
// post -> http message에 요청 데이터를 넣어서 보냄(message body, header 등)

public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// .do 파일을 list에 담아서 사용하기 위함
	HashMap<String, Controller> list = null;

	// 싱글톤(싱글톤 객체로 gatherModel 쓰면 됨)
	GatherModel getBoard = GatherModel.getInstance();

	public BoardServlet() {
	}

	@Override
	public void init() throws ServletException {
		System.out.println("요기요");
		list = new HashMap<String, Controller>();
		list.put("/boardServlet/insertBoard.do", new insertBoardController());
		list.put("/boardServlet/showBoard.do", new showBoardController());
		list.put("/boardServlet/updateBoard.do", new updateBoardController());
		list.put("/boardServlet/deleteBoard.do", new deleteBoardController());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 전체 조회 기능
		String cmd = request.getParameter("cmd");
		if(cmd.equals(null)) {
			cmd = "a";
		}
		if(cmd.equals("comment")) {
		//comment list 불러오는 DAO 해야함
			List<CommentVO> commentList = getBoard.getComment();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			response.getWriter().print(gson.toJson(commentList).toString());
		}else if(cmd.equals("select")){
			List<BoardVO> boardList = getBoard.getBoard();
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			response.getWriter().print(gson.toJson(boardList).toString());
		}
		

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		//http://localhost
		//uri : /miniPJT/boardServlet/insertBoard.do
		//context : /miniPJT
		
		String cmd = req.getParameter("cmd");	
		//cmd null일떄 예외처리 방식 재정의
		if(cmd == null) {
			cmd = "a";
		}
		String uri = req.getRequestURI();
		System.out.println(uri);
		String context = req.getContextPath();
		System.out.println(context);
		
		String temp = req.getParameter("writer");
		System.out.println(temp);
		
		
		int toPos = uri.indexOf(".do");
		
		Controller subCont = null;
		if(toPos > 0) {
			String path = uri.substring(context.length(), toPos + 3);
			System.out.println(path);
			subCont = list.get(path);
		}else {
			String path = uri.substring(context.length());
			System.out.println(path);
			subCont = list.get(path);
		}
		
		//String path2 = uri.substring(context.length()); 동일함		
		System.out.println(cmd);
		if(cmd.equals("delete")) {
			subCont = list.get("/boardServlet/deleteBoard.do");
		}
		
		subCont.execute(req, res);

		// 단건 조회
		// 입력
		// 수정
		// 삭제
	}

}
