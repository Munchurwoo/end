package join.us.GoodJob.model.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import join.us.GoodJob.model.mapper.CompanyMapper;
import join.us.GoodJob.model.vo.CompanyMemberVO;
import join.us.GoodJob.model.vo.MemberVO;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource	
	CompanyMapper companyMapper;

	@Override
	public void registerCompanyMember(CompanyMemberVO companyMemberVO) {
		companyMapper.insertMember(companyMemberVO);
		companyMapper.insertCompanyMember(companyMemberVO);
	}

	@Override
	public MemberVO loginCompanyMember(MemberVO memberVO) {
		return null;
	}

	@Override
	public void updateCompanyMember(CompanyMemberVO companyMemberVO) {
	}

	@Override
	public void deleteCompanyMember(String companyId) {
	}

}
