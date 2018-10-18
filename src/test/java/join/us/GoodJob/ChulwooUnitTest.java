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
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-model.xml" })
public class ChulwooUnitTest {

	@Autowired
	NormalMapper normalMapper;
	@Autowired
	MemberMapper memberMapper;
	/*
	 * @Autowired ManagerMapper managerMapper;
	 */

	@SuppressWarnings("null")
	@Test
	public void test() {
		List<NormalMemberVO> list = normalMapper.AllFindNomarMember();
		List<DevCatVO> devCatList = new ArrayList<DevCatVO>();
		List<PortfolioVO> povo = new ArrayList<PortfolioVO>();

		for (int i = 0; i < list.size(); i++) {
			devCatList.addAll(memberMapper.getDevCatVOListByNormalId(list.get(i).getNormalId()));
			povo.add(normalMapper.normalDetailPortfolio(list.get(i).getNormalId()));
		}
		/*
		 * model.addAttribute("devCatList",devCatList); model.addAttribute("povo",povo);
		 */
		/*
		 * for(NormalMemberVO normalMemberVO : list) { //enhanced for loop
		 * model.addAttribute("devCatFindId",memberService.getDevCatVOListByNormalId(
		 * normalMemberVO.getNormalId())); }
		 */

		// for (int i = 0; i < povo.size(); i++) {
		// System.out.println(povo.get(i).getTitle());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName()+":"+devCatList.get(i).getDevCatName());
			/*for (int j = 0; j < devCatList.size(); j++) {
				System.out.println(list.get(i).getName()+":"+devCatList.get(i).get(j).getDevCatName());
			}*/
		}
		// }

		// System.out.println(memberMapper.getAcaCatVOListByNormalId("yosep"));
		/*
		 * List<NormalMemberVO> list =normalMapper.AllFindNomarMember(); PortfolioVO vo
		 * =null; for(int i=0;i<list.size(); i++) { vo =
		 * normalMapper.normalDetailPortfolio(list.get(i).getNormalId()); }
		 * System.out.println(vo);
		 */
		// portFolioVOList 테스트
		/*
		 * List<NormalMemberVO> list =normalMapper.AllFindNomarMember(); List<DevCatVO>
		 * plist = new ArrayList<>();
		 * 
		 * HashMap<String, List<DevCatVO>> map =new HashMap<String, List<DevCatVO>>();
		 * 
		 * 
		 * for(int i =0;i<list.size();i++) { plist =
		 * memberMapper.getDevCatVOListByNormalId(list.get(i).getNormalId()); } for(int
		 * i =0; i<plist.size();i++) { map.put(list.get(i).getId(),
		 * memberMapper.getDevCatVOListByNormalId(list.get(i).getId())); }
		 * System.out.println(list); System.out.println(plist); for(int i =0;
		 * i<list.size();i++) { System.out.println(":"+ plist.get(i).getDevCatName()); }
		 */
		// System.out.println(list.get(1).getName()+":"+ plist.get(1).getDevCatName());
		/*
		 * List<NormalMemberVO> list = normalService.AllFindNomarMember();
		 * model.addAttribute("devCatFindId", ); model.addAttribute("povo",
		 * normalService.normalDetailPortfolio("yosep"));
		 */
		/*
		 * System.out.println(memberMapper.getEmpCatVOListByNormalId("yosep"));
		 * System.out.println(memberMapper.getLocCatVOListByNormalId("yosep"));
		 * System.out.println(memberMapper.getRecruitCatVOListByNormalId("yosep"));
		 */
		// List<PortfolioVO> list = normalMapper.portFolioVOList('qqqq');

	}
}
