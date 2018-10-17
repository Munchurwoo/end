package join.us.GoodJob.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.vo.CompanyMemberVO;

import join.us.GoodJob.model.vo.MemberVO;

import join.us.GoodJob.model.vo.JobPostingVO;

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

	public List<MemberVO> getAllCompanyList() {
		return companyMapper.getAllCompanyList();
		
	}

	@Override
	public CompanyMemberVO detailCompanyInfo(String companyId) {
		return companyMapper.detailCompanyInfo(companyId);
	}

	public JobPostingVO jobPostingDetail(String companyNum) {	
		return companyMapper.jobPostringDetail(companyNum);
	}

	@Override
	public List<JobPostingVO> companyJobPostingList(String companyId) {
		
		return companyMapper.companyJobPostingList(companyId);
	}

}
