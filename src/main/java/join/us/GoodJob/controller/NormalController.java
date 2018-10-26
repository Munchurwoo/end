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

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.service.CompanyService;
//github.com/Munchurwoo/goodjob
import join.us.GoodJob.model.service.MemberService;
import join.us.GoodJob.model.service.NormalService;
import join.us.GoodJob.model.vo.DevCatVO;
import join.us.GoodJob.model.vo.InterviewVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;
import join.us.GoodJob.model.vo.PostListVO;
import join.us.GoodJob.model.vo.QuestionAnswerVO;


@Controller
public class NormalController {
	@Resource
	NormalService normalService;
	@Resource
	MemberService memberService;
	@Resource
	CompanyMapper companyMapper;
	@Resource
	CompanyService companyService;
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
		return "redirect:normalDetailPortfolio.do?normalId="+mvo.getId();
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

	//181025 yosep - 기능 중복으로 주석처리
	// 인재검색 섹션에서 인재검색 결과를 나타냄 
/*	@RequestMapping("user-normalDetailPortfolioList.do")
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

	}*/

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
		model.addAttribute("nmvo", normalService.selectNormalMember(normalId));
		model.addAttribute("povo",normalService.normalDetailPortfolio(normalId));
		model.addAttribute("devCatList", memberService.getDevCatVOListByNormalId(normalId));
		model.addAttribute("empTypeCatList", memberService.getEmpCatVOListByNormalId(normalId));
		model.addAttribute("locCatList", memberService.getLocCatVOListByNormalId(normalId));
		model.addAttribute("acaCatList", memberService.getAcaCatVOListByNormalId(normalId));
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOListByNormalId(normalId));
		return "normal/normal_detail_portfolio.tiles2";

	}

	/**
	 * 인재검색 header 클릭시 이동 10-22 cherwoo 
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("user-portfolioAllList.do")
	public String portfolioAllList(Model model, HttpSession session,String pageNum) {
		// normal 맴버 모두 조회
		//페이징 처리 하기 위한 페이징빈 
		//pageNum 옆에 숫자 5는 postCountPerPage을 의미 ->> 1페이지에 표시할 게시물 수
		PostListVO postListVO =	normalService.portfolioAllListAndPagingProcess(pageNum,5);
		//List<NormalMemberVO> list = normalService.AllFindNomarMember();
		List<List<DevCatVO>> devCatList = new ArrayList<List<DevCatVO>>();
		List<PortfolioVO> povo = new ArrayList<PortfolioVO>();
		for (int i = 0; i < postListVO.getNmList().size(); i++) {
			devCatList.add(memberService.getDevCatVOListByNormalId(postListVO.getNmList().get(i).getNormalId()));
			povo.add(normalService.normalDetailPortfolio(postListVO.getNmList().get(i).getNormalId()));
		}
		//페이징처리 
		model.addAttribute("postListVO",postListVO);
		//개발분야 출력 
		model.addAttribute("devCatList", devCatList);
		//개인 포트폴리오 (title, content, 사진 출력용)
		model.addAttribute("povo", povo);
		//설정 bean 파일  list로 보냄 
		//상세검색 카테고리 제공 
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
		//181023 MIRI return값에 parameter value 넘기기
		return "redirect:normalDetailPortfolio.do?normalId="+portfolioVO.getNormalId();	
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
	 * 181021 yosep 이력서 등록 폼에서 X버튼클릭시 사진 삭제
	 */
	@RequestMapping("normalPictureDelete.do")	
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
		/**
		 * 2018-10-19 성진 구인공고 조회 후 면접신청 폼으로 이동하기
		 * 
		 * @return
		 */
		@RequestMapping("goInterviewApply.do")
		public String goInterviewApply(Model model,String jobPostingNum) {
			System.out.println(companyMapper.findCompanyIdByNum(jobPostingNum));
			model.addAttribute("jobPosting", companyMapper.findCompanyIdByNum(jobPostingNum));
			return "normal/normal_go_interview_apply.tiles2";
		}
		//질의응답 질문 등록(구인공고 상세보기에서)
		@RequestMapping("registerQuestion.do")
		@ResponseBody
		public QuestionAnswerVO registerQuestion(QuestionAnswerVO qaVO,HttpSession session) {
			MemberVO mvo = (MemberVO) session.getAttribute("mvo");
			qaVO.setNormalId(mvo.getId());
			qaVO.setAnswer(null);
			normalService.registerQuestion(qaVO);
			return qaVO;
			
		}
		
		//질의응답 나의질문리스트 
		@RequestMapping("getMyQuestionList.do")
		public String getMyQuestionList(Model model,QuestionAnswerVO qaVO,HttpSession session) {			
			MemberVO mvo = (MemberVO) session.getAttribute("mvo");
			qaVO.setJobPostingNum(mvo.getId());
			qaVO.setNormalId(mvo.getId());
			List<QuestionAnswerVO> qavo=normalService.getMyQuestionList(qaVO);
			model.addAttribute("qavo", qavo);
	
			return "normal/normal_my_question.tiles2";
			
		}
		
		//파일 다운로드 컨트롤러
		@RequestMapping("fileDownload.do")
		public String fileDownload(String fileName){		
			System.out.println(fileName+" download!");
			return "downloadView";
		}

}
