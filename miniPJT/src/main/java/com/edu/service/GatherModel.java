package com.edu.service;

import java.util.List;

import com.edu.VO.BoardVO;
import com.edu.model.BoardDAO;
import com.edu.model.CommentDAO;
import com.edu.model.MemberDAO;
import com.edu.model.ProductDAO;

public class GatherModel {
	
	//싱글톤(메모리 누수를 위해 사용)
	private static GatherModel instance = new GatherModel();
	
	public static GatherModel getInstance() {
		return instance;
	}
	
	BoardDAO bDAO = new BoardDAO();
	CommentDAO cDAO = new CommentDAO();
	MemberDAO mDAO = new MemberDAO();
	ProductDAO pDAO = new ProductDAO();
	
	//1. board(게시판) DAO 영역
	public List<BoardVO> getBoard(){
		return bDAO.getBoard();
	}
	public BoardVO getOneBoard(int id) {
		return bDAO.getOneBoard(id);
	}
	public void insertBoard(BoardVO vo) {
		bDAO.insertBoard(vo);
	}
	public void updateBaord(BoardVO vo) {
		bDAO.updateBoard(vo);
	}
	public void deleteBoard(String id) {
		bDAO.deleteBoard(id);
	}
	//2. comment(댓글) DAO 영역
	
	//3. member(멤버) DAO 영역
	
	//4. product(상품) DAO 영역

}