package com.edu.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.edu.VO.BoardVO;
import com.edu.dao.DAO;

public class BoardDAO extends DAO{
	
	//전체 조회
	public List<BoardVO> getBoard(){
		String sql = "select * from board order by 1";
		
		List<BoardVO> list = new ArrayList<>();
		connect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setBoardContent(rs.getString("board_content"));
				vo.setBoardHeader(rs.getString("board_header"));
				vo.setMemberId(rs.getString("member_id"));
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
	public BoardVO getOneBoard(int id) {
		String sql = "select * from board where board_id = ?";
		
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardId(rs.getInt("board_id"));
				vo.setBoardContent(rs.getString("board_content"));
				vo.setBoardHeader(rs.getString("board_header"));
				vo.setMemberId(rs.getString("member_id"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return null;	
	}
	//입력
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board values(?,?,?,?)";
		String selectSql = "select max(board_id) from board";
		int count = 0;
		connect();
		
		try {
			psmt = conn.prepareStatement(selectSql);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1)+1;
				System.out.println(count);
			}
			
			psmt = conn.prepareStatement(sql);
			if(count < 1) {
				count = 1;
			}
			psmt.setInt(1, count);
			psmt.setString(2, vo.getBoardContent());
			psmt.setString(3, vo.getBoardHeader());
			psmt.setString(4, vo.getMemberId());
			int r = psmt.executeUpdate();
			if(r > 0) {
				JOptionPane.showMessageDialog(null, "입력완료");	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//수정
	public void updateBoard(BoardVO vo) {
		String sql ="update board set board_content =?, board_header =? where board_id=?";
		
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardContent());
			psmt.setString(2, vo.getBoardHeader());
			psmt.setInt(3, vo.getBoardId());
			int r = psmt.executeUpdate();
			if(r > 0) {
				JOptionPane.showMessageDialog(null, "수정완료");	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	//삭제
	public void deleteBoard(String id) {
		String sql = "delete from board where board_id = ?";
		connect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			if(r > 0) {
				JOptionPane.showMessageDialog(null, "삭제완료");	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}		
	} 
}
