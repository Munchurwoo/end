package join.us.GoodJob.model.service;

import java.util.List;

import join.us.GoodJob.model.vo.CompanyMemberVO;

import join.us.GoodJob.model.vo.MemberVO;

import join.us.GoodJob.model.vo.JobPostingVO;
import join.us.GoodJob.model.vo.NormalMemberVO;

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
	

	// 기업정보 전체조회
	List<MemberVO> getAllCompanyList();

	// 기업정보 상세보기
	CompanyMemberVO detailCompanyInfo(String companyId);
	
	// 기업정보 상세보기 후 해당 기업 구인공고리스트 바로가기
	List<JobPostingVO> companyJobPostingList(String companyId);
	
	// 구인 상세
	CompanyMemberVO jobPostingDetail(String jobPostingNum);
}
