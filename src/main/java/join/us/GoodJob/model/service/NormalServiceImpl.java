package join.us.GoodJob.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.NormalMapper;
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

	//181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*@Override
	public void deleteNormalMember(String normalId) {
		normalMapper.deleteNormalMember(normalId);
	}*/
	
	//181018 MIRI selectNormalMember와 중복으로 주석
	/*@Override
	public NormalMemberVO myPageNormalMember(String memberId) {
		return normalMapper.myPageNormalMember(memberId);
	}*/

	@Override
	public void registerPortfolio(PortfolioVO portfolioVO) {
		System.out.println(portfolioVO);
			
		//포트폴리오 등록(PORTFOLIO)
		normalMapper.insertPortfolio(portfolioVO);
		
		//포트폴리오 파일등록(PORTFOLIO_FILE) 보류
		//normalMapper.insertPortfolioFile(portfolioVO);
		
		//포트폴리오 분류 등록 시작
		Map<String, String> map = new HashMap<String, String>();
		map.put("normalId", portfolioVO.getNormalId());
		
		//포트폴리오 학력 분류 등록(PORTFOLIO_ACADEMIC)
		for(String academicNum :portfolioVO.getAcaCatNumList()) {
			map.put("academicNum", academicNum);
			normalMapper.insertPortfolioAcademic(map);			
		}
		
		//포트폴리오 개발분야 분류 등록(PORTFOLIO_DEV)
		for(String devCatNum :portfolioVO.getDevCatNumList()) {
			map.put("devCatNum", devCatNum);
			normalMapper.insertPortfolioDev(map);
		}
		
		//포트폴리오 고용형태 분류 등록(PORTFOLIO_EMP)
		for(String empTypeNum :portfolioVO.getEmpTypeCatNumList()) {
			map.put("empTypeNum", empTypeNum);
			normalMapper.insertPortfolioEmp(map);
		}
		
		//포트폴리오 지역 분류 등록(PORTFOLIO_LOC)
		for(String locNum :portfolioVO.getLocCatNumList()) {
			map.put("locNum", locNum);
			normalMapper.insertPortfolioLoc(map);
		}
		//포트폴리오 모집직군 분류 등록(PORTFOLIO_RECRUITMENT)
		for(String rcNum :portfolioVO.getRecruitCatNumList()) {
			map.put("rcNum", rcNum);
			normalMapper.insertPortfolioRecuitment(map);	
		}		
	}
		
	public PortfolioVO normalDetailPortfolio(String normalId) {
		return normalMapper.normalDetailPortfolio(normalId);
	}

	@Override
	public List<NormalMemberVO> idName() {
		return normalMapper.idName();
	}

	@Override
	public PortfolioVO portFolioVOById(String nomalId) {
		return normalMapper.portFolioVOById(nomalId);
	}

	@Override
	public void deletePortfolio(String id) {
		normalMapper.deletePortfolio(id);
	}

}
