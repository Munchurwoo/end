package join.us.GoodJob.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import join.us.GoodJob.model.service.PagingBean;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.InterviewVO;
import join.us.GoodJob.model.vo.JobPostingVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.PostListVO;
import join.us.GoodJob.model.vo.QuestionAnswerVO;

@Mapper
public interface CompanyMapper {
	
	//기업 회원가입(COMPANY_MEMBER)
	void registerCompanyMember(CompanyMemberVO companyMemberVO);
	//기업 회원가입(MEMBER)
	void registerMember(MemberVO memberVO);
	//기업 로그인(MEMBER)
	MemberVO loginNormalMember(MemberVO memberVO);
	
	//기업 검색(COMPANy_MEMBER)
	CompanyMemberVO selectCompanyMember(String id);
	//기업 회원정보 수정(COMPANY_MEMBER,)
	void updateCompanyMember(CompanyMemberVO companyMemberVO);
	//기업 회원정보 수정(MEMBER)
	void updateMember(MemberVO memberVO);
		
	//181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*//기업 회원탈퇴(MEMBER) ->company_member의 튜플은 CASCADE 삭제됨
	void deleteCompanyMember(String companyId);*/
	
	//기업 마이페이지 상세보기
	CompanyMemberVO myPageCompanyMember(String companyId);
	
	//채용정보 클릭 후 전체 채용공고 조회하기
	List<CompanyMemberVO> getAllJobPostingList(PagingBean pagingBean);
	
	// 마이바티스 동적쿼리 테스트 완료 - 정상작동
	List<String> findJobPostingByCatNumList(Map map);
	
	//기업 전체 리스트 개수 구하기(COMPANY_MEMBER)
	int getAllCompanyMemberCount();
	//기업 전체 리스트 보기(COMPANY_MEMBER,MEMBER)
	List<CompanyMemberVO> getAllCompanyMemberList(PagingBean pagingBean);
	
	//이름으로 기업검색 리스트 개수 구하기(COMPANY_MEMBER,MEMBER)
	int getSomeCompanyMemberCount(String companyName);
	//이름으로 기업검색 리스트 보기(COMPANY_MEMBER,MEMBER)
	List<CompanyMemberVO> getSomeCompanyMemberList(HashMap<String,Object> map);
		
	//기업 상세보기(COMPANY_MEMBER, MEMBER)	
	CompanyMemberVO getDetailCompanyMember(String companyId);
	

	//전체 기업정보 리스트 받아오기
	List<MemberVO> getAllCompanyList(PagingBean pagingBean);
	//전체 기업정보 리스트 개수 받아오기
	int getAllCompanyListCount();
	
	// 기업정보 상세보기
	CompanyMemberVO detailCompanyInfo(String companyId);
	// 기업정보 상세보기 후 해당기업 구인공고 리스트 바로가기
	List<JobPostingVO> companyJobPostingList(String companyId);
 	//구인공고 상세보기
 	CompanyMemberVO jobPostringDetail(String jobPostingNum);	
 	//구인공고 등록
 	void registerJobPosting(JobPostingVO jobPostingVO);
	//구인 학력 분류 등록	
	void registerJobPostingAcademic(Map<String,Object> map);
	//구인공고 개발분야 분류 등록	
	void registerJobPostingDev(Map<String, Object> map);
	//구인 고용형태 분류 등록
	void registerJobPostingEmp(Map<String, Object> map);
	//구인 지역 분류 등록
	void registerJobPostingLoc(Map<String,Object> map);
	//구인 모집직군 분류 등록
	void registerJobPostingRecuitment(Map<String,Object> map);
	//181022 MIRI 구인 공고별 질답 리스트
	List<QuestionAnswerVO> getJobPostingQAList(String jobPostingNum);
	//181022 MIRI QA번호로 Q&A 검색
	QuestionAnswerVO getJobPostingQAByQANum(String qaNum);
	//181022 MIRI Q&A 답변 수정
	void updateQAToAnswer(QuestionAnswerVO qavo);
	//181022 MIRI Q&A 답변 삭제
	void deleteQAToAnswer(String QANum);
	//구인공고 상세보기

	CompanyMemberVO jobPostingDetail(String jobPostingNum);
	// 면접신청자 조회 ->
	//List<InterviewVO> getAllInterviewerList(String companyId);
	// 미리 인재검색
	//List<InterviewVO> getAllInterviewerList2();
 	//구인공고 키워드 등록	
 	// 헤더/채용정보 페이징처리
	int getAlljobPostingCount();
	// 채용정보 상세검색 페이징처리
	int getAllJobPostingListByJobPostingNumCount(List<String> jobPostingNumList);
	List<CompanyMemberVO> getAllJobPostingListByJobPostingNum(Map<String, Object> map2);
	//181023 MIRI 구인 공고별 면접자 리스트
	List<InterviewVO> getJobPostingInterviewerList(String jobPostingNum, String pageNum);
	
	InterviewVO interviewInfo(InterviewVO interviewVO);

	// 구인공고 수정등록 
	void updateJobPosting(JobPostingVO jobPostingVO);
	// 구인공고 수정 전 전체 삭제 학력/개발분야/고용형태/지역/모집직군
	void deleteJobPostingMulti(int jobPostingNum);
	// 구인공고 삭제
	void deleteJobPostingByNum(int jobPostingNum);
	// 제목으로 구인공고 검색
	List<CompanyMemberVO> findJobPostingBytitle(Map<String, Object> map);
	//181025 MIRI 구인 공고별 면접자 리스트 카운트
	int jobPostingInterviewerTotalCount(String jobPostingNum);
	// 제목으로 구인공고 검색 페이징빈
	int findJobPostingBytitleCount(String title);
	// 키워드로 구인공고 검색 페이징빈
	int findJobPostingByKeywordCount(String searchText);
	// 키워드로 구인공고 검색
	List<CompanyMemberVO> findJobPostingByKeyword(Map<String, Object> map);
	// 구인공고번호로 기업아이디 찾기
		InterviewVO findCompanyIdByNum(String jobPostingNum);
	
	//구인 분류 등록	

	//구인공고 전체보기
	
	//구인공고 검색결과 보기
}
