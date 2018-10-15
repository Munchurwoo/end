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
	
	@RequestMapping("registerNormalMemberForm.do")
	public String registerNormalMemberForm() {
		return "normal/normal_register_form.tiles2";
	}
	
	@RequestMapping("registerNormalMember.do")
	public String registerNormalMember(NormalMemberVO normalMemberVO,String gender) {
		System.out.println(gender);
		if(gender.equals("man")) {
			System.out.println(gender);
		normalService.registerNormalMember(normalMemberVO);
		}
		else {
			System.out.println(gender);
		normalService.registerNormalMember(normalMemberVO);
		}
		return "normal/normal_register_portfolio.tiles2";
	}
	
}
