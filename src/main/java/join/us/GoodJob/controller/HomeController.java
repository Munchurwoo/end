package join.us.GoodJob.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.vo.MemberVO;

@Controller
public class HomeController {
@Resource
CompanyService companyService;
	@RequestMapping("home.do")
	public String Home(Model model) {
		//181017 MIRI
		List<MemberVO> cmvoList=companyService.getAllCompanyList();
		model.addAttribute("cmvoList", cmvoList);
		return "home.tiles";
	}
		
}
