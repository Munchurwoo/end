package join.us.GoodJob.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.vo.CompanyMemberVO;

@Controller
public class CompanyController {
	@Resource
	CompanyService companyService;
	
	@RequestMapping("user-registerCompanyMemberForm.do")
	public String registerCompanyMemberForm() {
		return "company/company_register_form.tiles2";
	}
	@PostMapping("user-registerCompanyMember.do")
	public String registerCompanyMember(CompanyMemberVO companyMemberVO) {
		companyService.registerCompanyMember(companyMemberVO);
		System.out.println(companyMemberVO);
		return "redirect:user-loginForm.do";
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
	public String myPageCompanyMember(String companyId,Model model, HttpSession session) {
		model.addAttribute("cmvo",companyService.myPageCompanyMember(companyId));
		return "company/company_mypage.tiles2";
	}
}
