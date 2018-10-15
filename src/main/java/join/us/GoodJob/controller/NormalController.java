package join.us.GoodJob.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.NormalService;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;

@Controller
public class NormalController {
	@Resource
	NormalService normalService;

	@RequestMapping("PortfolioRegister.do")
	public String PortfolioRegister(PortfolioVO vo) {
		return "result";
	}
	/**
	 * 181015 MIRI 개인 회원가입 폼(NORMAL_MEMBER)
	 * 
	 * @return
	 */
	@RequestMapping("registerNormalMemberForm.do")
	public String registerNormalMemberForm() {
		return "normal/normal_register_form.tiles2";
	}

	/**
	 * 181015 MIRI 개인회원 마이페이지
	 * 
	 * @return
	 */
	@RequestMapping("normal_mypage.do")
	public String companyMypage() {
		return "normal/normal_mypage.tiles2";
	}

	/**
	 * 181015 MIRI 개인 회원정보 수정(NORMAL_MEMBER)
	 * 
	 * @param normalMemberVO
	 * @return
	 */
	@RequestMapping("updateNormalMemberForm.do")
	public String updateNormalMemberForm(HttpSession session, Model model) {
		MemberVO mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo != null) {
			NormalMemberVO nmvo = normalService.selectNormalMember(mvo.getId());
			model.addAttribute("nmvo", nmvo);
		}
		return "normal/normal_update_form.tiles2";
	}
	
	@PostMapping("updateNormalMember.do")
	public String updateNormalMember(NormalMemberVO normalMemberVO) {
		normalService.updateNormalMember(normalMemberVO);
		return "redirect:home.do";
	}

	/**
	 * 181015 SJ
	 * 개인 회원가입 (NORMAL_MEMBER)
	 * @param normalMemberVO
	 * @param gender
	 * @return
	 */
	@RequestMapping("registerNormalMember.do")
	public String registerNormalMember(NormalMemberVO normalMemberVO,String gender) {

		normalService.registerNormalMember(normalMemberVO);
		
		return "normal/normal_register_portfolio.tiles2";
	}
}

