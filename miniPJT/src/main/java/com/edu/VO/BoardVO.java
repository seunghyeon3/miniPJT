package com.edu.VO;

public class BoardVO {

	// 접근 제한자 private 해당 클래스(boardVO)에서만 사용 가능하고 외부에서는 접근 불가능
	private int boardId;
	private String boardContent;
	private String boardHeader;
	private String memberId;

	// getter, setter.. 데이터 캡슐화(정보 은닉) 후 데이터 저장 및 출력 하기 위해 사용

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardHeader() {
		return boardHeader;
	}

	public void setBoardHeader(String boardHeader) {
		this.boardHeader = boardHeader;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	// boardVO의 객체 생성 후, 객체.toString()하면 아래 내용처럼 출력됨.
	@Override
	public String toString() {
		return "boardVO [boardId=" + boardId + ", boardContent=" + boardContent + ", boardHeader=" + boardHeader
				+ ", memberId=" + memberId + "]";
	}

}
