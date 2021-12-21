package com.edu.BoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.VO.BoardVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class insertBoardController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String header = req.getParameter("header");
		String content = req.getParameter("content");
		String id = (String) session.getAttribute("member_id");

		GatherModel getModel = GatherModel.getInstance();
		BoardVO vo = new BoardVO();
		vo.setBoardHeader(header);
		vo.setBoardContent(content);
		vo.setMemberId(id);
		getModel.insertBoard(vo);
		
		
		res.sendRedirect("/miniPJT/board/listBoard.jsp");
		
	}

}
