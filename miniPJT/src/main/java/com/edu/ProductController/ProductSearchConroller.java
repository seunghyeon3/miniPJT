package com.edu.ProductController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.ProductVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class ProductSearchConroller implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String product_id = req.getParameter("product_id");
		String job = req.getParameter("job");

		ProductVO vo = GatherModel.getInstance().prdocutSearch(product_id);

		req.setAttribute("product", vo);
		if (job.equals("search")) {
			System.out.println("search");
			req.getRequestDispatcher("product/productSearchOutPut.jsp").forward(req, res);
		} else if (job.equals("update")) {
			System.out.println("update");
			req.getRequestDispatcher("product/productModify.jsp").forward(req, res);
		} else if (job.equals("delete")) {
			System.out.println("delete");
			req.setAttribute("product", GatherModel.getInstance().prdocutSearch(product_id));
			List<ProductVO> list = GatherModel.getInstance().listProduct();
			req.setAttribute("productList", list);
			req.getRequestDispatcher("../product/productOutput.jsp").forward(req, res);
		}
	}
}