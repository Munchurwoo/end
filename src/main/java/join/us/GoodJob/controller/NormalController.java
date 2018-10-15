package join.us.GoodJob.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.NormalService;
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
	 * 181015 MIRI
	 * 개인 회원가입 폼(NORMAL_MEMBER)
	 * @return
	 */
	@RequestMapping("insertNormalMemberForm.do")
	public String insertNormalMemberForm() {
		return "normal/normal_register_form.tiles2";
	}
	
	/**
	 * 181015 MIRI
	 * 개인 회원정보 수정(NORMAL_MEMBER)
	 * @param normalMemberVO
	 * @return
	 */
	@RequestMapping("updateNormalMember.do")
	public String updateNormalMember(NormalMemberVO normalMemberVO) {
		return "normal/normal_update_form.tiles2";
	}
	
	@RequestMapping("registerNormalMember.do")
	public String registerNormalMember(NormalMemberVO normalMemberVO) {
		normalService.registerNormalMember(normalMemberVO);
		return "normal/normal_register_portfolio.tiles2";
	}
	
	/**
	 * 181015 MIRI
	 * 개인회원 마이페이지
	 * @return
	 */
	@RequestMapping("normal_mypage.do")
	public String companyMypage() {
		return "normal/normal_mypage.tiles2";
	}
}
