package join.us.GoodJob.model.service;

import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.MemberVO;

public interface CompanyService {
	
	//기업 회원 가입
	void registerCompanyMember(CompanyMemberVO companyMemberVO);
	
	//기업 로그인
	MemberVO loginCompanyMember(MemberVO memberVO);
	
	//기업 검색
	CompanyMemberVO selectCompanyMember(String id);
	
	//기업 회원정보 수정
	void updateCompanyMember(CompanyMemberVO companyMemberVO);

	//기업 회원 탈퇴
	void deleteCompanyMember(String companyId);

}
