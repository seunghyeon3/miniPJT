package com.edu.service;


import com.edu.VO.MemberVO;
=======

import java.util.List;

import com.edu.VO.BoardVO;
import com.edu.VO.CommentVO;
import com.edu.VO.MemberVO;
import com.edu.VO.ProductVO;
>>>>>>> 4f2639b949b4c36ad331cd6d9ea9d05770da506f
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
	public List<CommentVO> getComment(){
		return cDAO.getComment();
	}
	
	public void insertComment(CommentVO vo) {
		cDAO.insertComment(vo);
	}
	
	public void updateComment(CommentVO vo) {
		cDAO.updateComment(vo);
	}
	
	public void deleteComment(int id) {
		cDAO.deleteComment(id);
	}
	
	//3. member(멤버) DAO 영역
	// 조회
	public MemberVO SearchMember(String memberId) {
		return mDAO.memberSearch(memberId);
	}
	// 입력.
	public MemberVO insertMember(MemberVO vo) {
		return mDAO.memberInsert(vo);
		
	}
	// 수정
	public MemberVO updateMember(MemberVO vo) { 
		return mDAO.memberUpdate(vo);
	}
	
	//4. product(상품) DAO 영역
	
	//상품입력
	public ProductVO insertProduct(ProductVO vo) {
		return pDAO.productInsert(vo);
	}
	//상품리스트
	public List<ProductVO> getProduct(){
		return pDAO.getProduct();
	}
	//상품수정
	public void updateProduct(ProductVO vo) {
		//pDAO.updateProduct(vo);
	}
	
	//상품삭제
	public void deleteProduct(String id) {
		//pDAO.deleteProduct(id);
	}

}
