package com.edu.BoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class deleteBoardController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String boardId = req.getParameter("boardId");
		
		GatherModel getBoard = GatherModel.getInstance();
		
		
		getBoard.deleteBoard(boardId);
		
		res.sendRedirect("/miniPJT/board/listBoard.jsp");	
		
	}

}
