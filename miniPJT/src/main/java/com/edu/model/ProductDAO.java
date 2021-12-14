package com.edu.model;

import java.sql.SQLException;

import com.edu.VO.ProductVO;
import com.edu.dao.DAO;

public class ProductDAO extends DAO{

	public ProductVO productInsert(ProductVO vo) {
		String sql = "insert into member values(?,?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProduct_name());
			psmt.setString(2, vo.getProduct_price());
			psmt.setString(3, vo.getProduct_content());
			psmt.setString(4, vo.getProduct_picture());
			psmt.setString(5, vo.getProduct_id());
			psmt.setString(6, vo.getProduct_eval());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			disconnect();
		}
		return vo;
	}
	
	//전체 조회
	
	//단건 조회
	
	//입력
	
	//수정
}
