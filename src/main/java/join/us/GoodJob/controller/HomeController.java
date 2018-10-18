package join.us.GoodJob.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.vo.PostListVO;

@Controller
public class HomeController {
@Resource
CompanyService companyService;
	@RequestMapping("home.do")
	public String Home(Model model) {
		//181017 MIRI
		//181018 yosep
		PostListVO postListVO = companyService.getAllCompanyList("1");
		model.addAttribute("postListVO", postListVO);		
		return "home.tiles";
	}
		
}
