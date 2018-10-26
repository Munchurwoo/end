package join.us.GoodJob.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import join.us.GoodJob.model.service.PagingBean;
import join.us.GoodJob.model.vo.InterviewVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;
import join.us.GoodJob.model.vo.QuestionAnswerVO;

@Mapper
public interface NormalMapper {
	//개인 회원가입(NORMAL_MEMBER)
	void registerNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원가입(MEMBER)
	void registerMember(MemberVO memberVO);
	//개인 회원정보 검색(NORMAL_MEMBER)
	NormalMemberVO selectNormalMember(String normalId);
	//개인 회원정보 수정(NORMAL_MEMBER)
	void updateNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원정보 수정(MEMBER)
	void updateMember(MemberVO memberVO);
		
	//181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*//개인 회원탈퇴(MEMBER) --> normal_member의 튜플은 cascade 자동삭제
	void deleteNormalMember(String normalId);*/
	
	//181018 MIRI selectNormalMember와 중복으로 주석
	/*// 마이페이지 개인정보 조회(MEMBER)
	NormalMemberVO myPageNormalMember(String memberId);*/
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
	 * 10-22 am 8:39 최종수정 cherwoo
	 * 인재정보 need data 
	 * 개인회원 모든 정보 받아오기 
	 * @return
	 */
	List<NormalMemberVO> AllFindNomarMember();
	
	PortfolioVO portFolioVOById(String nomalId);
	
	//181019 MIRI normalDetailPortfolio와 중복되어 주석
	//List<PortfolioVO> normalDetailPortfolioList(String normalId);
	//포트폴리오 삭제
	void deletePortfolio(String id);

	// 구인공고 상세보기 후 면접신청하기
	NormalMemberVO submitInterview(String normalId);

	//포트폴리오 수정
	void updatePortfolio(PortfolioVO portfolioVO);
	//포트폴리오 삭제(portfolio_dev, portfolio_recruitment, portfolio_emp, portfolio_loc, portfolio_academic)
	void deletePortfolioMulti(String normalId);

	void interviewApply(InterviewVO interviewVO);

	//인재검색에서 상세검색 누르고 결과페이지 출력하는 SQL 철우, 건들지 말것.
	List<String> portfolioSearchList(PortfolioVO portfolioVO);

	//페이징 처리를 위한 게시풀 전체 수 받아오기
	int getAllMemberListCount();
	//페이징 처리 normal member 리스트 값 받아오기 < normal_id만 필요해서 id만 받아옴
	List<NormalMemberVO> getNormalMemberId(PagingBean pagingBean);
	
	//질의응답 질문등록
	void registerQuestion(QuestionAnswerVO qaVO);
	
	//질의응답 나의 질문 리스트
	
	//개인회원id로 포트폴리오 파일 경로 찾기
	List<String> getPortfolioFileList(String normalId);
	List<QuestionAnswerVO> getMyQuestionList(QuestionAnswerVO qaVO);
	
	List<PortfolioVO> getNormalMember(PagingBean pagingBean);
}
