package join.us.GoodJob.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import join.us.GoodJob.model.service.MemberService;
import join.us.GoodJob.model.service.NormalService;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;

@Controller
public class NormalController {
	@Resource
	NormalService normalService;
	@Resource
	MemberService memberService;


	
	//private String serverUploadPath; //삭제하지마 ㅠㅠ
	private String workspaceUploadPath;

	/**
	 * 181015 MIRI 개인 회원가입 폼(NORMAL_MEMBER)
	 * 
	 * @return
	 */
	@RequestMapping("user-registerNormalMemberForm.do")
	public String registerNormalMemberForm() {
		return "normal/normal_register_form.tiles2";
	}

	/**
	 * 181015 SungJin 개인 회원가입 (NORMAL_MEMBER)
	 * 
	 * @param normalMemberVO
	 * @return
	 */
	@PostMapping("user-registerNormalMember.do")
	public String registerNormalMember(NormalMemberVO normalMemberVO) {
		normalService.registerNormalMember(normalMemberVO);
		return "redirect:user-loginForm.do";
	}

	/**
	 * 181015 MIRI 개인회원 마이페이지
	 * 
	 * @return
	 */
	@RequestMapping("normal_mypage.do")
	//181018 MIRI selectNormalMember와 중복으로 변경
	public String selectNormalMember(String normalId, Model model, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo != null) {
			NormalMemberVO nmvo = normalService.selectNormalMember(mvo.getId());
			model.addAttribute("nmvo", nmvo);
		}
		return "normal/normal_mypage.tiles2";
	}

	/**
	 * 181015 MIRI 개인회원 회원정보수정 폼
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("updateNormalMemberForm.do")
	public String updateNormalMemberForm(HttpSession session, Model model) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo != null) {
			NormalMemberVO nmvo = normalService.selectNormalMember(mvo.getId());
			model.addAttribute("nmvo", nmvo);
		}
		return "normal/normal_update_form.tiles2";
	}

	/**
	 * 181015 MIRI 개인회원 회원정보수정
	 * 
	 * @param normalMemberVO
	 * @return
	 */
	@PostMapping("updateNormalMember.do")
	public String updateNormalMember(NormalMemberVO normalMemberVO) {
		normalService.updateNormalMember(normalMemberVO);
		return "redirect:home.do";
	}
	/**
	 * 181015 요셉 
	 * 이력서 등록 폼으로 이동  
	 * @param model
	 * @return
	 */
	@RequestMapping("registerPortfolioForm.do")
	public String registerPortfolioForm(Model model) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		return "normal/normal_register_portfolio_form.tiles2";
	}
	/**
	 * 181017 요셉
	 * 이력서 등록 작업
	 * @param portfolioVO
	 * @param session
	 * @return
	 */
	@RequestMapping("registerPortfolio.do")
	public String registerPortfolio(PortfolioVO portfolioVO, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		portfolioVO.setNormalId(mvo.getId());
		System.out.println("이력서 등록 시작");
		normalService.registerPortfolio(portfolioVO);
		System.out.println("이력서 등록 성공");
		return "redirect:home.do";
	}

	//181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*@RequestMapping("deleteNormalMember.do")
	public String deleteNormalMember(HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		String normalId = mvo.getId();
		if (normalId != null) {
			normalService.deleteNormalMember(normalId);
			session.invalidate();
		}
		return "home.tiles";
	}*/

	/** 181017 요셉
	 *    사진 업로드 Ajax 컨트롤러
	 * @param uploadPicture
	 * @param request
	 * @return
	 */
	@PostMapping("normalPictureUpload.do")
	@ResponseBody
	public String uploadNormalPicture(MultipartFile uploadPicture,HttpServletRequest request){
		/*System.out.println("uploadNormalPicture시작");
		//실제 운영시에 사용할 서버 업로드 경로 
		serverUploadPath
		=request.getSession().getServletContext().getRealPath("/resources/upload/");*/
		//개발시에는 워크스페이스 업로드 경로로 준다 
		workspaceUploadPath="C:\\java-kosta\\framework-workspace2\\goodjob\\src\\main\\webapp\\resources\\upload\\memberPicture\\";
		//System.out.println("서버 업로드 경로:"+serverUploadPath);
		System.out.println("워크스페이스 업로드 경로:"+workspaceUploadPath);
		System.out.println(uploadPicture);
		if (uploadPicture.isEmpty() == false) {
			System.out.println(uploadPicture.getOriginalFilename());
			//File uploadServerFile=new File(serverUploadPath+uploadPicture.getOriginalFilename());
			File uploadWorkspaceFile= new File(workspaceUploadPath+uploadPicture.getOriginalFilename());
			try {
				//uploadPicture.transferTo(uploadServerFile);
				uploadPicture.transferTo(uploadWorkspaceFile);
				System.out.println("사진 업로드 완료!");
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return uploadPicture.getOriginalFilename();
	}
	
	@RequestMapping("user-normalDetailPortfolioList.do")
	public String normalDetailPortfolioList(String normalId, Model model ) {
		model.addAttribute("devCatList", memberService.getDevCatVOListByNormalId(normalId));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNormalId(normalId));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNormalId(normalId));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNormalId(normalId));
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNormalId(normalId));
		model.addAttribute("povo", normalService.normalDetailPortfolio(normalId));
		
		
		NormalMemberVO nmvo = normalService.selectNormalMember(normalId);
		model.addAttribute("nmvo", nmvo);
			
		
		return "normal/normal_detail_portfolio.tiles2";

	}
	//나중에 "yosep"->normalId
	@RequestMapping("normalDetailPortfolio.do")
	public String normalDetailPortfolio(String normalId, Model model, HttpSession session) {
		model.addAttribute("devCatList", memberService.getDevCatVOListByNormalId("miri"));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNormalId("miri"));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNormalId("miri"));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNormalId("miri"));
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNormalId("miri"));
		model.addAttribute("povo", normalService.normalDetailPortfolio("miri"));
		
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo != null) {
			NormalMemberVO nmvo = normalService.selectNormalMember(mvo.getId());
			model.addAttribute("nmvo", nmvo);
		}

		return "normal/normal_detail_portfolio.tiles2";

	}

	// 인재검색 header 클릭시 이동	
	@RequestMapping("user-portfolioAllList.do")
	public String portfolioAllList(Model model, HttpSession session) {
		//normal 맴버 모두 조회 
		List<NormalMemberVO> list =normalService.AllFindNomarMember();
		List<List<DevCatVO>> devCatList =new ArrayList<List<DevCatVO>>();
		List<PortfolioVO> povo =new ArrayList<PortfolioVO>();	
		model.addAttribute("list",list);
		model.addAttribute("devCatList",devCatList);
		model.addAttribute("povo",povo);
		 
		for(int i =0;i<list.size();i++) {
			devCatList.add(memberService.getDevCatVOListByNormalId(list.get(i).getNormalId()));
			povo.add(normalService.normalDetailPortfolio(list.get(i).getNormalId()));
		}
		
	/*	for(NormalMemberVO normalMemberVO : list) { //enhanced for loop
			model.addAttribute("devCatFindId",memberService.getDevCatVOListByNormalId(normalMemberVO.getNormalId()));
		}*/
		
		/*for(int i =0;i<list.size();i++) {
			model.addAttribute("devCatList", memberService.getDevCatVOListByNormalId(list.get(i).getNormalId()));
			model.addAttribute("povo", normalService.normalDetailPortfolioList(list.get(i).getNormalId()));
			
			devCatList.add((DevCatVO) memberService.getDevCatVOListByNormalId(list.get(i).getNormalId()));
			povo.add((PortfolioVO) normalService.normalDetailPortfolioList(list.get(i).getNormalId()));
		}*/
		
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		
	
		return "member/portfolio_all_list.tiles2";
	}

	/**
	 * 181018 MIRI 포트폴리오 수정
	 * @param id
	 * @return
	 */
	@RequestMapping("user-updatePortfolio.do")
	public String updatePortfolio(String id, HttpSession session, Model model) {
		model.addAttribute("devCatList", memberService.getDevCatVOListByNormalId(id));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNormalId("miri"));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNormalId("miri"));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNormalId("miri"));
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNormalId("miri"));
		model.addAttribute("povo", normalService.normalDetailPortfolio(id));
		
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		
		MemberVO mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo != null) {
			NormalMemberVO nmvo = normalService.selectNormalMember(id);
			model.addAttribute("nmvo", nmvo);
		}
		return "normal/normal_update_portfolio.tiles2";
	}
	
	/**
	 * 181018 MIRI 포트폴리오 삭제
	 * @param id
	 * @return
	 */
	@RequestMapping("deletePortfolio.do")
	public String deletePortfolio(String id) {
		normalService.deletePortfolio(id);
		return "redirect:home.do";
	}
	@RequestMapping("goInterviewApply.do")
	public String goInterviewApply() {
		return "normal/normal_go_interview_apply.tiles";
	}
}
