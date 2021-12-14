package com.edu.model;

import java.sql.SQLException;

import com.edu.VO.MemberVO;
import com.edu.dao.DAO;

public class MemberDAO extends DAO {

	// 단건 조회
	public MemberVO memberSearch(String memberId) {
		String sql = "select * from member where member_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memberId);
			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPw(rs.getString("member_pw"));
				vo.setMemberdName(rs.getString("member_name"));
				vo.setMemberEmail(rs.getString("member_Email"));
				vo.setMemberNickName(rs.getString("membet_nick_name"));
				vo.setMemberAddr(rs.getString(""));
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;

	}

	// 입력
	public MemberVO memberInsert(MemberVO vo) {
		String sql = "insert into member values(?,?,?,?,?,?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPw());
			psmt.setString(3, vo.getMemberdName());
			psmt.setString(4, vo.getMemberEmail());
			psmt.setString(5, vo.getMemberNickName());
			psmt.setString(6, vo.getMemberPhone());
			psmt.setString(7, vo.getMemberAddr());
			psmt.setString(8, vo.getAdmin());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return vo;
	}

	// 수정
	public MemberVO memberUpdate(MemberVO vo) {
		String sql = "update member set member_id = ?, member_pw = ?, member_name = ?, member_Email = ? , member_nick_name = ?,member_phone, member_addr, addmin";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPw());
			psmt.setString(3, vo.getMemberdName());
			psmt.setString(4, vo.getMemberEmail());
			psmt.setString(5, vo.getMemberNickName());
			psmt.setString(5, vo.getMemberPhone());
			psmt.setString(6, vo.getMemberPhone());
			psmt.setString(7, vo.getMemberAddr());
			psmt.setString(8, vo.getAdmin());
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconnect();
		}

		return vo;

	}
}
