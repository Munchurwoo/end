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

	// 기업 회원 탈퇴
	void deleteCompanyMember(String companyId);

	// 기업 마이페이지 상세
	CompanyMemberVO myPageCompanyMember(String companyId);
	
	//인재검색 서비스 
	NormalMemberVO memberSearch();
	

	// 기업정보 전체조회
	List<MemberVO> getAllCompanyList(MemberVO memberVO);

	// 기업정보 상세보기
	CompanyMemberVO detailCompanyInfo(String companyId);

	// 구인 상세
	JobPostingVO jobPostingDetail(String companyNum);
}
