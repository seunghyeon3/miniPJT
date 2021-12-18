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
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
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
	}

}
