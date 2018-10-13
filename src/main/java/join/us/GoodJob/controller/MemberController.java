package join.us.GoodJob.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.vo.PortfolioVO;

@Controller
public class MemberController {
	@Resource
	CompanyService companyService;
	

	
	@RequestMapping("PortfolioRegister.do")
	public String PortfolioRegister(PortfolioVO vo) {
		
		
		return "result";
	}

}
