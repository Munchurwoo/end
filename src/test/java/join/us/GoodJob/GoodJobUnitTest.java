
package join.us.GoodJob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.vo.CompanyMemberVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class GoodJobUnitTest {
	/*@Autowired
	NormalMapper normalMapper;*/
	@Autowired
	CompanyMapper companyMapper;
	/*@Autowired
	ManagerMapper managerMapper;
	*/
	@Test
	public void test() {	
		String id="asda";
		CompanyMemberVO cvo=companyMapper.myPageCompanyMember(id);
		System.out.println(cvo);
		
	
			
}
}
