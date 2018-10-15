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
import join.us.GoodJob.model.vo.NormalMemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-model.xml" })
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
		NormalMemberVO nmvo = normalMapper.selectNormalMember("miri");
		NormalMemberVO nmvo2 = new NormalMemberVO();
		String id = nmvo.getId();
		if(nmvo != null) {
			nmvo2.setNormalId(id);
			nmvo2.setCareerStatus(".NET(C#) 개발 경력 2년 (마이다시아이티)");
			nmvo2.setPicturePath("서미리.png");
			normalMapper.updateNormalMember(nmvo2);
			
			nmvo2.setId(id);
			nmvo2.setAddress("경기도 성남시 중원구");
			nmvo2.setEmail("miri@gmail.com");
			nmvo2.setPassword("123");
			nmvo2.setTel("010-2222-2222");
			normalMapper.updateMember(nmvo2);
		}
	}

}
