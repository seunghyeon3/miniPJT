package com.edu.BoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.BoardVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class showBoardController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int data = Integer.parseInt(req.getParameter("no"));
		
		GatherModel getBoard = GatherModel.getInstance();
		
		
		BoardVO vo =  getBoard.getOneBoard(data);
		
		
		req.setAttribute("boardData", vo);
		
		req.getRequestDispatcher("/board/contentBoard.jsp").forward(req, res);

	}

}
