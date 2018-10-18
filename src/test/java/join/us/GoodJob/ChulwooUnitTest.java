package join.us.GoodJob;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.mapper.MemberMapper;
import join.us.GoodJob.model.mapper.NormalMapper;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class ChulwooUnitTest {

	@Autowired
	NormalMapper normalMapper;
	@Autowired
	MemberMapper memberMapper;
	/*@Autowired
	ManagerMapper managerMapper;	*/
	
	@Test
	public void test() {
//		System.out.println(memberMapper.getAcaCatVOListByNormalId("yosep"));
		
		//portFolioVOList 테스트
		List<NormalMemberVO> list =normalMapper.AllFindNomarMember();
		List<DevCatVO> plist = new ArrayList<>();
		for(int i =0; i<plist.size();i++) {
			plist = memberMapper.getDevCatVOListByNormalId(list.get(i).getId());
		}
		for(int i =0; i<list.size();i++) {
			System.out.println(list.get(i).getName()+":"+ plist.get(i).getDevCatName());
		}
		//System.out.println(list.get(1).getName()+":"+ plist.get(1).getDevCatName());
		/*List<NormalMemberVO> list = normalService.AllFindNomarMember();
		model.addAttribute("devCatFindId", );
		model.addAttribute("povo", normalService.normalDetailPortfolio("yosep"));*/
		/*System.out.println(memberMapper.getEmpCatVOListByNormalId("yosep"));
		System.out.println(memberMapper.getLocCatVOListByNormalId("yosep"));
		System.out.println(memberMapper.getRecruitCatVOListByNormalId("yosep"));*/
//		List<PortfolioVO> list = normalMapper.portFolioVOList('qqqq');

	}
}
