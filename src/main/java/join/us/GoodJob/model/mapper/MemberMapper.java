package join.us.GoodJob.model.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;

@Mapper
public interface MemberMapper {	
	//개인,기업 로그인(MEMBER)
	MemberVO loginMember(MemberVO memberVO);	
}
