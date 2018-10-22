package join.us.GoodJob.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.vo.CatNumParamVO;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.JobPostingVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PostListVO;
import join.us.GoodJob.model.vo.QuestionAnswerVO;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	CompanyMapper companyMapper;

	@Override
	public void registerCompanyMember(CompanyMemberVO companyMemberVO) {
		companyMapper.registerMember(companyMemberVO);
		companyMapper.registerCompanyMember(companyMemberVO);
	}

	@Override
	public CompanyMemberVO selectCompanyMember(String id) {
		return companyMapper.selectCompanyMember(id);
	}

	@Override
	public void updateCompanyMember(CompanyMemberVO companyMemberVO) {
		companyMapper.updateCompanyMember(companyMemberVO);
		companyMapper.updateMember(companyMemberVO);
	}

	// 181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*
	 * @Override public void deleteCompanyMember(String companyId) { }
	 */

	@Override
	public CompanyMemberVO myPageCompanyMember(String companyId) {
		return companyMapper.myPageCompanyMember(companyId);

	}

	@Override
	public NormalMemberVO memberSearch() {
		return null;
	}

	public PostListVO getAllCompanyList(String pageNum) {
		PagingBean pagingBean;
		// 기업정보 게시물 수 가져오기
		int totalPostCount = companyMapper.getAllCompanyListCount();
		if (pageNum != null) { // 페이지 번호 주면
			pagingBean = new PagingBean(totalPostCount, Integer.parseInt(pageNum));
		} else { // 페이지 번호 안주면 1페이지
			pagingBean = new PagingBean(totalPostCount);
		}
		List<MemberVO> cmvoList = companyMapper.getAllCompanyList(pagingBean);
		PostListVO postListVO = new PostListVO();
		postListVO.setPagingBean(pagingBean);
		postListVO.setCmvoList(cmvoList);
		return postListVO;
	}

	@Override
	public CompanyMemberVO detailCompanyInfo(String companyId) {
		return companyMapper.detailCompanyInfo(companyId);
	}
	
	public CompanyMemberVO jobPostingDetail(String jobPostingNum) {	
		return companyMapper.jobPostingDetail(jobPostingNum);
	}
	@Override
	public List<JobPostingVO> companyJobPostingList(String companyId) {

		return companyMapper.companyJobPostingList(companyId);
	}

	@Override
	public List<CompanyMemberVO> getAllJobPostingList() {

		return companyMapper.getAllJobPostingList();
	}

	@Override
	public List<String> findJobPostingByCatNumList(Map map) {
		CatNumParamVO cnpvo = new CatNumParamVO();
		map.put("devCatNumList", cnpvo.getDevCatNumList());
		map.put("recruitCatNumList", cnpvo.getRecruitCatNumList());
		map.put("empTypeCatNumList", cnpvo.getEmpTypeCatNumList());
		map.put("locCatNumList", cnpvo.getLocCatNumList());
		map.put("acaCatNumList", cnpvo.getAcaCatNumList());
		return companyMapper.findJobPostingByCatNumList(map);
	}

	@Override
	public List<CompanyMemberVO> getSomeCompanyList(CatNumParamVO catNumParamVO) {
		List<CompanyMemberVO> someCompanyList = new ArrayList<CompanyMemberVO>();

		// catNumParamVO로 List<String> 타입으로 구인공고 번호 리스트 받아옴
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("devCatNumList", catNumParamVO.getDevCatNumList());
		map.put("recruitCatNumList", catNumParamVO.getRecruitCatNumList());
		map.put("empTypeCatNumList", catNumParamVO.getEmpTypeCatNumList());
		map.put("locCatNumList", catNumParamVO.getLocCatNumList());
		map.put("acaCatNumList", catNumParamVO.getAcaCatNumList());

		List<String> jobPostingNumList = companyMapper.findJobPostingByCatNumList(map);
		// System.out.println("구인공고 번호리스트 :"+jobPostingNumList);
		// 위에서 받아온 번호 리스트로 for문 돌려서 List<CompanyMemberVO>에 add
		for (String jobPostingNum : jobPostingNumList) {
			CompanyMemberVO companyMemberVO = companyMapper.getAllJobPostingListByJobPostingNum(jobPostingNum);
			someCompanyList.add(companyMemberVO);
		}

		// myBatis에서 동적 sql하면 멋있음 -보류
		// System.out.println("게시물리스트 :"+someCompanyList);
		return someCompanyList;
	}

	@Override
	public void registerJobPosting(JobPostingVO jobPostingVO) {
		companyMapper.registerJobPosting(jobPostingVO);
		System.out.println(jobPostingVO);		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jobPostingNum", jobPostingVO.getJobPostingNum());

		for (String empTypeNum : jobPostingVO.getEmpTypeCatNumList()) {
			map.put("empTypeNum", empTypeNum);
			companyMapper.registerJobPostingEmp(map);
		}

		for (String locNum : jobPostingVO.getLocCatNumList()) {
			map.put("locNum", locNum);
			companyMapper.registerJobPostingLoc(map);
		}

		for (String academicNum : jobPostingVO.getAcaCatNumList()) {
			map.put("academicNum", academicNum);
			companyMapper.registerJobPostingAcademic(map);
		}
		for (String rcNum : jobPostingVO.getRecruitCatNumList()) {
			map.put("rcNum", rcNum);
			companyMapper.registerJobPostingRecuitment(map);
		}

		for (String devCatNum : jobPostingVO.getDevCatNumList()) {
			map.put("devCatNum", devCatNum);
			companyMapper.registerJobPostingDev(map);
		}
	}

	@Override
	public List<QuestionAnswerVO> getJobPostingQAList(String jobPostingNum) {
		return companyMapper.getJobPostingQAList(jobPostingNum);
	}

}
