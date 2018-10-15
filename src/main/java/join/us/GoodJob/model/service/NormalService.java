<<<<<<< HEAD
package join.us.GoodJob.model.service;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.vo.NormalMemberVO;


public interface NormalService {
	
	//개인 회원 가입
	void registerNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원정보 수정
	void updateNormalMember(NormalMemberVO normalMemberVO);
	
	//개인 회원 탈퇴
	void deleteNormalMember(String normalId);

}
=======
package join.us.GoodJob.model.service;

import join.us.GoodJob.model.vo.NormalMemberVO;


public interface NormalService {
	
	//개인 회원 가입
	void registerNormalMember(NormalMemberVO normalMemberVO);
	//개인 회원정보 수정
	void updateNormalMember(NormalMemberVO normalMemberVO);
	
	//개인 회원 탈퇴
	void deleteNormalMember(String normalId);

}
>>>>>>> branch 'master' of https://github.com/Munchurwoo/goodjob.git
