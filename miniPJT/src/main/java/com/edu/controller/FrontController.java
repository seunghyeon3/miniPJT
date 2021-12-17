package com.edu.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.GatherModel;



public class FrontController extends HttpServlet{
	
	HashMap<String, Controller> list = null;
	
	
	//board, member 등 db 관련 servlet 제외 후 공통 기능 정의
	//ex) login, main page 등
	@Override
	public void init() throws ServletException {
		list = new HashMap<String, Controller>();
		//list.put("/productInsert.do", new ProductInsertController());
		list.put("logout.do", new logoutController());
		list.put("mypage.do", new mypageController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = req.getRequestURI();
		String context = req.getContextPath(); 
		String path = url.substring(context.length()); 
	
		Controller subCont = list.get(path); 
		subCont.execute(req, resp);
	}	
}
