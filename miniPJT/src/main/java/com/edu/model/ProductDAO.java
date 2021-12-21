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
				vo.setProduct_eval(rs.getDouble("product_eval_point"));
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
	
	//단건 조회
	
	
	//수정
//	public MemberVO memberUpdate(MemberVO vo) {
//		String sql = "update product set member_id = ?, member_pw = ?, member_name = ?, member_Email = ? , member_nick_name = ?,member_phone, member_addr, addmin";
//		connect();
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, vo.getMemberId());
//			psmt.setString(2, vo.getMemberPw());
//			psmt.setString(3, vo.getMemberdName());
//			psmt.setString(4, vo.getMemberEmail());
//			psmt.setString(5, vo.getMemberNickName());
//			psmt.setString(5, vo.getMemberPhone());
//			psmt.setString(6, vo.getMemberPhone());
//			psmt.setString(7, vo.getMemberAddr());
//			psmt.setString(8, vo.getAdmin());
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//
//		return vo;
//
//	}
}
