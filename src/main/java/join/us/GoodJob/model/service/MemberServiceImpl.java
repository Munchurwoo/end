package join.us.GoodJob.model.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	MemberDAO memberDAO;
}
