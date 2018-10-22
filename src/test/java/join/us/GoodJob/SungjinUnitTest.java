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
		PagingBean pagingBean=new PagingBean(2);
		
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
	      CatNumParamVO cnp=new CatNumParamVO();
	      cnp.setAcaCatNumList(acaCatNumList);
	      cnp.setDevCatNumList(devCatNumList);
	      cnp.setEmpTypeCatNumList(empTypeCatNumList);
	      cnp.setLocCatNumList(locCatNumList);
	      cnp.setRecruitCatNumList(recruitCatNumList);
	      
	      
	      
		  Map<String, List<String>> map = new HashMap<String, List<String>>();
	      map.put("devCatNumList", cnp.getDevCatNumList());
	      map.put("recruitCatNumList", cnp.getRecruitCatNumList());
	      map.put("empTypeCatNumList", cnp.getEmpTypeCatNumList());
	      map.put("locCatNumList", cnp.getLocCatNumList());
	      map.put("acaCatNumList", cnp.getAcaCatNumList()); 
	      System.out.println("입력받은 카테고리번호 : "+map);
	      Map<String,Object> map2=new HashMap<String,Object>();
	      
	      List<String> jobPostingNumList = companyMapper.findJobPostingByCatNumList(map); 
	      System.out.println("카테고리에 따른 구인공고번호" + jobPostingNumList);
	      map2.put("jobPostingNumList", jobPostingNumList);
	      	System.out.println("잡포스팅넘버리스트:"+jobPostingNumList);
	      map2.put("pagingBean", pagingBean);
	      System.out.println("페이징:"+pagingBean);
		List<CompanyMemberVO> jobPostingList =companyMapper.getAllJobPostingListByJobPostingNum(map2);
		System.out.println(jobPostingList);
	}
}
