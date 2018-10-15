package join.us.GoodJob.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.MemberService;

@Controller
public class MemberController {
	@Resource
	MemberService memberService;

	@RequestMapping("loginForm.do")
	public String login() {
		return "member/login_form.tiles2";
	}
	
	
}
