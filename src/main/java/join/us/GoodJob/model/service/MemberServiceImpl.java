package join.us.GoodJob.model.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.MemberMapper;
import join.us.GoodJob.model.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	MemberMapper memberMapper;



	
	@Override
	public MemberVO loginMember(MemberVO memberVO) {
		return memberMapper.loginMember(memberVO);
	}
	
	
}
