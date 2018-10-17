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
public class DonggyuUnitTest {

	@Autowired
	NormalMapper normalMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	ManagerMapper managerMapper;	
	@Autowired
	CompanyMapper companyMapper;
	@Test
	public void test() {
		System.out.println(memberMapper.getAcaCatVOListByNormalId("yosep"));
		System.out.println(memberMapper.getDevCatVOListByNormalId("yosep"));
		System.out.println(memberMapper.getEmpCatVOListByNormalId("yosep"));
		System.out.println(memberMapper.getLocCatVOListByNormalId("yosep"));
		System.out.println(memberMapper.getRecruitCatVOListByNormalId("yosep"));
		System.out.println(normalMapper.normalDetailPortfolio("yosep"));
	}
}
