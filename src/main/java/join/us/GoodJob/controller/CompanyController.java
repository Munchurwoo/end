package join.us.GoodJob.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "company/company_info.tiles";
	}

	@RequestMapping("user-detailCompanyInfo.do")
	public String detailCompanyInfo(String companyId,Model model) {
		model.addAttribute("cmvo", companyService.detailCompanyInfo(companyId));
		return "company/company_detailInfo.tiles";
	}

	//나중에 "1001"->jobPostingNum
	@RequestMapping("job_posting_detail.do")
	public String job_posting_detail(String jobPostingNum, Model model, HttpSession session) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNum("1001"));
		model.addAttribute("devCatList", memberService.getDevCatVOListByNum("1001"));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNum("1001"));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNum("1001"));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNum("1001"));
		model.addAttribute("jpvo", companyService.jobPostingDetail("1001"));
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo != null) {
			CompanyMemberVO cmvo = companyService.myPageCompanyMember(mvo.getId());
			model.addAttribute("cmvo", cmvo);
		}
		return "company/job_posting_detail.tiles2";

	}

}
