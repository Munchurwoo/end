package join.us.GoodJob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.dao.CompanyDAO;
import join.us.GoodJob.model.dao.ManagerDAO;
import join.us.GoodJob.model.dao.MemberDAO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class GoodJobUnitTest {
	@Autowired
	MemberDAO memberDAO;
	@Autowired
	CompanyDAO companyDAO;
	@Autowired
	ManagerDAO managerDAO;
	
	@Test
	public void test() {				
				
	}
		
}
