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
}
