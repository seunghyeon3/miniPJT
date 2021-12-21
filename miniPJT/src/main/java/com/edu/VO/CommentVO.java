package com.edu.VO;

public class CommentVO {
	private int commentId;
	private String commentContent;
	private String memberId;
	private int boardId;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	@Override
	public String toString() {
		return "CommentVO [commentId=" + commentId + ", commentContent=" + commentContent + ", memberId=" + memberId
				+ ", boardId=" + boardId + "]";
	}
	
	

}
