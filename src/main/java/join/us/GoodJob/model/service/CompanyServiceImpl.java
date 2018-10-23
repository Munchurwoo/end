package join.us.GoodJob.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.vo.CatNumParamVO;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.InterviewVO;
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

	//기업정보 전체 리스트
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
	@Override	
	public CompanyMemberVO jobPostingDetail(String jobPostingNum) {	
		return companyMapper.jobPostingDetail(jobPostingNum);
	}
	@Override
	public List<JobPostingVO> companyJobPostingList(String companyId) {

		return companyMapper.companyJobPostingList(companyId);
	}

	@Override
	public PostListVO getAllJobPostingList(String pageNum) {
			PagingBean pagingBean;
			int totalJobPostingCount=companyMapper.getAlljobPostingCount();
			if (pageNum != null) { // 페이지 번호 주면
				pagingBean = new PagingBean(totalJobPostingCount, Integer.parseInt(pageNum));
			} else { // 페이지 번호 안주면 1페이지
				pagingBean = new PagingBean(totalJobPostingCount);
			}
			List<CompanyMemberVO> jobPostingList= companyMapper.getAllJobPostingList(pagingBean);
			PostListVO postListVO = new PostListVO();
			postListVO.setJobPostingList(jobPostingList);
			postListVO.setPagingBean(pagingBean);
		return postListVO;
	}	

	@Override
	public PostListVO findJobPostingByCatNumList(CatNumParamVO catNumParamVO, String pageNum) {
	  PagingBean pagingBean;
	  Map<String, List<String>> map = new HashMap<String, List<String>>();
      map.put("devCatNumList", catNumParamVO.getDevCatNumList());
      map.put("recruitCatNumList", catNumParamVO.getRecruitCatNumList());
      map.put("empTypeCatNumList", catNumParamVO.getEmpTypeCatNumList());
      map.put("locCatNumList", catNumParamVO.getLocCatNumList());
      map.put("acaCatNumList", catNumParamVO.getAcaCatNumList());      
      List<String> jobPostingNumList = companyMapper.findJobPostingByCatNumList(map); 
      
      //총 게시물 수
      int totalCount=companyMapper.getAllJobPostingListByJobPostingNumCount(jobPostingNumList);
		if (pageNum != null) { // 페이지 번호 주면
			pagingBean = new PagingBean(totalCount, Integer.parseInt(pageNum));
		} else { // 페이지 번호 안주면 1페이지
			pagingBean = new PagingBean(totalCount);
		} 
		PostListVO postListVO = new PostListVO();
      
	
		Map<String,Object> map2=new HashMap<String,Object>();
		map2.put("jobPostingNumList", jobPostingNumList);
		map2.put("pagingBean", pagingBean);
		System.out.println(jobPostingNumList);
      if(!jobPostingNumList.isEmpty()) {
		List<CompanyMemberVO> jobPostingList =companyMapper.getAllJobPostingListByJobPostingNum(map2);
		postListVO.setJobPostingList(jobPostingList);
		postListVO.setPagingBean(pagingBean);	      
      }	
      return postListVO;
	}

	@Override
	public void registerJobPosting(JobPostingVO jobPostingVO,boolean registerFlag) {
		
		if(registerFlag==true)//flag가 true일 경우에만 포트폴리오 등록
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

	@Override
	public void updateQAToAnswer(QuestionAnswerVO qavo) {
		companyMapper.updateQAToAnswer(qavo);
	}
	
	@Override
	public void deleteQAToAnswer(String QANum) {
		companyMapper.deleteQAToAnswer(QANum);
	}

	@Override
	public QuestionAnswerVO getJobPostingQAByQANum(String qaNum) {
		return companyMapper.getJobPostingQAByQANum(qaNum);
	}
	
	@Override
	public List<InterviewVO> getAllInterviewerList() {
		return companyMapper.getAllInterviewerList();
	}

	@Override
	public List<InterviewVO> getJobPostingInterviewerList(String jobPostingNum) {
		return companyMapper.getJobPostingInterviewerList(jobPostingNum);
	}
	
	@Override
	public void updateJobPosting(JobPostingVO jobPostingVO) {
		companyMapper.updateJobPosting(jobPostingVO);
	}

	@Override
	public void deleteJobPostingMulti(int jobPostingNum) {
		companyMapper.deleteJobPostingMulti(jobPostingNum);
	}

	@Override
	public void deleteJobPostingByNum(int jobPostingNum) {
		companyMapper.deleteJobPostingByNum(jobPostingNum);
	}

	@Override
	public PostListVO findJobPostingBytitle(String keyword,String pageNum) {
		PagingBean pagingBean;
		int totalJobPostingCount=companyMapper.findJobPostingBytitleCount(keyword);
		if (pageNum != null) { // 페이지 번호 주면
			pagingBean = new PagingBean(totalJobPostingCount, Integer.parseInt(pageNum));
		} else { // 페이지 번호 안주면 1페이지
			pagingBean = new PagingBean(totalJobPostingCount);
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("keyword",keyword);
		map.put("pagingBean",pagingBean);
		System.out.println("서비스임플 타이틀:"+map);
		List<CompanyMemberVO> jobPostingList = companyMapper.findJobPostingBytitle(map);
		
		PostListVO postListVO=new PostListVO();
		postListVO.setJobPostingList(jobPostingList);
		postListVO.setPagingBean(pagingBean);
		return postListVO;
	}
}
