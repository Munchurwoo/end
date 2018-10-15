package join.us.GoodJob.model.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.NormalMapper;
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
		normalMapper.updateNormalMember(normalMemberVO);
		normalMapper.updateMember(normalMemberVO);
	}
	
	@Override
	public NormalMemberVO selectNormalMember(String id) {
		return normalMapper.selectNormalMember(id);
	}

	@Override
	public void deleteNormalMember(String normalId) {
	}

}
