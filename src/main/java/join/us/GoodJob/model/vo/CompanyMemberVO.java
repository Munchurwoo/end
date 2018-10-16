package join.us.GoodJob.model.vo;

import java.util.List;
/**
 * 기업회원
 * @author kosta
 *
 */
public class CompanyMemberVO extends MemberVO {
	private String companyId;
	private String introduction;
	private String companyType;
	private String industry;
	private String sales;
	private String dateOfEstablishment;
	private String numOfEmployees;	//181016 MIRI 기존 int type일 떄에 공백으로 가입하면 400Error뜸 -> String type으로 수정하였더니 정상 동작.
	private List<JobPostingVO> jobPostingVOList;
	public CompanyMemberVO() {
		super();
	}
	/**
	 * CompanyMemberVO
	 * @param companyId 기업회원 아이디
	 * @param introduction 소개
	 * @param companyType 기업형태(String)
	 * @param industry 업종
	 * @param sales 매출액
	 * @param dateOfEstablishment 설립일
	 * @param numOfEmployees 사원수
	 * @param jobPostingVOList 구인공고 리스트 (기업이 구인공고글을 여러개 등록)
	 */
	public CompanyMemberVO(String companyId, String introduction, String companyType, String industry, String sales,
			String dateOfEstablishment, String numOfEmployees, List<JobPostingVO> jobPostingVOList) {
		super();
		this.companyId = companyId;
		this.introduction = introduction;
		this.companyType = companyType;
		this.industry = industry;
		this.sales = sales;
		this.dateOfEstablishment = dateOfEstablishment;
		this.numOfEmployees = numOfEmployees;
		this.jobPostingVOList = jobPostingVOList;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getDateOfEstablishment() {
		return dateOfEstablishment;
	}
	public void setDateOfEstablishment(String dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}
	public String getNumOfEmployees() {
		return numOfEmployees;
	}
	public void setNumOfEmployees(String numOfEmployees) {
		this.numOfEmployees = numOfEmployees;
	}
	public List<JobPostingVO> getJobPostingVOList() {
		return jobPostingVOList;
	}
	public void setJobPostingVOList(List<JobPostingVO> jobPostingVOList) {
		this.jobPostingVOList = jobPostingVOList;
	}
	@Override
	public String toString() {
		return super.toString()+"CompanyMemberVO [companyId=" + companyId + ", introduction=" + introduction + ", companyType="
				+ companyType + ", industry=" + industry + ", sales=" + sales + ", dateOfEstablishment="
				+ dateOfEstablishment + ", numOfEmployees=" + numOfEmployees + ", jobPostingVOList=" + jobPostingVOList
				+ "]";
	}
	
}