package join.us.GoodJob.model.service;

import join.us.GoodJob.model.mapper.NormalMapper;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.vo.NormalMemberVO;

@Service
public class NormalServiceImpl implements NormalService {
	@Resource
	NormalMapper normalMapper;

	@Override
	public void registerNormalMember(NormalMemberVO normalMemberVO) {
		normalMapper.insertMember(normalMemberVO);
		//memberMapper.insertNormalMember(normalMemberVO);
	}

	
	@Override
	public void updateNormalMember(NormalMemberVO normalMemberVO) {
	}

	@Override
	public void deleteNormalMember(String normalId) {
	}

}
