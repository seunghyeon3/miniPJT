package com.edu.CommentController;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.controller.Controller;
import com.edu.service.GatherModel;

@WebServlet("/commnetServlet")
public class CommentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//.do 파일을 list에 담아서 사용하기 위함
	HashMap<String, Controller> list = null;
       
	// 싱글톤(싱글톤 객체로 gatherModel 쓰면 됨)
	GatherModel getBoard = GatherModel.getInstance();
	
    public CommentServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	list = new HashMap<String, Controller>();
    	
    	list.put("/CommentServlet/insertComment.do", new insertCommentController());
    	list.put("/CommentServlet/deleteComment.do", new deleteCommentController());
    	list.put("/CommentServlet/modifyComment.do", new updateCommentController());

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String cmd = req.getParameter("cmd");
		Controller subCont = null;

		//cmd null일떄 예외처리 방식 재정의
		if(cmd == null) {
			cmd = "a";
		}
		System.out.println(cmd);
		if(cmd.equals("delete")) {
			subCont = list.get("/boardServlet/deleteBoard.do");
		}else if(cmd.equals("modify")) {
			subCont = list.get("/boardServlet/deleteBoard.do");
		}else if(cmd.equals("insert")) {
			subCont = list.get("/boardServlet/insertComment.do");
		}
		
		subCont.execute(req, res);
	}

}
