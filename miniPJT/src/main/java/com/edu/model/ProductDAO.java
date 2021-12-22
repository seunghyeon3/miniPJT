package com.edu.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.VO.BoardVO;
import com.edu.VO.MemberVO;
import com.edu.VO.ProductVO;
import com.edu.dao.DAO;

public class ProductDAO extends DAO{

	public ProductVO productInsert(ProductVO vo) {
		//입력
		String sql = "insert into product values(?,?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getProduct_name());
			psmt.setInt(2, vo.getProduct_price());
			psmt.setString(3, vo.getProduct_content());
			psmt.setString(4, vo.getProduct_picture());
			psmt.setString(5, vo.getProduct_id());
			psmt.setDouble(6, vo.getProduct_eval_Point());
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
	public List<ProductVO> listProduct(){
		
		String sql = "select * from product order by 1";
		connect();
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProduct_id(rs.getString("product_id"));
				vo.setProduct_content(rs.getString("product_content"));
				vo.setProduct_eval_Point(rs.getDouble("product_eval_Point"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setProduct_price(rs.getInt("product_price"));
				vo.setProduct_picture(rs.getString("product_picture"));	
				
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

	//수정
	public ProductVO updateProduct(ProductVO vo) {
		String sql = "update product set product_name = nvl(?,product_name),product_price = nvl(?,product_price),product_content = nvl(?,product_content),product_price = nvl(?,product_price),product_eval_Point = nvl(?,product_eval_Point)where product_id = ?";
	    connect();
	    try {
	      psmt = conn.prepareStatement(sql);
	      psmt.setString(1, vo.getProduct_name());
	      psmt.setInt(2, vo.getProduct_price());
	      psmt.setInt(3, vo.getProduct_price());
	      psmt.setString(4, vo.getProduct_content());
	      psmt.setDouble(5, vo.getProduct_eval_Point());
	      psmt.setString(6, vo.getProduct_id());
	      int r = psmt.executeUpdate();
	      System.out.println(String.valueOf(r) + "건 수정완료");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      disconnect();
	    } 
	    return vo;
	}

	//단건조회
	public ProductVO prdocutSearch(String product_id) {
		String sql = "select * from product where product_id = ?";
	    connect();
	    try {
	      psmt = conn.prepareStatement(sql);
	      psmt.setString(1, product_id);
	      rs = psmt.executeQuery();
	      if (rs.next()) {
	        ProductVO vo = new ProductVO();
	        vo.setProduct_id(rs.getString("product_id"));
	        vo.setProduct_content(rs.getString("product_content"));
			vo.setProduct_eval_Point(rs.getDouble("product_eval_Point"));
			vo.setProduct_name(rs.getString("product_name"));
			vo.setProduct_price(rs.getInt("product_price"));
			vo.setProduct_picture(rs.getString("product_picture"));	
	        return vo;
	      } 
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      disconnect();
	    } 
	    return null;
	  }

	
		public ProductVO deleteProduct(String product_id) {
		    ProductVO vo = prdocutSearch(product_id);
		    String sql = "delete from product where product_id = ?";
		    connect();
		    try {
		      psmt = conn.prepareStatement(sql);
		      psmt.setString(1, product_id);
		      int r = psmt.executeUpdate();
		      System.out.println(String.valueOf(r) + "건 삭제완료");
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      disconnect();
		    } 
		    return vo;
		  }


	
}
