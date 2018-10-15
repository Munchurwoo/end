package join.us.GoodJob.model.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.MemberMapper;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	MemberMapper memberMapper;

	@Override
	public void registerNormalMember(NormalMemberVO normalMemberVO) {
	}

	@Override
	public MemberVO loginNomalMember(MemberVO memberVO) {
		return null;
	}

	@Override
	public void updateNormalMember(NormalMemberVO normalMemberVO) {
	}

	@Override
	public void deleteNormalMember(String normalId) {
	}
	
	
	
	
	
	
}
