package join.us.GoodJob.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.NormalMapper;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;

@Service
public class NormalServiceImpl implements NormalService {
	@Resource
	NormalMapper normalMapper;

	@Override
	public void registerNormalMember(NormalMemberVO normalMemberVO) {
		normalMapper.registerMember(normalMemberVO);
		normalMapper.registerNormalMember(normalMemberVO);
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
		normalMapper.deleteNormalMember(normalId);
	}

	@Override
	public NormalMemberVO myPageNormalMember(String memberId) {
		return normalMapper.myPageNormalMember(memberId);
	}

	@Override
	public PortfolioVO normalDetailPortfolio(String normalId) {
		return normalMapper.normalDetailPortfolio(normalId);
	}

	@Override
	public List<NormalMemberVO> idName() {
		return normalMapper.idName();
	}

	@Override
	public List<PortfolioVO> portFolioVOList(String nomalId) {
		return normalMapper.portFolioVOList(nomalId);
	}

}
