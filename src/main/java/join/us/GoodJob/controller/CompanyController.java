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
	
	@RequestMapping("insertCompanyMemberForm.do")
	public String insertCompanyMemberForm() {
		return "company/company_register_form.tiles2";
	}
	@RequestMapping("insertCompanyMember.do")
	public String registerCompanyMember(CompanyMemberVO companyMemberVO) {
		companyService.registerCompanyMember(companyMemberVO);
		return "redirect:loginForm.do";
		
	}
}
