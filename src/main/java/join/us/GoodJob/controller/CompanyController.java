package join.us.GoodJob.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.vo.CompanyMemberVO;

@Controller
public class CompanyController {
	@Resource
	CompanyService companyService;
	
	@RequestMapping("user-insertCompanyMemberForm.do")
	public String insertCompanyMemberForm() {
		return "company/company_register_form.tiles2";
	}
	@RequestMapping("user-insertCompanyMember.do")
	public String registerCompanyMember(CompanyMemberVO companyMemberVO) {
		companyService.registerCompanyMember(companyMemberVO);
		return "redirect:loginForm.do";
		
	}
	
	/**
	 * 181015 MIRI
	 * 기업 회원정보 수정(COMPANY_MEMBER)
	 * @param companyMemberVO
	 * @return
	 */
	@RequestMapping("updateCompanyMember.do")
	public String updateCompanyMember(CompanyMemberVO companyMemberVO) {
		return "company/company_update_form.tiles2";
	}
	
	
	/**
	 * 181015 MIRI
	 * 기업회원 마이페이지
	 * @return
	 */
	@RequestMapping("company_mypage.do")
	public String companyMypage() {
		return "company/company_mypage.tiles2";
	}
}
