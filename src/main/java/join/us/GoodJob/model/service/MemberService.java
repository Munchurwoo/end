package join.us.GoodJob.model.service;

import java.util.List;

import join.us.GoodJob.model.vo.AcaCatVO;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.EmpTypeCatVO;
import join.us.GoodJob.model.vo.LocCatVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.RecruitCatVO;

public interface MemberService {		
	//개인, 기업 로그인
	MemberVO loginMember(MemberVO memberVO);
	
	//모집직군 분류 리스트 받아오기
	List<RecruitCatVO> getRecruitCatVOList();
	//개발분야 분류 리스트 받아오기(모집직군 번호로)
	List<DevCatVO> getDevCatVOListByrcNum(String rcNum);
	//고용형태 분류 리스트 받아오기
	List<EmpTypeCatVO> getEmpTypeCatVOList();
	//지역 분류 리스트 받아오기
	List<LocCatVO> getLocCatVOList();
	//학력 분류 리스트 받아오기
	List<AcaCatVO> getAcaCatVOList();
}
