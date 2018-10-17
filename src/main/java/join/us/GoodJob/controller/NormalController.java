package join.us.GoodJob.controller;

import java.io.File;
import java.io.IOException;

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
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;

@Controller
public class NormalController {
	@Resource
	NormalService normalService;
	@Resource
	MemberService memberService;
	
	private String serverUploadPath;
	private String workspaceUploadPath;

	/**
	 * 181015 MIRI 개인 회원가입 폼(NORMAL_MEMBER)
	 * @return
	 */
	@RequestMapping("user-registerNormalMemberForm.do")
	public String registerNormalMemberForm() {
		return "normal/normal_register_form.tiles2";
	}
	
	/**
	 * 181015 SungJin
	 * 개인 회원가입 (NORMAL_MEMBER)
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
	 * @return
	 */
	@RequestMapping("normal_mypage.do")
	public String myPageNormalMember(String normalId,Model model,HttpSession session) {
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if (mvo != null) {
			NormalMemberVO nmvo= normalService.myPageNormalMember(mvo.getId());
			model.addAttribute("nmvo", nmvo);
		}
		return "normal/normal_mypage.tiles2";
	}

	/**
	 * 181015 MIRI 개인회원 회원정보수정 폼
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("updateNormalMemberForm.do")
	public String updateNormalMemberForm(HttpSession session, Model model) {
		MemberVO mvo = (MemberVO)session.getAttribute("mvo");
		if(mvo != null) {
			NormalMemberVO nmvo = normalService.selectNormalMember(mvo.getId());
			model.addAttribute("nmvo", nmvo);
		}
		return "normal/normal_update_form.tiles2";
	}
	
	/**
	 * 181015 MIRI 개인회원 회원정보수정
	 * @param normalMemberVO
	 * @return
	 */
	@PostMapping("updateNormalMember.do")
	public String updateNormalMember(NormalMemberVO normalMemberVO) {
		normalService.updateNormalMember(normalMemberVO);
		return "redirect:home.do";
	}

	@RequestMapping("registerPortfolioForm.do")
	public String registerPortfolioForm(Model model) {
		model.addAttribute("recruitCatList", memberService.getRecruitCatVOList());
		model.addAttribute("devCatList", 	memberService.getDevCatVOListByrcNum("101"));
		model.addAttribute("empTypeCatList", 	memberService.getEmpTypeCatVOList()); 
		model.addAttribute("locCatList", memberService.getLocCatVOList());
		model.addAttribute("acaCatList", memberService.getAcaCatVOList());
		return "normal/normal_register_portfolio_form.tiles2";
	}
	
	@RequestMapping("registerPortfolio.do")
	public String registerPortfolio(PortfolioVO portfolioVO) {
		System.out.println(portfolioVO);
		System.out.println("이력서 등록 성공");
		return "redirect:home.do";
	}

	@RequestMapping("deleteNormalMember.do")
	public String deleteNormalMember(HttpSession session) {
		MemberVO mvo=(MemberVO) session.getAttribute("mvo");
		String normalId=mvo.getId();
		if(normalId!=null) {
			normalService.deleteNormalMember(normalId);
			session.invalidate();
		}
		return "home.tiles";
	}
	
	@PostMapping("normalPictureUpload.do")
	@ResponseBody
	public String uploadNormalPicture(MultipartFile uploadPicture,HttpServletRequest request){
		/*System.out.println("uploadNormalPicture시작");
		//실제 운영시에 사용할 서버 업로드 경로 
		serverUploadPath
		=request.getSession().getServletContext().getRealPath("/resources/upload/");*/
		//개발시에는 워크스페이스 업로드 경로로 준다 
		workspaceUploadPath="C:\\java-kosta\\framework-workspace2\\goodjob\\src\\main\\webapp\\resources\\upload\\";
		//System.out.println("서버 업로드 경로:"+serverUploadPath);
		System.out.println("워크스페이스 업로드 경로:"+workspaceUploadPath);
		System.out.println(uploadPicture);
		if(uploadPicture.isEmpty()==false){
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
	
}

