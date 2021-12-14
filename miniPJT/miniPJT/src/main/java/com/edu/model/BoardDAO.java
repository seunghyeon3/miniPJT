package com.edu.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.VO.BoardVO;
import com.edu.dao.DAO;

public class BoardDAO extends DAO{
	
	//전체 조회
	public List<BoardVO> getBoard(){
		String sql = "select * from board";
		
		List<BoardVO> list = new ArrayList<>();
		connect();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBoardId(rs.getInt("id"));
				vo.setBoardContent(rs.getString("content"));
				vo.setBoardHeader(rs.getString("header"));
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
	
	//입력
	
	//수정
	
	//삭제
}
