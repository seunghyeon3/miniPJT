package com.edu.MemberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String memberId = req.getParameter("memberId");
		
		// 삭제 
		GatherModel getmember = new GatherModel();
		//getmember.delet(memberId);
		
		res.sendRedirect("main.jsp");
		

	}

}
