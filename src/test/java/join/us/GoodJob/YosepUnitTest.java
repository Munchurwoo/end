package join.us.GoodJob;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.mapper.ManagerMapper;
import join.us.GoodJob.model.mapper.MemberMapper;
import join.us.GoodJob.model.mapper.NormalMapper;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class YosepUnitTest {

	@Autowired
	NormalMapper normalMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	ManagerMapper managerMapper;	
	
	@Test
	public void test() {
		System.out.println(memberMapper.getRecruitCatVOList());
		System.out.println(memberMapper.getDevCatVOListByrcNum("101"));
		System.out.println(memberMapper.getEmpTypeCatVOList());
		System.out.println(memberMapper.getLocCatVOList());
		System.out.println(memberMapper.getAcaCatVOList());
	}
}
