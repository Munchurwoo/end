package join.us.GoodJob.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;

@Mapper
public interface NormalMapper {
	//개인 회원가입(NORMAL_MEMBER)
	void registerNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원가입(MEMBER)
	void registerMember(MemberVO memberVO);
	//개인 회원정보 검색(NORMAL_MEMBER)
	NormalMemberVO selectNormalMember(String id);
	//개인 회원정보 수정(NORMAL_MEMBER)
	void updateNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원정보 수정(MEMBER)
	void updateMember(MemberVO memberVO);
		
	//개인 회원탈퇴(MEMBER) --> normal_member의 튜플은 cascade 자동삭제
	void deleteNormalMember(String normalId);
	
	// 마이페이지 개인정보 조회(MEMBER)
	NormalMemberVO myPageNormalMember(String memberId);
	//포트폴리오 등록(PORTFOLIO)
	void insertPortfolio(PortfolioVO portfolioVO);				
	//포트폴리오 파일등록(PORTFOLIO_FILE)
	void insertPortfolioFile(Map<String, String> map);
	//포트폴리오 개발분야 분류 등록(PORTFOLIO_DEV)
	void insertPortfolioDev(Map<String, String> map);
	//포트폴리오 모집직군 분류 등록(PORTFOLIO_RECRUITMENT)
	void insertPortfolioRecuitment(Map<String, String> map);
	//포트폴리오 고용형태 분류 등록(PORTFOLIO_EMP)
	void insertPortfolioEmp(Map<String, String> map);
	//포트폴리오 지역 분류 등록(PORTFOLIO_LOC)
	void insertPortfolioLoc(Map<String, String> map);	
	//포트폴리오 학력 분류 등록(PORTFOLIO_ACADEMIC)
	void insertPortfolioAcademic(Map<String, String> map);
	
	//포트폴리오 전체보기
	//포트폴리오 검색결과 보기
	//포트폴리오 상세보기
	PortfolioVO normalDetailPortfolio(String normalId);	
	//포트폴리오 삭제
	//포트폴리오 수정
	
	/**
	 * 인재정보 need data 
	 * 개인회원 모든 정보 받아오기 
	 * @return
	 */
	List<NormalMemberVO> AllFindNomarMember();
	
	PortfolioVO portFolioVOById(String nomalId);
	List<PortfolioVO> normalDetailPortfolioList(String normalId);
	
	//질의응답 질문등록
}
