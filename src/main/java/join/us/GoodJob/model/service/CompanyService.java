package join.us.GoodJob.model.service;

import java.util.List;
import java.util.Map;

import join.us.GoodJob.model.vo.CatNumParamVO;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.InterviewVO;
import join.us.GoodJob.model.vo.JobPostingVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PostListVO;
import join.us.GoodJob.model.vo.QuestionAnswerVO;

public interface CompanyService {

	// 기업 회원 가입
	void registerCompanyMember(CompanyMemberVO companyMemberVO);

	// 기업 검색
	CompanyMemberVO selectCompanyMember(String id);

	// 기업 회원정보 수정
	void updateCompanyMember(CompanyMemberVO companyMemberVO);

	//181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*// 기업 회원 탈퇴
	void deleteCompanyMember(String companyId);*/

	// 기업 마이페이지 상세
	CompanyMemberVO myPageCompanyMember(String companyId);
	
	//인재검색 서비스 
	NormalMemberVO memberSearch();
	
	//채용정보 클릭 후 전체 채용공고 조회하기
	PostListVO getAllJobPostingList(String pageNum);

	// 기업정보 전체조회
	PostListVO getAllCompanyList(String pageNum);

	// 기업정보 상세보기
 	CompanyMemberVO detailCompanyInfo(String companyId);
	 	
 	// 기업정보 상세보기 후 해당 기업 구인공고리스트 바로가기
 	List<JobPostingVO> companyJobPostingList(String companyId);	
 	
 	// 구인 상세
 	CompanyMemberVO jobPostingDetail(String jobPostingNum);
	
 	// 상세조건 검색
	PostListVO findJobPostingByCatNumList(CatNumParamVO catNumParamVO, String pageNum);
	
	//구인등록 181023 MIRI가 만든것 재사용 포트폴리오 등록/수정 동시에 활용하기위해 flag를 줌
	void registerJobPosting(JobPostingVO jobPostingVO,boolean registerFlag);
	// 면접신청자 전체 조회
	//List<InterviewVO> getAllInterviewerList(String companyId);
	// 미리 인재검색
	//List<InterviewVO> getAllInterviewerList2();
	//구인 공고별 질답 리스트
	//181022 MIRI 구인 공고별 질답 리스트
	List<QuestionAnswerVO> getJobPostingQAList(String jobPostingNum);
	
	//181022 MIRI QA번호로 Q&A 검색
	QuestionAnswerVO getJobPostingQAByQANum(String qaNum);
	
 	//181022 MIRI Q&A 답변 수정
	void updateQAToAnswer(QuestionAnswerVO qavo);
	
	//181022 MIRI Q&A 답변 삭제
	void deleteQAToAnswer(String QANum);
	
	// 구인공고 수정
	void updateJobPosting(JobPostingVO jobPostingVO);
	// 구인공고 수정 전 테이블 비우기
	void deleteJobPostingMulti(int jobPostingNum);	
	// 채용정보 페이징처리

	void deleteJobPostingByNum(int jobPostingNum);

	PostListVO findJobPostingBytitle(String title,String keyword, String pageNum);

	//181023 MIRI 구인 공고별 면접자 리스트
	//PostListVO getJobPostingInterviewerList(String jobPostingNum, String pageNum);
	PostListVO getJobPostingInterviewerList(String jobPostingNum,String pageNum);
	
	//181025 MIRI 구인공고별 면접자 토탈 카운트
	int jobPostingInterviewerTotalCount(String jobPostingNum);

}
