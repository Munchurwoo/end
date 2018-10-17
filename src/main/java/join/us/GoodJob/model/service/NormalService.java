package join.us.GoodJob.model.service;

import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;

public interface NormalService {
	
	//개인 회원 가입
	void registerNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원정보 수정
	void updateNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원 탈퇴
	void deleteNormalMember(String normalId);
	//개인 회원 검색
	NormalMemberVO selectNormalMember(String id);
	//개인 회원 아이디 중복 검사
	int checkNormalMemberId(String id);
	//개인 정보 조회
	NormalMemberVO myPageNormalMember(String memberId);
	//포트폴리오등록 상세
	PortfolioVO normalDetailPortfolio(String normalId);
}
