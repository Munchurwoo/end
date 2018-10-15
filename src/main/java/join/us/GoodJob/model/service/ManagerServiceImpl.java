package join.us.GoodJob.model.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.ManagerMapper;

@Service
public class ManagerServiceImpl implements ManagerService {
	@Resource
	ManagerMapper managerMapper;
}
