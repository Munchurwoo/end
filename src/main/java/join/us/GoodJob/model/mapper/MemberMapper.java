package join.us.GoodJob.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import join.us.GoodJob.model.vo.AcaCatVO;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.EmpTypeCatVO;
import join.us.GoodJob.model.vo.LocCatVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.RecruitCatVO;

@Mapper
public interface MemberMapper {
	// 개인,기업 로그인(MEMBER)
	MemberVO loginMember(MemberVO memberVO);
	//개인,기업 아이디 중복 검사(MEMBER)
	int checkMemberId(String id);

	List<RecruitCatVO> getRecruitCatVOList();

	List<DevCatVO> getDevCatVOListByrcNum(String rcNum);

	List<EmpTypeCatVO> getEmpTypeCatVOList();

	List<LocCatVO> getLocCatVOList();

	List<AcaCatVO> getAcaCatVOList();

	// 구인공고 번호로 개발 분야 분류 리스트 받아오기
	List<DevCatVO> getDevCatVOListByNum(String jobPostingNum);

	// 구인공고 번호로 지역 분류 리스트 받아오기
	List<LocCatVO> getLocCatVOListByNum(String jobPostingNum);

	// 구인공고 번호로 모집직군 분류 리스트 받아오기
	List<RecruitCatVO> getRecruitCatVOListByNum(String jobPostingNum);

	// 구인공고 번호로 학력 분류 리스트 받아오기
	List<AcaCatVO> getAcaCatVOListByNum(String jobPostingNum);

	// 구인공고 번호로 고용형태 분류 리스트 받아오기
	List<EmpTypeCatVO> getEmpCatVOListByNum(String jobPostingNum);

	// 포트폴리오 노말아이디로 개발 분야 분류 리스트 받아오기
	List<DevCatVO> getDevCatVOListByNormalId(String normalId);

	// 포트폴리오 노말아이디로 지역 분류 리스트 받아오기
	List<LocCatVO> getLocCatVOListByNormalId(String normalId);

	// 포트폴리오 노말아이디로 모집직군 분류 리스트 받아오기
	List<RecruitCatVO> getRecruitCatVOListByNormalId(String normalId);

	// 포트폴리오 노말아이디로 학력 분류 리스트 받아오기
	List<AcaCatVO> getAcaCatVOListByNormalId(String normalId);

	// 포트폴리오 노말아이디로 고용형태 분류 리스트 받아오기
	List<EmpTypeCatVO> getEmpCatVOListByNormalId(String normalId);
}
