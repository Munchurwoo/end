package join.us.GoodJob.controller;
import java.io.File;
import java.io.IOException;
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
import join.us.GoodJob.model.vo.CatNumParamVO;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.JobPostingVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.PostListVO;

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
	private String workspaceUploadPath;

	@RequestMapping("user-registerCompanyMemberForm.do")
	public String registerCompanyMemberForm() {
		return "company/company_register_form.tiles2";
	}

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
		return "redirect:home.do";
	}

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
	 * 
	 * 이부분 오류나서 잠깐 주석처리 해놓을게요. 
	 * @param jobPostingVO
	 * @param session
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping("registerJobPosting.do")
	public String registerPortfolio(JobPostingVO jobPostingVO, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		jobPostingVO.setCompanyId(mvo.getId());
		jobPostingVO.setJobPostingNum(jobPostingVO.getJobPostingNum());
		companyService.registerJobPosting(jobPostingVO);
		return "redirect:home.do";
	}*/

	@RequestMapping("user-companyInfo.do")
	public String allConmapnyInfo(Model model, String pageNum) {
		PostListVO postListVO = companyService.getAllCompanyList(pageNum);
		model.addAttribute("postListVO", postListVO);		
		return "company/company_info.tiles2";
	}

	@RequestMapping("user-detailCompanyInfo.do")
	public String detailCompanyInfo(String companyId,Model model) {
		model.addAttribute("cmvo", companyService.detailCompanyInfo(companyId));
		return "company/company_detail_Info.tiles2";
	}

	
	@RequestMapping("job_posting_detail.do")
	public String job_posting_detail(String jobPostingNum, Model model, HttpSession session) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNum(jobPostingNum));
		model.addAttribute("devCatList", memberService.getDevCatVOListByNum(jobPostingNum));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNum(jobPostingNum));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNum(jobPostingNum));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNum(jobPostingNum));
		model.addAttribute("jpvo", companyService.jobPostingDetail(jobPostingNum));
		return "company/job_posting_detail.tiles2";
	}

	@RequestMapping("companyJobPostingList.do")
	public String companyJobPostingList(String companyId,Model model) {
		model.addAttribute("jobPostingList", companyService.companyJobPostingList(companyId));
		return "company/company_job_postingList.tiles2";
	}
	@PostMapping("user-uploadCompanyLogo.do")
	@ResponseBody
	public String uploadCompanyLogo(MultipartFile uploadLogo,HttpServletRequest request) {
		workspaceUploadPath="C:\\java-kosta\\framework-workspace2\\goodjob\\src\\main\\webapp\\resources\\upload\\companyLogo\\";
		System.out.println("업로드경로"+workspaceUploadPath);
		if(uploadLogo.isEmpty()==false) {
			System.out.println("파일명"+uploadLogo.getOriginalFilename());
			File uploadWorkspaceFile=new File(workspaceUploadPath+uploadLogo.getOriginalFilename());
			try {
				uploadLogo.transferTo(uploadWorkspaceFile);
				System.out.println("성공");
			} catch (IllegalStateException | IOException e) {
				
				e.printStackTrace();
			}
		}
		return uploadLogo.getOriginalFilename();
	}
		
	@RequestMapping("user-getAllJobPostingList.do")
	public String getAllJobPostingList(Model model) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		model.addAttribute("jobPostingList", companyService.getAllJobPostingList());
		return "company/company_get_all_jobPosting_list.company_search_tiles";
	}
	@PostMapping("user-company_detail_search_list.do")
	public String findJobPostingByCatNumList(Model model, Map map, CatNumParamVO catNumParamVO) {
		// 아래 6줄은 상세조건 폼
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		model.addAttribute("jobPostingList", companyService.getAllJobPostingList());
		//System.out.println(catNumParamVO);

		//카테고리 번호들로 기업 게시글 리스트 불러옴
		List<CompanyMemberVO> cmvoList=companyService.getSomeCompanyList(catNumParamVO);
		model.addAttribute("cmvoList", cmvoList);
		return "company/company_detail_search_list.company_search_tiles";
	}
	@PostMapping("submitInterview.do")
	public String submitInterview(String normalId,Model model) {
		model.addAttribute("portfolio", normalService.normalDetailPortfolio(normalId));
		return "company/company_InterviewApplyList.tiles2";
		
	}
}
