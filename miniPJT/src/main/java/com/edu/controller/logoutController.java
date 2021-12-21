package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> 4f2639b949b4c36ad331cd6d9ea9d05770da506f

public class logoutController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
<<<<<<< HEAD
		HttpSession session = req.getSession();
		session.invalidate();
		
		req.getRequestDispatcher("main.jsp").forward(req, res);
=======
		System.out.println("logout됨?");
>>>>>>> 4f2639b949b4c36ad331cd6d9ea9d05770da506f
	}

}
