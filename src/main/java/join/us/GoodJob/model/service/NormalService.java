package join.us.GoodJob.model.service;

import java.util.List;

import org.springframework.ui.Model;

import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;

public interface NormalService {
	
	//개인 회원 가입
	void registerNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원정보 수정
	void updateNormalMember(NormalMemberVO normalMemberVO);
	//181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*//개인 회원 탈퇴
	void deleteNormalMember(String normalId);*/
	//개인 회원 검색
	NormalMemberVO selectNormalMember(String id);
	//181018 MIRI selectNormalMember와 중복으로 주석
	/*//개인 정보 조회
	NormalMemberVO myPageNormalMember(String memberId);*/

	void registerPortfolio(PortfolioVO portfolioVO);
	
	//포트폴리오등록 상세
	PortfolioVO normalDetailPortfolio(String normalId);
	List<PortfolioVO> normalDetailPortfolioList(String normalId);
	
	// 구인공고 상세조회 후 면접신청하기
	NormalMemberVO submitInterview(String normalId);
	
	//개인회원 모든 정보 받아오기
	List<NormalMemberVO> AllFindNomarMember();
	
	//개인회원  id 를 활용하여 포트폴리오 모든 정보 출력 
	PortfolioVO portFolioVOById(String nomalId);
	//181018 MIRI 포트폴리오 삭제
	void deletePortfolio(String id); 
}
