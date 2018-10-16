package join.us.GoodJob.model.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import join.us.GoodJob.model.service.PagingBean;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.MemberVO;

@Mapper
public interface CompanyMapper {
	
	//기업 회원가입(COMPANY_MEMBER)
	void registerCompanyMember(CompanyMemberVO companyMemberVO);
	//기업 회원가입(MEMBER)
	void registerMember(MemberVO memberVO);
	
	//기업 로그인(MEMBER)
	MemberVO loginNormalMember(MemberVO memberVO);
	
	//기업 회원정보 수정(COMPANY_MEMBER,)
	void updateCompanyMember(CompanyMemberVO companyMemberVO);
	//기업 회원정보 수정(MEMBER)
	void updateMember(MemberVO memberVO);
		
	//기업 회원탈퇴(MEMBER) ->company_member의 튜플은 CASCADE 삭제됨
	void deleteCompanyMember(String companyId);
	
	//기업 마이페이지 상세보기
	CompanyMemberVO myPageCompanyMember(String companyId);
	
	
	
	
	
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
	
	
	
	
	//구인공고 등록
	//구인공고 키워드 등록	
	//구인공고 개발분야 분류 등록	
	//구인 모집직군 분류 등록
	//구인 고용형태 분류 등록
	//구인 지역 분류 등록
	//구인 분류 등록
	//구인 학력 분류 등록	
		
	//구인공고 전체보기
	//구인공고 검색결과 보기
	//구인공고 상세보기
	
	
	//질의응답 답변 등록
	
	
	
	
	
	
	
}
