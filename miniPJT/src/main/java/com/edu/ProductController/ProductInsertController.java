package com.edu.ProductController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.ProductVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

<<<<<<< HEAD
		String saveUrl = req.getRealPath("/upload");
		int maxSize = 30 * 1024 * 1024;
		String encoding = "UTF-8";
		MultipartRequest mRequset = new MultipartRequest(req, saveUrl, maxSize, encoding,
				new DefaultFileRenamePolicy());

		String product_name = req.getParameter("product_name");
		String product_price = req.getParameter("product_price");
		String product_picture = req.getParameter("product_picture");
		String product_content = req.getParameter("product_content");
		String product_id = req.getParameter("product_id");
		String product_eval = req.getParameter("product_eval");

=======
		String product_name = req.getParameter("product_name");
		int product_price = Integer.parseInt(req.getParameter("product_price"));
		String product_picture = req.getParameter("product_picture");
		String product_content = req.getParameter("product_content");
		int product_id = Integer.parseInt(req.getParameter("product_id"));
		double product_eval = Double.valueOf(req.getParameter("product_eval"));
		
>>>>>>> 4f2639b949b4c36ad331cd6d9ea9d05770da506f
		ProductVO vo = new ProductVO();
		vo.setProduct_id(product_id); // 상품아이디
		vo.setProduct_content(product_content); // 상품설명
		vo.setProduct_eval(product_eval); // 상품평점
		vo.setProduct_name(product_name); // 상품명
		vo.setProduct_picture(product_picture); // 사진
		vo.setProduct_price(product_price); // 가격

		GatherModel.getInstance().insertProduct(vo);
<<<<<<< HEAD
		req.setAttribute("product", vo);

		req.getRequestDispatcher("product/productOutput.jsp").forward(req, res);
		

=======
		
		
		/*
		 * req.setAttribute("product", vo);
		 * req.getRequestDispatcher("../product/productMain.jsp").forward(req, res);
		 */
		
		res.sendRedirect("../product/productMain.jsp");
>>>>>>> 4f2639b949b4c36ad331cd6d9ea9d05770da506f
	}

}
