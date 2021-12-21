package com.edu.MemberController;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.controller.Controller;
import com.edu.controller.LoginController;
import com.edu.controller.logoutController;
import com.edu.service.GatherModel;

@WebServlet("/memberServlet")
public class MemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	//.do 파일을 list에 담아서 사용하기 위함
	HashMap<String, Controller> list = null;
	
	// 싱글톤(싱글톤 객체로 gatherModel 쓰면 됨)
	GatherModel getBoard = GatherModel.getInstance();
	
       
    public MemberServlet() {
      super();
    }
    @Override
    public void init() throws ServletException {
    	list = new HashMap<String, Controller>();
    	//입력
    	list.put("/memberServlet/memberInsert.do", new MemberInsertController());
    	//조회
    	list.put("/memberServlet/memberList.do", new MemberListController());
    	//검색
    	list.put("/memberServlet/memberSearch.do", new MemberSearchController());
    	//수정
		list.put("/memberServlet/memberUpdate.do", new MemberUpdateController());
		//삭제
		list.put("/memberServlet/memberDelete.do", new MemberDeleteController());

		//로그인
		list.put("/memberServlet/Login.do", new LoginController());
		
		//로그아웃
		list.put("/memberServlet/logout.do", new logoutController());
		
		

		
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
