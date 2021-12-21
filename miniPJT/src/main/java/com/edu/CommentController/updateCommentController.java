package com.edu.CommentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.VO.CommentVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class updateCommentController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int commId = Integer.parseInt(req.getParameter("commId"));
		String commVal = req.getParameter("commVal");
		int boardId = Integer.parseInt(req.getParameter("boardId"));
		HttpSession session = req.getSession();
		GatherModel getModel = GatherModel.getInstance();
		CommentVO vo = new CommentVO();
		
		vo.setCommentId(commId);
		vo.setCommentContent(commVal);
		vo.setBoardId(boardId);
		vo.setMemberId((String)session.getAttribute("member_id"));
		getModel.updateComment(vo);
		
		res.sendRedirect("miniPJT/board/contentBoard.jsp");
		
	}

}
