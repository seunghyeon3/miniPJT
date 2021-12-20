package com.edu.ProductController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.ProductVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class ProductShowController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		GatherModel getProduct = GatherModel.getInstance();
		
		
		
	}

}
