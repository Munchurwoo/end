package join.us.GoodJob.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.service.MemberService;
import join.us.GoodJob.model.service.NormalService;
import join.us.GoodJob.model.service.PagingBean;
import join.us.GoodJob.model.vo.CatNumParamVO;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.InterviewVO;
import join.us.GoodJob.model.vo.JobPostingVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;
import join.us.GoodJob.model.vo.PostListVO;
import join.us.GoodJob.model.vo.QuestionAnswerVO;

@Controller
public class CompanyController {
	@Resource
	CompanyService companyService;
	@Resource
	MemberService memberService;
	@Resource
	NormalService normalService;
	
	/*실제 운영시에 사용
	private String serverUploadPath;*/	
	//private String workspaceUploadPath;

	/**
	 * 기업회원 회원가입 폼으로 이동
	 * @return
	 */
	@RequestMapping("user-registerCompanyMemberForm.do")
	public String registerCompanyMemberForm() {
		return "company/company_register_form.tiles2";
	}

	/**
	 * 기업회원 회원가입 작업
	 * @param companyMemberVO
	 * @return
	 */
	@PostMapping("user-registerCompanyMember.do")
	public String registerCompanyMember(CompanyMemberVO companyMemberVO) {
		companyService.registerCompanyMember(companyMemberVO);
		return "redirect:user-loginForm.do";
	}

