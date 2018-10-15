package join.us.GoodJob;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.mapper.ManagerMapper;
import join.us.GoodJob.model.mapper.MemberMapper;
import join.us.GoodJob.model.mapper.NormalMapper;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;
import join.us.GoodJob.model.vo.QuestionAnswerVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class GoodJobUnitTest {
	@Autowired
	NormalMapper normalMapper;
	@Autowired
	CompanyMapper companyMapper;
	
	@Autowired
	ManagerMapper managerMapper;
	@Autowired
	MemberMapper memberMapper;
	@Test
	public void test() {			
		
		//개인 회원가입 테스트
		/*MemberVO mvo=new MemberVO();		
		mvo.setId("test");
		mvo.setPassword("1234");
		mvo.setEmail("test@test.com");
		mvo.setName("test성진");
		mvo.setTel("01044223318");
		mvo.setAddress("test안양");
		normalMapper.insertMember(mvo);*/
		
		/*노멀 멤버 insert 테스트
		NormalMemberVO nvo=new NormalMemberVO();
		nvo.setCareerStatus("test1년");
		nvo.setGender("test남자");
		nvo.setNormalId("test");
		nvo.setPicturePath("test경로");
		normalMapper.insertNormalMember(nvo);*/
		
		QuestionAnswerVO qavo = new QuestionAnswerVO("miriTest", "1", "qqq", "aaa");
		List<QuestionAnswerVO> qavoList = new ArrayList<QuestionAnswerVO>();
		qavoList.add(qavo);
		PortfolioVO pvo = new PortfolioVO(null, null, null, null, null, null, null, null, null, null, null, null);
		
		NormalMemberVO nmvo = new NormalMemberVO("miri", "서미리.png", ".net", "여", pvo, qavoList);
		normalMapper.updateNormalMember(nmvo);
	}
	
}
