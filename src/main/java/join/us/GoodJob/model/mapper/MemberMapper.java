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
	//개인,기업 로그인(MEMBER)
	MemberVO loginMember(MemberVO memberVO);

	List<RecruitCatVO> getRecruitCatVOList();

	List<DevCatVO> getDevCatVOListByrcNum(String rcNum);

	List<EmpTypeCatVO> getEmpTypeCatVOList();

	List<LocCatVO> getLocCatVOList();

	List<AcaCatVO> getAcaCatVOList();	
}
