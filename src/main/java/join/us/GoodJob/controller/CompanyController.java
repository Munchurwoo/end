package join.us.GoodJob.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import join.us.GoodJob.model.service.CompanyService;
import join.us.GoodJob.model.service.MemberService;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.MemberVO;

@Controller
public class CompanyController {
	@Resource
	CompanyService companyService;
	@Resource
	MemberService memberService;

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

	@RequestMapping("deleteCompanyMember.do")
	public String deleteNormalMember(HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		String companyId = mvo.getId();
		if (companyId != null) {
			companyService.deleteCompanyMember(companyId);
			session.invalidate();
		}
		return "home.tiles";
	}

	@RequestMapping("registerJobPostingForm.do")
	public String registerJobPostingForm(Model model) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		return "company/job_posting_register_form.tiles2";
	}

	@RequestMapping("user-companyInfo.do")
	public String allConmapnyInfo(Model model) {
		List<MemberVO> cmvoList=companyService.getAllCompanyList();
		model.addAttribute("cmvoList", cmvoList);
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
	@RequestMapping("user-company_detail_search_list.do")
	public String companyDetailSearchList(Model model) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		model.addAttribute("jobPostingList", companyService.getAllJobPostingList());
		return "company/company_detail_search_list.company_search_tiles";
	}
}
