package join.us.GoodJob.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.MemberVO;

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
	 * 181015 MIRI 기업 회원정보 수정(COMPANY_MEMBER)
	 * @param companyMemberVO
	 * @return
	 */
	@RequestMapping("updateCompanyMemberForm.do")
	public String updateCompanyMemberForm(HttpSession session, Model model) {
		MemberVO mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo != null) {
			CompanyMemberVO cmvo = companyService.selectCompanyMember(mvo.getId());
			model.addAttribute("cmvo", cmvo);
		}
		return "company/company_update_form.tiles2";
	}
	@PostMapping("updateCompanyMember.do")
	public String updateCompanyMember(CompanyMemberVO companyMemberVO) {
		companyService.updateCompanyMember(companyMemberVO);
		return "redirect:home.do";
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
