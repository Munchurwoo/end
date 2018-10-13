package join.us.GoodJob.model.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.dao.ManagerDAO;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Resource
	ManagerDAO managerDAO;
}
