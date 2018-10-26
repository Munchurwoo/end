package join.us.GoodJob.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.service.NormalService;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;
import join.us.GoodJob.model.vo.PostListVO;

@Controller
public class HomeController {
@Resource
CompanyService companyService;
@Resource
NormalService normalService;
	@RequestMapping("home.do")
	public String Home(Model model) {
		//181017 MIRI
		//181018 yosep
		PostListVO postListVO = companyService.getAllCompanyList("1");
		model.addAttribute("postListVO", postListVO);		
		List<PortfolioVO> pvo=normalService.getNormalMember("1");
		model.addAttribute("pvo", pvo);
		return "home.tiles";
	}
		
}
