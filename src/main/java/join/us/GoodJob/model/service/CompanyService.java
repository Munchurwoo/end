package join.us.GoodJob.model.service;

import java.util.List;
import java.util.Map;

import join.us.GoodJob.model.vo.CatNumParamVO;
import join.us.GoodJob.model.vo.CompanyMemberVO;
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
	List<CompanyMemberVO> getAllJobPostingList();

	// 기업정보 전체조회
	PostListVO getAllCompanyList(String pageNum);

	// 기업정보 상세보기
	CompanyMemberVO detailCompanyInfo(String companyId);
	
	// 기업정보 상세보기 후 해당 기업 구인공고리스트 바로가기
	List<JobPostingVO> companyJobPostingList(String companyId);
	
	// 마이바티스 동적쿼리 테스트 완료 - 정상작동
	List<String> findJobPostingByCatNumList(Map map);
	
	// 구인 상세
	CompanyMemberVO jobPostingDetail(String jobPostingNum);

	List<CompanyMemberVO> getSomeCompanyList(CatNumParamVO catNumParamVO);
	
	//구인등록
	void registerJobPosting(JobPostingVO jobPostingVO);
	
	//구인 공고별 질답 리스트
	List<QuestionAnswerVO> getJobPostingQAList(String jobPostingNum);
}