	/**
	 * 181015 MIRI 기업 회원정보폼 (NORMAL_MEMBER)
	 * 
	 * @param companyMemberVO
	 * @return
	 */
	@RequestMapping("updateCompanyMemberForm.do")
	public String updateCompanyMemberForm(HttpSession session, Model model) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo != null) {
			CompanyMemberVO cmvo = companyService.selectCompanyMember(mvo.getId());
			model.addAttribute("cmvo", cmvo);
		}	
		return "company/company_update_form.tiles2";
	}

	/**
	 * 181016 MIRI 기업 회원정보 수정
	 * 
	 * @param companyMemberVO
	 * @return
	 */
	@PostMapping("updateCompanyMember.do")
	public String updateCompanyMember(CompanyMemberVO companyMemberVO) {
		companyService.updateCompanyMember(companyMemberVO);
		return "redirect:company_mypage.do";
	}
	/*@ResponseBody
	@PostMapping("user-updateCompanyLogo.do")
	public String updateCompanyLogo(MultipartFile updateLogo) {
		workspaceUploadPath="C:\\java-kosta\\framework-workspace2\\goodjob\\src\\main\\webapp\\resources\\upload\\companyLogo\\";
		if(updateLogo.isEmpty()==false) {
			File updateLogoPath=new File(workspaceUploadPath+updateLogo.getOriginalFilename());
			try {
				updateLogo.transferTo(updateLogoPath);
			} catch (IllegalStateException | IOException e) {
				
				e.printStackTrace();
			}
		}
		return updateLogo.getOriginalFilename();
	}*/

	/**
	 * 181015 MIRI 기업회원 마이페이지
	 * 
	 * @return
	 */
	
	@RequestMapping("company_mypage.do")
	public String myPageCompanyMember(String companyId, Model model, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo != null) {
			CompanyMemberVO cmvo = companyService.myPageCompanyMember(mvo.getId());
			model.addAttribute("cmvo", cmvo);
		}
		return "company/company_mypage.tiles2";
	}
	
	//181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*@RequestMapping("deleteCompanyMember.do")
	public String deleteCompanyMember(HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		String companyId = mvo.getId();
		if (companyId != null) {
			companyService.deleteCompanyMember(companyId);
			session.invalidate();
		}
		return "home.tiles";
	}*/
	
	/**
	 *  구인공고 폼으로 이동
	 * @param model
	 * @return
	 */
	@RequestMapping("registerJobPostingForm.do")
	public String registerJobPostingForm(Model model) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		return "company/job_posting_register_form.tiles2";
	}

	/**
	 * 구인공고 등록
	 * @param jobPostingVO
	 * @param session
	 * @return
	 */
	@RequestMapping("registerJobPosting.do")
	public String registerJobPosting(JobPostingVO jobPostingVO, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		jobPostingVO.setCompanyId(mvo.getId());
		//jobPostingVO.setJobPostingNum(jobPostingVO.getJobPostingNum());
		System.out.println(jobPostingVO);
		companyService.registerJobPosting(jobPostingVO,true);
		return "redirect:job_posting_detail.do?jobPostingNum="+jobPostingVO.getJobPostingNum();
	}


	/**
	 *  기업정보 전체보기
	 * @param model
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("user-allCompanyInfo.do")
	public String allCompanyInfo(Model model, String pageNum) {
		PostListVO postListVO = companyService.getAllCompanyList(pageNum);
		model.addAttribute("allRecruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("allDevCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("allEmpTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("allLocCatList", memberService.getLocCatVOList());
		model.addAttribute("allAcaCatList", memberService.getAcaCatVOList());
		model.addAttribute("postListVO", postListVO);		
		return "company/company_info.tiles2";
	}
	/**
	 *  기업정보 상세보기
	 * @param companyId
	 * @param model
	 * @return
	 */
	@RequestMapping("user-detailCompanyInfo.do")
	public String detailCompanyInfo(String companyId,Model model) {
		model.addAttribute("cmvo", companyService.detailCompanyInfo(companyId));
		return "company/company_detail_Info.tiles2";
	}

	/**
	 *  구인공고 상세보기
	 * @param jobPostingNum
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("job_posting_detail.do")
	public String job_posting_detail(String jobPostingNum, Model model) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNum(jobPostingNum));
		model.addAttribute("devCatList", memberService.getDevCatVOListByNum(jobPostingNum));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNum(jobPostingNum));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNum(jobPostingNum));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNum(jobPostingNum));
		model.addAttribute("jpvo", companyService.jobPostingDetail(jobPostingNum));
		model.addAttribute("qaList", companyService.getJobPostingQAList(jobPostingNum));
		return "company/job_posting_detail.tiles2";
	}
	
	/**
	 *  한 기업이 등록한 구인공고리스트 보기 
	 * @param companyId 기업회원 아이디
	 * @param model
	 * @return 특정 기업이 등록한 구인공고 리스트
	 */
	@RequestMapping("companyJobPostingList.do")
	public String companyJobPostingList(String companyId,Model model) {
		model.addAttribute("jobPostingList", companyService.companyJobPostingList(companyId));
		model.addAttribute("cmvo",companyService.detailCompanyInfo(companyId));
		return "company/company_job_postingList.tiles2";
	}
	/**
	 * 181026 MIRI 기업, 개인 register, update시 사진 업로드 공통으로 묶음
	 * 기업로고사진 파일 등록 Ajax
	 * @param uploadPicture
	 * @param request
	 * @return
	 *//*
	@PostMapping("user-uploadCompanyLogo.do")
	@ResponseBody
	public String uploadCompanyLogo(MultipartFile uploadPicture,HttpServletRequest request) {
		workspaceUploadPath="C:\\java-kosta\\framework-workspace2\\goodjob\\src\\main\\webapp\\resources\\upload\\companyLogo\\";
		System.out.println("업로드 경로:"+workspaceUploadPath);
		if(uploadPicture.isEmpty()==false) {
			System.out.println("파일명:"+uploadPicture.getOriginalFilename());
			File uploadWorkspaceFile=new File(workspaceUploadPath+uploadPicture.getOriginalFilename());
			try {
				if(uploadWorkspaceFile.exists())
					uploadWorkspaceFile.delete();
				uploadPicture.transferTo(uploadWorkspaceFile);
				System.out.println("성공");
			} catch (IllegalStateException | IOException e) {
				
				e.printStackTrace();
			}
		}
		return uploadPicture.getOriginalFilename();
	}*/
	/**
	 * 채용정보 전체보기
	 * @param model
	 * @return
	 */
	@RequestMapping("user-getAllJobPostingList.do")
	public String getAllJobPostingList(Model model,String pageNum) {
		PostListVO postListVO = companyService.getAllJobPostingList(pageNum);
		
		model.addAttribute("allRecruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("allDevCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("allEmpTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("allLocCatList", memberService.getLocCatVOList());
		model.addAttribute("allAcaCatList", memberService.getAcaCatVOList());
		model.addAttribute("postListVO", postListVO);
		return "company/company_get_all_jobPosting_list.company_search_tiles";
	}
	
	/**
	 * 채용정보 검색 결과 보기
	 * @param model
	 * @param map
	 * @param catNumParamVO
	 * @return
	 */
	@RequestMapping("user-company_detail_search_list.do")
	public String findJobPostingByCatNumList(Model model, CatNumParamVO catNumParamVO,String pageNum) {
		// 아래 6줄은 상세조건 폼
		model.addAttribute("allRecruitCatList", memberService.getRecruitCatVOList());
		//model.addAttribute("allDevCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("allEmpTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("allLocCatList", memberService.getLocCatVOList());
		model.addAttribute("allAcaCatList", memberService.getAcaCatVOList());
		model.addAttribute("jobPostingList", companyService.getAllJobPostingList(pageNum));
		//System.out.println(catNumParamVO);

		//카테고리 번호들로 기업 게시글 리스트 불러옴
		PostListVO postListVO = companyService.findJobPostingByCatNumList(catNumParamVO,pageNum);
		System.out.println(postListVO.getJobPostingList());
		model.addAttribute("postListVO", postListVO);
		return "company/company_detail_search_list.company_search_tiles";
	} 
	
	/*@RequestMapping("getAllInterviewerList.do")
	public String getAllInterviewerList(Model model, String companyId) {
		model.addAttribute("interviewerList", companyService.getAllInterviewerList(companyId));
		return "company/company_InterviewApplyList.tiles2";
	}*/
	
	/**
	 * 181024 MIRI 구인 공고별 면접자 리스트
	 * @param jobPostingNum
	 * @return
	 */
	@PostMapping("getJobPostingInterviewerList.do")
	public String getJobPostingInterviewerList(String jobPostingNum, Model model, String pageNum) {
		System.out.println(jobPostingNum);
		PostListVO plvo = companyService.getJobPostingInterviewerList(jobPostingNum, pageNum);
		System.out.println(plvo);
		model.addAttribute("plvo", plvo);

		List<InterviewVO> ivvoList = plvo.getIvList();
		if(ivvoList.isEmpty() == false) {
			List<DevCatVO> dcvoList = new ArrayList<DevCatVO>();
			List<String> dcnameList = null;
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			for (InterviewVO ivvo : ivvoList) {
				String id = ivvo.getNormalMemberVO().getId();
				PortfolioVO povo = normalService.normalDetailPortfolio(id);
				dcvoList = memberService.getDevCatVOListByNormalId(id);
				dcnameList = new ArrayList<String>();
				for (DevCatVO dcvo : dcvoList)
					dcnameList.add(dcvo.getDevCatName());
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", id);
				map.put("dcnameList", dcnameList);
				if(povo != null)
					map.put("picturePath", povo.getPicturePath());
				mapList.add(map);
			}
			model.addAttribute("mapList", mapList);
		}
		model.addAttribute("ivvoList", ivvoList);
		return "company/job_posting_interviewer_list.tiles2";
	}
	
	/**
	 * 181020 MIRI 구인 공고별 질답 리스트
	 * @param jobPostingNum
	 * @return
	 */
	@PostMapping("getJobPostingQAList.do")
	public String getJobPostingQAList(String jobPostingNum, Model model) {
		List<QuestionAnswerVO> qavo = companyService.getJobPostingQAList(jobPostingNum);
		model.addAttribute("qavo", qavo);
		return "company/job_posting_QA_list.tiles2";
	}
	
	/**
	 * 181022 MIRI Q&A 답변 수정
	 * @param QANum
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateQAToAnswer.do")
	public QuestionAnswerVO updateQAToAnswer(String QANum, String answer, Model model) {
		QuestionAnswerVO qavo = companyService.getJobPostingQAByQANum(QANum);
		qavo.setAnswer(answer);
		companyService.updateQAToAnswer(qavo);
		qavo = companyService.getJobPostingQAByQANum(QANum);
		model.addAttribute("qavo", qavo);
		System.out.println(qavo);
		return qavo;
	}
	
	/**
	 * 181022 MIRI Q&A 답변 삭제
	 * @param QANum
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deleteQAToAnswer.do")
	public QuestionAnswerVO deleteQAToAnswer(String QANum, Model model) {
		QuestionAnswerVO qavo = companyService.getJobPostingQAByQANum(QANum);
		companyService.deleteQAToAnswer(QANum);
		qavo = companyService.getJobPostingQAByQANum(QANum);
		model.addAttribute("qavo", qavo);
		return qavo;
	}
	
	@RequestMapping("updateJobPostingForm.do")
	public String updateJobPostingForm(String jobPostingNum,Model model) {
		// DB에서 기본 업데이트 폼 양식을 가져오는 코드
		model.addAttribute("allRecruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("allDevCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("allEmpTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("allLocCatList", memberService.getLocCatVOList());
		model.addAttribute("allAcaCatList", memberService.getAcaCatVOList());
		// 구인공고 글에 설정된 카테고리 
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNum(jobPostingNum));
		model.addAttribute("devCatList", memberService.getDevCatVOListByNum(jobPostingNum));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNum(jobPostingNum));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNum(jobPostingNum));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNum(jobPostingNum));
		// 구인 상세정보
		model.addAttribute("jpvo", companyService.jobPostingDetail(jobPostingNum));
	
		return "company/job_posting_update_form.tiles2";
	}
	
	@RequestMapping("updateJobPosting.do")
	public String updateJobPosting(JobPostingVO jobPostingVO) {
			companyService.updateJobPosting(jobPostingVO);
			companyService.deleteJobPostingMulti(jobPostingVO.getJobPostingNum());
			companyService.registerJobPosting(jobPostingVO, false);
		return "redirect:home.do";
	}
	@RequestMapping("deleteJobPosting.do")
	public String deleteJobPosting(int jobPostingNum) {
		System.out.println(jobPostingNum);
			companyService.deleteJobPostingByNum(jobPostingNum);
		return "redirect:home.do";
	}
	@RequestMapping("user-findJobPostingByTitle.do")
	public String findJobPostingByTitle(String searchText,String searchType,Model model,String pageNum) {
		model.addAttribute("allRecruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("allDevCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("allEmpTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("allLocCatList", memberService.getLocCatVOList());
		model.addAttribute("allAcaCatList", memberService.getAcaCatVOList());
		PostListVO jobPostingList2 = companyService.findJobPostingBytitle(searchText,searchType,pageNum);
		System.out.println(jobPostingList2);
		model.addAttribute("searchType", searchType);
		model.addAttribute("searchText", searchText);
		System.out.println(searchType);
		model.addAttribute("jobPostingList2", jobPostingList2);
		
		return "company/keywordSearch_result.company_search_tiles";
	}
	@ResponseBody
	@RequestMapping("isJobPosting.do")
	public String isJobPosting(String companyId) {
		String result=null;
		List<JobPostingVO> jpvo=companyService.companyJobPostingList(companyId);
		if(jpvo.isEmpty()) {
			result="asd";
		}else {
			result="dsa";
		}
		return result;
		
	}
	
}
