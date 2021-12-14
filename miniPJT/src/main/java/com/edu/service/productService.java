package com.edu.service;

import com.edu.VO.productVO;
import com.edu.dao.productDAO;

public class productService {
	
	productDAO dao = new productDAO();
	
	public productVO insert(productVO vo) {
		return dao.productInsert(vo);
		
	}
	

}
