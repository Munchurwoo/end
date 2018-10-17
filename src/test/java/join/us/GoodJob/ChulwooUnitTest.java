package join.us.GoodJob;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import join.us.GoodJob.model.mapper.NormalMapper;
import join.us.GoodJob.model.vo.NormalMemberVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring-model.xml"})
public class ChulwooUnitTest {

	@Autowired
	NormalMapper normalMapper;
	/*@Autowired
	MemberMapper memberMapper;
	@Autowired
	ManagerMapper managerMapper;	*/
	
	@Test
	public void test() {
//		System.out.println(memberMapper.getAcaCatVOListByNormalId("yosep"));
		List<NormalMemberVO> list =normalMapper.idName();
		for(int i =0; i<list.size();i++) {
			System.out.println(list.get(i).getId());
		}
		/*System.out.println(memberMapper.getEmpCatVOListByNormalId("yosep"));
		System.out.println(memberMapper.getLocCatVOListByNormalId("yosep"));
		System.out.println(memberMapper.getRecruitCatVOListByNormalId("yosep"));*/
	}
}
