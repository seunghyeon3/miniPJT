package com.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.ProductVO;
import com.edu.service.GatherModel;

public class ProductInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String product_name = req.getParameter("product_name");
		String product_price = req.getParameter("product_price");
		String product_picture = req.getParameter("product_picture");
		String product_content = req.getParameter("product_content");
		String product_id = req.getParameter("product_id");
		String product_eval = req.getParameter("product_eval");
		
		ProductVO vo = new ProductVO();
		vo.setProduct_id(product_id); //상품아이디
		vo.setProduct_content(product_content); //상품설명
		vo.setProduct_eval(product_eval); //상품평점
		vo.setProduct_name(product_name); //상품명
		vo.setProduct_picture(product_picture); //사진
		vo.setProduct_price(product_price); //가격
		
		GatherModel.getInstance().insert(vo);
		req.setAttribute("product", vo);
		
		req.getRequestDispatcher("product/productOutput.jsp").forward(req, res);

	}

}
