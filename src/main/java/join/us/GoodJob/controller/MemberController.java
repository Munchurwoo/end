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
<<<<<<< HEAD

	@RequestMapping("PortfolioRegister.do")
	public String PortfolioRegister(PortfolioVO vo) {

		return "result";
	}
=======
	
	@RequestMapping("loginForm.do")
	public String login() {
		
		return "member/login_form.tiles2";
		
	}
	@RequestMapping("PortfolioRegister.do")
	public String PortfolioRegister(PortfolioVO vo) {
		return "result";
	}
	@RequestMapping("loginForm.do")
	public String loginForm() {
		return "member/login_form.tiles";
		
	}
	
	
	
	

>>>>>>> a49f7709ac9d61d93e2eab7108f453a708c65d6b
}
