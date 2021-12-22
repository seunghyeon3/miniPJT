package com.edu.ProductController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.VO.ProductVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String saveUrl = req.getRealPath("/upload");
		int maxSize = 30 * 1024 * 1024;
		String encoding = "UTF-8";
		MultipartRequest mRequset = new MultipartRequest(req, saveUrl, maxSize, encoding,
				new DefaultFileRenamePolicy());

		String product_id = mRequset.getParameter("product_id");
		String product_name = mRequset.getParameter("product_name");
		String product_price = mRequset.getParameter("product_price");
		String product_content = mRequset.getParameter("product_content");
		String product_picture = mRequset.getFilesystemName("product_picture");
		String product_eval_Point = mRequset.getParameter("product_eval_Point");

		ProductVO vo = new ProductVO();
		//vo.setProduct_id(product_id); // 상품아이디
		vo.setProduct_content(product_content); // 상품설명
		//vo.setProduct_eval(product_eval); // 상품평점
		vo.setProduct_name(product_name); // 상품명
		vo.setProduct_picture(product_picture); // 사진
		//vo.setProduct_price(product_price); // 가격
		vo.setProduct_id(product_id);
		vo.setProduct_name(product_name);
		vo.setProduct_price(Integer.parseInt(product_price));
		vo.setProduct_content(product_content);
		vo.setProduct_picture(product_picture);
		vo.setProduct_eval_Point(Double.parseDouble(product_eval_Point));

		// 입력처리
		GatherModel.getInstance().productInsert(vo);
		

		res.sendRedirect("../product/productOutput.jsp");

	

	}

}
