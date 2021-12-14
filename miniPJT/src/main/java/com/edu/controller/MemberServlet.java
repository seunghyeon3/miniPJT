package com.edu.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
