package com.edu.ProductController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.BoardVO;
import com.edu.VO.ProductVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class ProductShowController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int data = Integer.parseInt(req.getParameter("no"));

		GatherModel getBoard = GatherModel.getInstance();

		BoardVO vo = getBoard.getOneBoard(data);

		req.setAttribute("productData", vo);

		req.getRequestDispatcher("/product/MainProduct.jsp").forward(req, res);

	}

}
