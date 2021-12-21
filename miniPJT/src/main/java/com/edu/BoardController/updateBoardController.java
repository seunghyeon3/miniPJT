package com.edu.BoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.BoardVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class updateBoardController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String header = req.getParameter("header");
		String content = req.getParameter("content");
		String memberID = req.getParameter("memberId");
		int boardID = Integer.parseInt(req.getParameter("boardId"));
		
		
		BoardVO vo = new BoardVO();
		
		vo.setBoardContent(content);
		vo.setBoardHeader(header);
		vo.setMemberId(memberID);
		vo.setBoardId(boardID);
		
		GatherModel getBoard = GatherModel.getInstance();
		getBoard.updateBaord(vo);
		
		res.sendRedirect("/miniPJT/board/listBoard.jsp");
		
		
	}

}
