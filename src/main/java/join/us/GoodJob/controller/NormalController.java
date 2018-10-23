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
import join.us.GoodJob.model.vo.InterviewVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;

@Controller
public class NormalController {
	@Resource
	NormalService normalService;
	@Resource
	MemberService memberService;

	// private String serverUploadPath; //삭제하지마 ㅠㅠ
	private String workspaceUploadPath;
	private String workspaceDeletePath;

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
	// 181018 MIRI selectNormalMember와 중복으로 변경
	public String selectNormalMember(String normalId, Model model, HttpSession session) {
		
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		model.addAttribute("povo",normalService.normalDetailPortfolio(mvo.getId()));
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
	 * 181015 요셉 이력서 등록 폼으로 이동
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("registerPortfolioForm.do")
	public String registerPortfolioForm(Model model) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		return "normal/normal_register_portfolio_form.tiles2";
	}

	/**
	 * 181017 요셉 이력서 등록 작업
	 * 
	 * @param portfolioVO
	 * @param session
	 * @return
	 */
	@PostMapping("registerPortfolio.do")
	public String registerPortfolio(PortfolioVO portfolioVO, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		portfolioVO.setNormalId(mvo.getId());

		System.out.println("이력서 등록 시작");
		// 181019 MIRI 포트폴리오 등록/수정 동시에 활용하기위해 flag를 줌
		normalService.registerPortfolio(portfolioVO, true);
		System.out.println("이력서 등록 성공");
		return "redirect:home.do";
	}

	// 181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*
	 * @RequestMapping("deleteNormalMember.do") public String
	 * deleteNormalMember(HttpSession session) { MemberVO mvo = (MemberVO)
	 * session.getAttribute("mvo"); String normalId = mvo.getId(); if (normalId !=
	 * null) { normalService.deleteNormalMember(normalId); session.invalidate(); }
	 * return "home.tiles"; }
	 */

