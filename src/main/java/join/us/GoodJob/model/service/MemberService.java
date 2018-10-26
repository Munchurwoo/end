package join.us.GoodJob.model.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import join.us.GoodJob.model.vo.AcaCatVO;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.EmpTypeCatVO;
import join.us.GoodJob.model.vo.LocCatVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.RecruitCatVO;

public interface MemberService {
	// 개인, 기업 로그인
	MemberVO loginMember(MemberVO memberVO);

	//개인, 기업 아이디 중복 검사
	int checkMemberId(String id);
	
	//개인, 기업 회원 탈퇴
	void deleteMember(String normalId);
	
	//모집직군 분류 리스트 받아오기
	List<RecruitCatVO> getRecruitCatVOList();

	// 개발분야 분류 리스트 받아오기(모집직군 번호로)
	List<DevCatVO> getDevCatVOListByrcNum(String rcNum);

	// 고용형태 분류 리스트 받아오기
	List<EmpTypeCatVO> getEmpTypeCatVOList();

	// 지역 분류 리스트 받아오기
	List<LocCatVO> getLocCatVOList();

	// 학력 분류 리스트 받아오기
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
	
	void pictureUpload(String member, MultipartFile uploadPicture, HttpServletRequest request);

	void pictureDelete(String member, String deletePicturename);
}
