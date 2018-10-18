package join.us.GoodJob.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.MemberMapper;
import join.us.GoodJob.model.vo.AcaCatVO;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.EmpTypeCatVO;
import join.us.GoodJob.model.vo.LocCatVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.RecruitCatVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	MemberMapper memberMapper;

	@Override
	public MemberVO loginMember(MemberVO memberVO) {
		return memberMapper.loginMember(memberVO);
	}

	@Override
	public int checkMemberId(String id) {
		return memberMapper.checkMemberId(id);
	}
	
	@Override
	public void deleteMember(String normalId) {
		memberMapper.deleteMember(normalId);
	}

	@Override
	public List<RecruitCatVO> getRecruitCatVOList() {
		return memberMapper.getRecruitCatVOList();
	}

	@Override
	public List<DevCatVO> getDevCatVOListByrcNum(String rcNum) {
		return memberMapper.getDevCatVOListByrcNum(rcNum);
	}

	@Override
	public List<EmpTypeCatVO> getEmpTypeCatVOList() {
		return memberMapper.getEmpTypeCatVOList();
	}

	@Override
	public List<LocCatVO> getLocCatVOList() {
		return memberMapper.getLocCatVOList();
	}

	@Override
	public List<AcaCatVO> getAcaCatVOList() {
		return memberMapper.getAcaCatVOList();
	}

	@Override
	public List<DevCatVO> getDevCatVOListByNum(String jobPostingNum) {
		return memberMapper.getDevCatVOListByNum(jobPostingNum);
	}

	@Override
	public List<LocCatVO> getLocCatVOListByNum(String jobPostingNum) {
		return memberMapper.getLocCatVOListByNum(jobPostingNum);
	}

	@Override
	public List<RecruitCatVO> getRecruitCatVOListByNum(String jobPostingNum) {
		return memberMapper.getRecruitCatVOListByNum(jobPostingNum);
	}

	@Override
	public List<AcaCatVO> getAcaCatVOListByNum(String jobPostingNum) {
		return memberMapper.getAcaCatVOListByNum(jobPostingNum);
	}

	@Override
	public List<EmpTypeCatVO> getEmpCatVOListByNum(String jobPostingNum) {
		return memberMapper.getEmpCatVOListByNum(jobPostingNum);
	}

	@Override
	public List<DevCatVO> getDevCatVOListByNormalId(String normalId) {
		return memberMapper.getDevCatVOListByNormalId(normalId);
	}

	@Override
	public List<LocCatVO> getLocCatVOListByNormalId(String normalId) {
		return memberMapper.getLocCatVOListByNormalId(normalId);
	}

	@Override
	public List<RecruitCatVO> getRecruitCatVOListByNormalId(String normalId) {
		return memberMapper.getRecruitCatVOListByNormalId(normalId);
	}

	@Override
	public List<AcaCatVO> getAcaCatVOListByNormalId(String normalId) {
		return memberMapper.getAcaCatVOListByNormalId(normalId);
	}

	@Override
	public List<EmpTypeCatVO> getEmpCatVOListByNormalId(String normalId) {
		return memberMapper.getEmpCatVOListByNormalId(normalId);
	}
}
