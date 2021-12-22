package com.edu.MemberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.MemberVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("memberId");
		String Email = req.getParameter("memberEmail");

		GatherModel getmember = new GatherModel();

		MemberVO vo = getmember.SearchMember(id);
		req.setAttribute("member", vo);

		if (Email.equals("search")) {
			req.getRequestDispatcher("member/memberSearchOutput.jsp").forward(req, res);
		} else if (Email.equals("update")) {
			req.getRequestDispatcher("member/memberUpdateForm.jsp").forward(req, res);
		} else if (Email.equals("delete")) {
			req.getRequestDispatcher("member/memberDeleteFrom.jsp").forward(req, res);
		}
	}
}
