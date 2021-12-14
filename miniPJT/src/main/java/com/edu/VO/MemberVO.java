package com.edu.VO;

public class MemberVO {

	//DB table column을 기준으로 작성
	private String memberId;
	private String memberPw;
	private String memberdName;
	private String memberEmail;
	private String memberNickName;
	private String memberPhone;
	private String memberAddr;
	private String admin;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberdName() {
		return memberdName;
	}
	public void setMemberdName(String memberdName) {
		this.memberdName = memberdName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberNickName() {
		return memberNickName;
	}
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberPw=" + memberPw + ", memberdName=" + memberdName
				+ ", memberEmail=" + memberEmail + ", memberNick=" + memberNickName + ", memberPhone=" + memberPhone
				+ ", memberAddr=" + memberAddr + ", admin=" + admin + "]";
	}
	
}
