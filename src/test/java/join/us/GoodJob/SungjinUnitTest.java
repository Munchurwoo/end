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
import join.us.GoodJob.model.service.PagingBean;
import join.us.GoodJob.model.vo.CatNumParamVO;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.InterviewVO;
import join.us.GoodJob.model.vo.JobPostingVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class SungjinUnitTest {
	/*@Autowired
	CompanyService companyService;
*/
	/*@Autowired
	NormalMapper normalMapper;*/
	
	/*@Autowired
	MemberMapper memberMapper;
	@Autowired
	ManagerMapper managerMapper;*/
	@Autowired
	CompanyMapper companyMapper;
	@Test
	public void test() {
		String companyId="NHNuser";
		String jobPostingNum="1003";
		String normalId="hsj";
		InterviewVO interviewVO=new InterviewVO();
		interviewVO.setCompanyId(companyId);
		interviewVO.setJobPostingNum(jobPostingNum);
		interviewVO.setNormalId(normalId);
	System.out.println(companyMapper.interviewInfo(interviewVO));
		
	}
}
