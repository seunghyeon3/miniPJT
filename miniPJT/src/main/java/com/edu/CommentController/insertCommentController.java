package com.edu.CommentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.edu.controller.Controller;
import javax.servlet.http.HttpSession;

import com.edu.VO.CommentVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;


public class insertCommentController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String commData = req.getParameter("commdata");
		int boardId = Integer.parseInt(req.getParameter("boardId"));

		CommentVO vo = new CommentVO();
		vo.setCommentContent(commData);
		vo.setBoardId(boardId);
		//테스트용
		vo.setMemberId("A");
		//vo.setMemberId((String)session.getAttribute("member_id"));
		GatherModel getModel = GatherModel.getInstance();
		getModel.insertComment(vo);
		//req.setAttribute("cmd", "comment");
		//res.sendRedirect("/miniPJT/boardServlet/showBoard.do?cmd=comment");
		//req.getRequestDispatcher("/miniPJT/boardServlet/showBoard.do").forward(req, res);
	}

}
