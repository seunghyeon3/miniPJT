package com.edu.MemberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.VO.MemberVO;
import com.edu.controller.Controller;
import com.edu.service.GatherModel;

public class MemberUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String memberName = req.getParameter("memberdName");
		String memberEmail = req.getParameter("memberEmail");
		String memberNickName = req.getParameter("memberNickName");
		String memberPhone = req.getParameter("memberPhone");
		String memberAddr = req.getParameter("memberAddr");
		String admin = req.getParameter("admin");
		
		MemberVO vo = new MemberVO();
		vo.setMemberId(memberId);
		vo.setMemberPw(memberPw);
		vo.setMemberdName(memberAddr);
		vo.setMemberEmail(memberEmail);
		vo.setMemberPhone(memberPhone);
		vo.setMemberdName(memberAddr);
		vo.setAdmin(admin);	
		
		GatherModel model = new GatherModel();
		model.updateMember(vo);

	}
}
