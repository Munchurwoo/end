package join.us.GoodJob;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.mapper.NormalMapper;
import join.us.GoodJob.model.vo.MemberVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class GoodJobUnitTest {

	@Autowired
	NormalMapper normalMapper;

	/*@Autowired
	NormalMapper normalMapper;*/
	/*@Autowired
	CompanyMapper companyMapper;*/
	/*@Autowired
	ManagerMapper managerMapper;
	*/
	@Test
	public void test() {				
		MemberVO mvo=new MemberVO();
		mvo.setId("miri");
		List<MemberVO> lvo=normalMapper.getNormalMypageInfo(mvo);
		System.out.println(lvo);
		
	
	}
		
}
