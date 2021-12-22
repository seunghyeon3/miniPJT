package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.MemberVO;
import com.edu.service.GatherModel;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("확인");
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		
		MemberVO vo = new MemberVO();
		vo.setMemberId(memberId);
		vo.setMemberPw(memberPw);
	
		 GatherModel.getInstance();
		 req.setAttribute(memberPw, vo);
		 
		 req.getRequestDispatcher("login/login.jsp").forward(req, res);
	
	}
}
