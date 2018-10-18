package join.us.GoodJob;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.service.CompanyService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class SungjinUnitTest {
	@Autowired
	CompanyService companyService;

	/*@Autowired
	NormalMapper normalMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	ManagerMapper managerMapper;*/	
	@Autowired
	CompanyMapper companyMapper;
	@Test
	public void test() {
		HashMap map=new HashMap();
		List<String> devCatNumList=new ArrayList<String>();
		List<String> recruitCatNumList=new ArrayList<String>();
		List<String> empTypeCatNumList=new ArrayList<String>();
		List<String> locCatNumList=new ArrayList<String>();
		List<String> acaCatNumList=new ArrayList<String>();
		devCatNumList.add("201");
		devCatNumList.add("227");
		recruitCatNumList.add("101");
		recruitCatNumList.add("106");
		empTypeCatNumList.add("302");
		empTypeCatNumList.add("304");
		locCatNumList.add("501");
		locCatNumList.add("502");
		acaCatNumList.add("403");
		map.put("devCatNumList", devCatNumList);
		map.put("recruitCatNumList", recruitCatNumList);
		map.put("empTypeCatNumList", empTypeCatNumList);
		map.put("locCatNumList", locCatNumList);
		map.put("acaCatNumList", acaCatNumList);
		System.out.println(companyMapper.findJobPostingByCatNumList(map));
		
	}
}
