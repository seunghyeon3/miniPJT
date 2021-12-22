package com.edu.MemberController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.MemberVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class MemberListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		GatherModel getmember = new GatherModel();
		List<MemberVO> list = getmember.searchAll();
		
		req.setAttribute("memberList", list);
		
		req.getRequestDispatcher("member/memberList.jsp").forward(req, res);

	}

}
