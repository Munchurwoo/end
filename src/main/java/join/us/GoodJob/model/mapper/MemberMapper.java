package join.us.GoodJob.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import join.us.GoodJob.model.vo.MemberVO;

@Mapper
public interface MemberMapper {	
	//개인,기업 로그인(MEMBER)
	MemberVO loginNomalMember(MemberVO memberVO);

	
	
	
}