	/**
	 * 181017 요셉 사진 업로드 Ajax 컨트롤러
	 * 
	 * @param uploadPicture
	 * @param request
	 * @return
	 */
	@PostMapping("normalPictureUpload.do")
	@ResponseBody
	public String uploadNormalPicture(MultipartFile uploadPicture, HttpServletRequest request) {
		/*
		 * System.out.println("uploadNormalPicture시작"); //실제 운영시에 사용할 서버 업로드 경로
		 * serverUploadPath
		 * =request.getSession().getServletContext().getRealPath("/resources/upload/");
		 */
		// 개발시에는 워크스페이스 업로드 경로로 준다
		workspaceUploadPath = "C:\\java-kosta\\framework-workspace2\\goodjob\\src\\main\\webapp\\resources\\upload\\memberPicture\\";
		// System.out.println("서버 업로드 경로:"+serverUploadPath);
		System.out.println("워크스페이스 업로드 경로:" + workspaceUploadPath);
		System.out.println(uploadPicture);
		if (uploadPicture.isEmpty() == false) {
			System.out.println(uploadPicture.getOriginalFilename());
			// File uploadServerFile=new
			// File(serverUploadPath+uploadPicture.getOriginalFilename());
			File uploadWorkspaceFile = new File(workspaceUploadPath + uploadPicture.getOriginalFilename());
			try {
				// uploadPicture.transferTo(uploadServerFile);
				uploadPicture.transferTo(uploadWorkspaceFile);
				System.out.println("사진 업로드 완료!");
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return uploadPicture.getOriginalFilename();
	}

	// 인재검색 섹션에서 인재검색 결과를 나타냄
	@RequestMapping("user-normalDetailPortfolioList.do")
	public String normalDetailPortfolioList(String normalId, Model model) {
		model.addAttribute("devCatList", memberService.getDevCatVOListByNormalId(normalId));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNormalId(normalId));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNormalId(normalId));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNormalId(normalId));
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNormalId(normalId));
		// 181019 MIRI normalDetailPortfolio와 중복되어 normalDetailPortfolio로 수정
		model.addAttribute("povo", normalService.normalDetailPortfolio(normalId));

		NormalMemberVO nmvo = normalService.selectNormalMember(normalId);
		model.addAttribute("nmvo", nmvo);

		return "normal/normal_detail_portfolio_select.tiles2";

	}

	/**
	 * 동규 포트폴리오 상세보기
	 * 
	 * @param normalId
	 * @param model
	 * @param session
	 * @return
	 */

	// 나중에 "yosep"->normalId
	/*
	 * 10월 22일 am 3:22분 문철우. 이부분은 어떤 활용 용도로 놔둔건가요?
	 */

	@RequestMapping("normalDetailPortfolio.do")

	public String normalDetailPortfolio(String normalId, Model model) {
		System.out.println(normalId);
		model.addAttribute("nmvo", normalService.selectNormalMember(normalId));
		model.addAttribute("povo",normalService.normalDetailPortfolio(normalId));
		model.addAttribute("devCatList", memberService.getDevCatVOListByNormalId(normalId));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNormalId(normalId));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNormalId(normalId));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNormalId(normalId));
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNormalId(normalId));

		return "normal/normal_detail_portfolio.tiles2";

	}

	// 인재검색 header 클릭시 이동
	@RequestMapping("user-portfolioAllList.do")
	public String portfolioAllList(Model model, HttpSession session) {
		// normal 맴버 모두 조회
		List<NormalMemberVO> list = normalService.AllFindNomarMember();
		List<List<DevCatVO>> devCatList = new ArrayList<List<DevCatVO>>();
		List<PortfolioVO> povo = new ArrayList<PortfolioVO>();
		model.addAttribute("list", list);
		model.addAttribute("devCatList", devCatList);
		model.addAttribute("povo", povo);

		for (int i = 0; i < list.size(); i++) {
			devCatList.add(memberService.getDevCatVOListByNormalId(list.get(i).getNormalId()));
			povo.add(normalService.normalDetailPortfolio(list.get(i).getNormalId()));
		}

		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());

		return "member/portfolio_all_list.tiles2";
	}

	/**
	 * 181018 MIRI 포트폴리오 수정폼
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("user-updatePortfolioForm.do")
	public String updatePortfolioForm(String id, HttpSession session, Model model) {
		// 내가 가진 포트폴리오 데이터 리스트
		model.addAttribute("devCatList", memberService.getDevCatVOListByNormalId(id));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNormalId(id));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNormalId(id));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNormalId(id));
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNormalId(id));
		model.addAttribute("povo", normalService.normalDetailPortfolio(id));
		// 포트폴리오 전체 리스트 리스트
		model.addAttribute("allRecruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("allDevCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("allEmpTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("allLocCatList", memberService.getLocCatVOList());
		model.addAttribute("allAcaCatList", memberService.getAcaCatVOList());

		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo != null) {
			NormalMemberVO nmvo = normalService.selectNormalMember(id);
			model.addAttribute("nmvo", nmvo);
		}
		return "normal/normal_update_portfolio.tiles2";
	}

	/**
	 * 181019 MIRI 포트폴리오 수정
	 * 
	 * @param portfolioVO
	 * @param session
	 * @return
	 */
	@PostMapping("user-updatePortfolio.do")
	public String updatePortfolio(PortfolioVO portfolioVO, HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		portfolioVO.setNormalId(mvo.getId());
		normalService.updatePortfolio(portfolioVO); // 포트폴리오 수정
		normalService.deletePortfolioMulti(portfolioVO.getNormalId()); // 포트폴리오 관련 복합 table 전부 삭제
		normalService.registerPortfolio(portfolioVO, false); // flag 넣어주어 포트폴리오 등록 없이 복합 table에만 데이터 추가
		return "redirect:normalDetailPortfolio.do";
	}

	/**
	 * 181018 MIRI 포트폴리오 삭제
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("deletePortfolio.do")
	public String deletePortfolio(String id, String picturePath, HttpServletRequest request) {
		workspaceDeletePath = "C:\\java-kosta\\framework-workspace2\\goodjob\\src\\main\\webapp\\resources\\upload\\memberPicture\\";
		if (picturePath.isEmpty() == false) {
			File deleteWorkspaceFile = new File(workspaceDeletePath + picturePath);
			try {
				deleteWorkspaceFile.delete();
				System.out.println("사진 삭제 완료!");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}

		normalService.deletePortfolio(id);

		return "redirect:home.do";
	}

	/**
	 * 2018-10-19 성진 구인공고 조회 후 면접신청 폼으로 이동하기
	 * 
	 * @return
	 */
	@RequestMapping("goInterviewApply.do")
	public String goInterviewApply(Model model,String jobPostingNum) {
		System.out.println("구인공고 "+jobPostingNum+"번 글에 면접신청합니다.");
		model.addAttribute("jobPostingNum", jobPostingNum);
		return "normal/normal_go_interview_apply.tiles2";
	}
	
	/**
	 * 181021 yosep 이력서 등록 폼에서 X버튼클릭시 사진 삭제
	 */
	@RequestMapping("normalPictureDelete")	
	@ResponseBody
	public String normalPictureDelete(String deletePicturename) {	
		String workspaceDeletePath="C:/java-kosta/framework-workspace2/goodjob/src/main/webapp/resources/upload/memberPicture/"+deletePicturename;
		File file = new File(workspaceDeletePath);
		file.delete();
		System.out.println(deletePicturename+"  사진 삭제 완료");
		return "success";
	}

	/**
	 * 2018-10-22 철우 인재검색 리스트에서 상세검색 버튼 클릭시 이동하는 컨트롤러
	 */
	@RequestMapping("user-portfolioSearchList.do")
	public String portfolioSearchList(PortfolioVO portfolioVO, Model model) {
		// 인재 상세검색 결과 String normal_id 로 받기
		List<String> normalId = normalService.portfolioSearchList(portfolioVO);
		List<List<DevCatVO>> devCatList = new ArrayList<List<DevCatVO>>();
		List<PortfolioVO> povo = new ArrayList<PortfolioVO>();
		model.addAttribute("normalId",normalId );
		model.addAttribute("devCatList", devCatList);
		model.addAttribute("povo", povo);

		for (int i = 0; i < normalId.size(); i++) {
			devCatList.add(memberService.getDevCatVOListByNormalId(normalId.get(i)));
			povo.add(normalService.normalDetailPortfolio(normalId.get(i)));
		}

		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", memberService.getEmpTypeCatVOList());
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		System.out.println(portfolioVO);

		return "member/portfolio_search_list.tiles2";
	}
	// 면접신청하기
		@RequestMapping("submitInterviewForm.do")
		public String submitInterviewForm(InterviewVO interviewVO) {
			normalService.interviewApply(interviewVO);
			return "redirect:home.do";
		}
}
