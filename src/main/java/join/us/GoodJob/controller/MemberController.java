package join.us.GoodJob.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import join.us.GoodJob.model.service.MemberService;
import join.us.GoodJob.model.vo.CatNumParamVO;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.MemberVO;

@Controller
public class MemberController {
	@Resource
	MemberService memberService;

	@RequestMapping("user-loginForm.do")
	public String loginForm() {
		return "member/login_form.tiles2";
	}

	@RequestMapping("user-login.do")
	public String login(MemberVO memberVO, HttpSession session) {
		MemberVO mvo = memberService.loginMember(memberVO);
		if(mvo!=null) { //로그인 성공
			session.setAttribute("mvo", mvo);
			return "redirect:home.do";
		}else { //로그인 실패
			return 	"member/login_fail";
		}
	}	
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:home.do";
	}
	
	@RequestMapping("getDevCatVOListAjax.do")
	@ResponseBody
	public List<List<DevCatVO>> getDevCatVOListAjax(CatNumParamVO paramVO) {
		List<String> recruitCatNumList=paramVO.getRecruitCatNumList();
		List<List<DevCatVO>> list= new ArrayList<List<DevCatVO>>();
		for(String rcNum : recruitCatNumList) 
			list.add(memberService.getDevCatVOListByrcNum(rcNum));		
		return list;				
	}
	/**
	 * 인재검색 섹션
	 * @param paramVO
	 * @return
	 */
	@RequestMapping("user-DevCatVOListAjax.do")
	@ResponseBody
	public List<List<DevCatVO>> getUserDevCatVOListAjax(CatNumParamVO paramVO) {
		List<String> recruitCatNumList=paramVO.getRecruitCatNumList();
		List<List<DevCatVO>> list= new ArrayList<List<DevCatVO>>();
		for(String rcNum : recruitCatNumList) 
			list.add(memberService.getDevCatVOListByrcNum(rcNum));		
		return list;				
	}
	

	/**
	 * 181016 MIRI 회원 아이디 중복 검사
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkMemberId.do")
	public String checkMemberId(String id) {
		int checkedId = memberService.checkMemberId(id);
		if(checkedId == 0) return "ok";
		else return "fail";
	}
	@RequestMapping("user-goLogin.do")
	public String goLogin() {
		return "member/must_login.tiles";
	}
	
	/**
	 * 181018 MIRI 회원 탈퇴 (기업, 개인)
	 * @param session
	 * @return
	 */
	@RequestMapping("deleteMember.do")
	public String deleteMember(HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		String normalId = mvo.getId();
		if (normalId != null) {
			memberService.deleteMember(normalId);
			session.invalidate();
		}
		return "home.tiles";
	}
}
