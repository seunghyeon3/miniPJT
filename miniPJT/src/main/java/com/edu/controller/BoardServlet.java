package com.edu.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.service.GatherModel;

//@WebServlet("경로") ->web.xml에서도 경로를 지정 가능하고, 아래의 내용처럼도 경로를 지정 가능
@WebServlet("/boardServlet")

//서블릿 페이지(요청 데이터를 화면에 출력해주기 위해서 사용.. 대표적으로 get/post 방식 사용

// get -> url에 데이터를 넣어서 전송(서버에서 데이터 요청시 쓰임)
// post -> http message에 요청 데이터를 넣어서 보냄(message body, header 등)

public class BoardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//.do 파일을 list에 담아서 사용하기 위함
	HashMap<String, Controller> list = null;
	
	// 싱글톤(싱글톤 객체로 gatherModel 쓰면 됨)
	GatherModel getBoard = GatherModel.getInstance();
	
	public BoardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 전체 조회 기능
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 단건 조회
		// 입력
		// 수정
		// 삭제
	}

}
