package com.edu.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.VO.CommentVO;
import com.edu.dao.DAO;

public class CommentDAO extends DAO{
	
	//전체 조회
	public List<CommentVO> getComment(){
		String sql = "select * from comments order by 1";
		
		List<CommentVO> list = new ArrayList<>();
		
		connect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				CommentVO vo = new CommentVO();
				vo.setCommentId(rs.getInt("comment_id"));
				vo.setCommentContent(rs.getString("comment_content"));
				vo.setMemberId(rs.getString("member_id"));
				vo.setBoardId(rs.getInt("board_id"));
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
	//입력
	public void insertComment(CommentVO vo) {
		String sql = "insert into comments values(?,?,?,?)";
		String selectSql = "select max(comment_id) from comments where board_id = ?";
		int count = 0;
		connect();
		
		try {
			psmt = conn.prepareStatement(selectSql);
			psmt.setInt(1, vo.getBoardId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1)+1;
			}
			System.out.println(vo);
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, count);
			psmt.setString(2, vo.getCommentContent());
			psmt.setString(3, vo.getMemberId());
			psmt.setInt(4, vo.getBoardId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + " 건 입력 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}				
	}
	//수정
	public void updateComment(CommentVO vo) {
		String sql = "update comments set comment_content = ? where board_id =? and member_id = ? and comment_id = ?";
		
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getCommentContent());
			psmt.setInt(2, vo.getBoardId());
			psmt.setString(3, vo.getMemberId());
			psmt.setInt(4, vo.getCommentId());
			
			int r = psmt.executeUpdate();
			System.out.println(r + " 건 수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}				
	}
	//삭제
	public void deleteComment(int id) {
		String sql = "delete from comments where comment_id = ?";
		
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			
			System.out.println(r + " 건 삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}				
	}
}
