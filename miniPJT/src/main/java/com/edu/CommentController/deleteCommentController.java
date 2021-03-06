package com.edu.CommentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class deleteCommentController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int boardID = Integer.parseInt(req.getParameter("boardId"));
		int commId = Integer.parseInt(req.getParameter("commId"));
		GatherModel getModel = GatherModel.getInstance();
		getModel.deleteComment(commId, boardID);
		
		res.sendRedirect("miniPJT/board/contentBoard.jsp");
	}

}
