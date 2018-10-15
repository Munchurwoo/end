package join.us.GoodJob.model.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.NormalMapper;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;

@Service
public class NormalServiceImpl implements NormalService {
	@Resource
	NormalMapper normalMapper;

	@Override
	public void registerNormalMember(NormalMemberVO normalMemberVO) {
		normalMapper.insertMember(normalMemberVO);
		normalMapper.insertNormalMember(normalMemberVO);
	}
	
	@Override
	public void updateNormalMember(NormalMemberVO normalMemberVO) {
		//updateMember(memberVO);
		normalMapper.updateNormalMember(normalMemberVO);
	}
	
	public void updateMember(MemberVO memberVO) {
		normalMapper.updateMember(memberVO);
	}

	@Override
	public void deleteNormalMember(String normalId) {
	}

}
