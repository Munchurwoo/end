package join.us.GoodJob.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.NormalService;
import join.us.GoodJob.model.vo.PortfolioVO;

@Controller
public class NormalController {
	@Resource
	NormalService normalService;
	
	@RequestMapping("PortfolioRegister.do")
	public String PortfolioRegister(PortfolioVO vo) {
		return "result";
	}
	
	@RequestMapping("insertNormalMemberForm.do")
	public String insertNormalMemberForm() {
		return "normal/normal_register_form.tiles2";
	}
}
