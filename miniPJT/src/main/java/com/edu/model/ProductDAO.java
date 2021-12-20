package com.edu.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.VO.BoardVO;
import com.edu.VO.ProductVO;
import com.edu.dao.DAO;

public class ProductDAO extends DAO{

	public ProductVO productInsert(ProductVO vo) {
		//입력
		String sql = "insert into member values(?,?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProduct_name());
			psmt.setInt(2, vo.getProduct_price());
			psmt.setString(3, vo.getProduct_content());
			psmt.setString(4, vo.getProduct_picture());
			psmt.setInt(5, vo.getProduct_id());
			psmt.setDouble(6, vo.getProduct_eval());
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
	public List<ProductVO> getProduct(){
		
		String sql = "select * from product order by 1";
		connect();
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProduct_id(rs.getInt("product_id"));
				vo.setProduct_content(rs.getString("product_content"));
				vo.setProduct_eval(rs.getDouble("product_eval"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_price(rs.getInt("product_price"));
				//vo.setProduct_picture(rs.getString("product_picture"));	
				
				list.add(vo);
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return null;
	}
	
	//단건 조회
	
	
	//수정
}
