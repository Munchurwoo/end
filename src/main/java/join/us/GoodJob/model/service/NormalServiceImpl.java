package join.us.GoodJob.model.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import join.us.GoodJob.model.mapper.NormalMapper;
import join.us.GoodJob.model.vo.InterviewVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PortfolioVO;
import join.us.GoodJob.model.vo.PostListVO;

@Service
public class NormalServiceImpl implements NormalService {
	@Resource
	NormalMapper normalMapper;

	@Override
	public void registerNormalMember(NormalMemberVO normalMemberVO) {
		normalMapper.registerMember(normalMemberVO);
		normalMapper.registerNormalMember(normalMemberVO);
	}
	
	@Override
	public void updateNormalMember(NormalMemberVO normalMemberVO) {
		normalMapper.updateNormalMember(normalMemberVO);
		normalMapper.updateMember(normalMemberVO);
	}
	
	@Override
	public NormalMemberVO selectNormalMember(String normalId) {
		return normalMapper.selectNormalMember(normalId);
	}

	//181018 MIRI 일반회원, 기업회원 회원탈퇴 공통으로 묶음
	/*@Override
	public void deleteNormalMember(String normalId) {
		normalMapper.deleteNormalMember(normalId);
	}*/
	
	//181018 MIRI selectNormalMember와 중복으로 주석
	/*@Override
	public NormalMemberVO myPageNormalMember(String memberId) {
		return normalMapper.myPageNormalMember(memberId);
	}*/

	@Override
	//181019 MIRI 포트폴리오 등록/수정 동시에 활용하기위해 flag를 줌
	public void registerPortfolio(PortfolioVO portfolioVO, boolean registerFlag) {	
		System.out.println(portfolioVO);
		
		//포트폴리오 등록(PORTFOLIO)
		if(registerFlag == true)	//flag가 true일 경우에만 포트폴리오 등록
			normalMapper.insertPortfolio(portfolioVO);
		
		
		
		
		//포트폴리오 분류 등록 시작
		Map<String, String> map = new HashMap<String, String>();
		map.put("normalId", portfolioVO.getNormalId());
		
		
		//포트폴리오 파일 업로드, 파일경로등록(PORTFOLIO_FILE) 

		List<MultipartFile> fileList = portfolioVO.getFileList();
		String workspaceUploadPath = "C:\\java-kosta\\framework-workspace2\\goodjob\\src\\main\\webapp\\resources\\upload\\memberPortfolio\\";

		for(MultipartFile currentMultipartFile : fileList) {
			File file = new File(workspaceUploadPath+currentMultipartFile.getOriginalFilename());
			try {
				currentMultipartFile.transferTo(file);
				map.put("filePath", currentMultipartFile.getOriginalFilename());
				normalMapper.insertPortfolioFile(map);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			};
		}		
				
		//포트폴리오 학력 분류 등록(PORTFOLIO_ACADEMIC)
		for(String academicNum :portfolioVO.getAcaCatNumList()) {
			map.put("academicNum", academicNum);
			normalMapper.insertPortfolioAcademic(map);			
		}
		
		//포트폴리오 개발분야 분류 등록(PORTFOLIO_DEV)
		for(String devCatNum :portfolioVO.getDevCatNumList()) {
			map.put("devCatNum", devCatNum);
			normalMapper.insertPortfolioDev(map);
		}
		
		//포트폴리오 고용형태 분류 등록(PORTFOLIO_EMP)
		for(String empTypeNum :portfolioVO.getEmpTypeCatNumList()) {
			map.put("empTypeNum", empTypeNum);
			normalMapper.insertPortfolioEmp(map);
		}
		
		//포트폴리오 지역 분류 등록(PORTFOLIO_LOC)
		for(String locNum :portfolioVO.getLocCatNumList()) {
			map.put("locNum", locNum);
			normalMapper.insertPortfolioLoc(map);
		}
		//포트폴리오 모집직군 분류 등록(PORTFOLIO_RECRUITMENT)
		for(String rcNum :portfolioVO.getRecruitCatNumList()) {
			map.put("rcNum", rcNum);
			normalMapper.insertPortfolioRecuitment(map);	
		}		
	}
		
	public PortfolioVO normalDetailPortfolio(String normalId) {
		return normalMapper.normalDetailPortfolio(normalId);
	}
	
	@Override
	public List<NormalMemberVO> AllFindNomarMember() {
		return normalMapper.AllFindNomarMember();
	}

	@Override
	public PortfolioVO portFolioVOById(String nomalId) {
		return normalMapper.portFolioVOById(nomalId);
	}
	//181019 MIRI normalDetailPortfolio와 중복되어 주석
	/*@Override
	public List<PortfolioVO> normalDetailPortfolioList(String normalId) {
		return normalMapper.normalDetailPortfolioList(normalId);
	}*/
	@Override
	public void deletePortfolio(String id) {
		normalMapper.deletePortfolio(id);
	}

	@Override
	public void updatePortfolio(PortfolioVO portfolioVO) {
		normalMapper.updatePortfolio(portfolioVO);
	}

	@Override
	public void deletePortfolioMulti(String normalId) {
		normalMapper.deletePortfolioMulti(normalId);
	}

	@Override
	public List<String> portfolioSearchList(PortfolioVO portfolioVO) {
		// TODO Auto-generated method stub
		return normalMapper.portfolioSearchList(portfolioVO);
	}

	@Override
	public void interviewApply(InterviewVO interviewVO) {
		normalMapper.interviewApply(interviewVO);
	}

	@Override
	public PostListVO portfolioAllListAndPagingProcess(String pageNum, int postCountPerPage) {
		
		PagingBean pagingBean;
		int totalPostCount = normalMapper.getAllMemberListCount();
		if (pageNum != null) { // 페이지 번호 주면
			pagingBean = new PagingBean(totalPostCount, Integer.parseInt(pageNum));
		} else { // 페이지 번호 안주면 1페이지
			pagingBean = new PagingBean(totalPostCount);
		}
		pagingBean.setPostCountPerPage(postCountPerPage);
		//normalMember list 이름만 찾음.
		List<NormalMemberVO> nmList= normalMapper.getNormalMemberId(pagingBean);
		PostListVO postListVO = new PostListVO();
		postListVO.setNmList(nmList);
		postListVO.setPagingBean(pagingBean);
		return postListVO;
	}


	

}
