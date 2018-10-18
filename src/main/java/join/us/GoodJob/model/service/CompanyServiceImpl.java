package join.us.GoodJob.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.JobPostingVO;
import join.us.GoodJob.model.vo.MemberVO;
import join.us.GoodJob.model.vo.NormalMemberVO;
import join.us.GoodJob.model.vo.PostListVO;

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

	@Override
	public void deleteCompanyMember(String companyId) {
	}
	
	@Override
	public CompanyMemberVO myPageCompanyMember(String companyId) {
		return companyMapper.myPageCompanyMember(companyId);
		
	}

	@Override
	public NormalMemberVO memberSearch() {
		return null;
	}

	public PostListVO getAllCompanyList(String pageNum) {
		PagingBean pagingBean;
		//기업정보 게시물 수 가져오기
		int totalPostCount = companyMapper.getAllCompanyListCount();
		if(pageNum!=null) { //페이지 번호 주면
			pagingBean=new PagingBean(totalPostCount, Integer.parseInt(pageNum));			
		}else { //페이지 번호 안주면 1페이지
			pagingBean = new PagingBean(totalPostCount);
		}
		List<MemberVO> cmvoList= companyMapper.getAllCompanyList(pagingBean);		
		return new PostListVO(pagingBean, cmvoList);
	}

	@Override
	public CompanyMemberVO detailCompanyInfo(String companyId) {
		return companyMapper.detailCompanyInfo(companyId);
	}

	public CompanyMemberVO jobPostingDetail(String jobPostingNum) {	
		return companyMapper.jobPostringDetail(jobPostingNum);
	}

	@Override
	public List<JobPostingVO> companyJobPostingList(String companyId) {
		
		return companyMapper.companyJobPostingList(companyId);
	}

}
