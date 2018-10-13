package join.us.GoodJob.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import join.us.GoodJob.model.service.CompanyService;

@Controller
public class CompanyController {
	@Resource
	CompanyService companyService;

}
