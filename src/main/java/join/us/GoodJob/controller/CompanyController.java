package join.us.GoodJob.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;

@Controller
public class CompanyController {
	@Resource
	CompanyService companyService;
	
	@RequestMapping("insertCompanyMemberForm.do")
	public String insertCompanyMemberForm() {
		return "company/company_register_form.tiles2";
	}
}
