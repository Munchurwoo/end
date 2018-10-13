package join.us.GoodJob.model.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.dao.CompanyDAO;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	CompanyDAO companyDAO;

}
