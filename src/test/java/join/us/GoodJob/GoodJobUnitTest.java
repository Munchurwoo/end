package join.us.GoodJob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.mapper.ManagerMapper;
import join.us.GoodJob.model.mapper.MemberMapper;
import join.us.GoodJob.model.mapper.NormalMapper;
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
		
	}
	
}
