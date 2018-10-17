package join.us.GoodJob.model.vo;

import java.util.List;

public class JobPostingVO {
	private int jobPostingNum;
	private String  companyId;
	private String title;
	private String careerStatus;
	private String content;
	private List<QuestionAnswerVO> questionAnswerVOList;
	private List<String> keywordNameList;
	private List<LocCatVO> locCatVOList;
	private List<RecruitCatVO> recruitCatVOList;
	private List<EmpTypeCatVO> empTypeCatVOList;
	private List<DevCatVO> devCatVOList;
	private List<AcaCatVO> acaCatVOList;
	private List<String> locCatNumList;
	private List<String> recruitCatNumList;
	private List<String> empTypeCatNumList;
	private List<String> devCatNumList;
	private List<String> acaCatNumList;
	public JobPostingVO() {
		super();
		
	}
	public int getJobPostingNum() {
		return jobPostingNum;
	}
	public void setJobPostingNum(int jobPostingNum) {
		this.jobPostingNum = jobPostingNum;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCareerStatus() {
		return careerStatus;
	}
	public void setCareerStatus(String careerStatus) {
		this.careerStatus = careerStatus;
	}
	public String getContents() {
		return content;
	}
	public void setContents(String contents) {
		this.content = contents;
	}
	public List<QuestionAnswerVO> getQuestionAnswerVOList() {
		return questionAnswerVOList;
	}
	public void setQuestionAnswerVOList(List<QuestionAnswerVO> questionAnswerVOList) {
		this.questionAnswerVOList = questionAnswerVOList;
	}
	public List<String> getKeywordNameList() {
		return keywordNameList;
	}
	public void setKeywordNameList(List<String> keywordNameList) {
		this.keywordNameList = keywordNameList;
	}
	public List<LocCatVO> getLocCatVOList() {
		return locCatVOList;
	}
	public void setLocCatVOList(List<LocCatVO> locCatVOList) {
		this.locCatVOList = locCatVOList;
	}
	public List<RecruitCatVO> getRecruitCatVOList() {
		return recruitCatVOList;
	}
	public void setRecruitCatVOList(List<RecruitCatVO> recruitCatVOList) {
		this.recruitCatVOList = recruitCatVOList;
	}
	public List<EmpTypeCatVO> getEmpTypeCatVOList() {
		return empTypeCatVOList;
	}
	public void setEmpTypeCatVOList(List<EmpTypeCatVO> empTypeCatVOList) {
		this.empTypeCatVOList = empTypeCatVOList;
	}
	public List<DevCatVO> getDevCatVOList() {
		return devCatVOList;
	}
	public void setDevCatVOList(List<DevCatVO> devCatVOList) {
		this.devCatVOList = devCatVOList;
	}
	public List<AcaCatVO> getAcaCatVOList() {
		return acaCatVOList;
	}
	public void setAcaCatVOList(List<AcaCatVO> acaCatVOList) {
		this.acaCatVOList = acaCatVOList;
	}
	public List<String> getLocCatNumList() {
		return locCatNumList;
	}
	public void setLocCatNumList(List<String> locCatNumList) {
		this.locCatNumList = locCatNumList;
	}
	public List<String> getRecruitCatNumList() {
		return recruitCatNumList;
	}
	public void setRecruitCatNumList(List<String> recruitCatNumList) {
		this.recruitCatNumList = recruitCatNumList;
	}
	public List<String> getEmpTypeCatNumList() {
		return empTypeCatNumList;
	}
	public void setEmpTypeCatNumList(List<String> empTypeCatNumList) {
		this.empTypeCatNumList = empTypeCatNumList;
	}
	public List<String> getDevCatNumList() {
		return devCatNumList;
	}
	public void setDevCatNumList(List<String> devCatNumList) {
		this.devCatNumList = devCatNumList;
	}
	public List<String> getAcaCatNumList() {
		return acaCatNumList;
	}
	public void setAcaCatNumList(List<String> acaCatNumList) {
		this.acaCatNumList = acaCatNumList;
	}
	public JobPostingVO(int jobPostingNum, String companyId, String title, String careerStatus, String content,
			List<QuestionAnswerVO> questionAnswerVOList, List<String> keywordNameList, List<LocCatVO> locCatVOList,
			List<RecruitCatVO> recruitCatVOList, List<EmpTypeCatVO> empTypeCatVOList, List<DevCatVO> devCatVOList,
			List<AcaCatVO> acaCatVOList, List<String> locCatNumList, List<String> recruitCatNumList,
			List<String> empTypeCatNumList, List<String> devCatNumList, List<String> acaCatNumList) {
		super();
		this.jobPostingNum = jobPostingNum;
		this.companyId = companyId;
		this.title = title;
		this.careerStatus = careerStatus;
		this.content = content;
		this.questionAnswerVOList = questionAnswerVOList;
		this.keywordNameList = keywordNameList;
		this.locCatVOList = locCatVOList;
		this.recruitCatVOList = recruitCatVOList;
		this.empTypeCatVOList = empTypeCatVOList;
		this.devCatVOList = devCatVOList;
		this.acaCatVOList = acaCatVOList;
		this.locCatNumList = locCatNumList;
		this.recruitCatNumList = recruitCatNumList;
		this.empTypeCatNumList = empTypeCatNumList;
		this.devCatNumList = devCatNumList;
		this.acaCatNumList = acaCatNumList;
	}
	@Override
	public String toString() {
		return "JobPostingVO [jobPostingNum=" + jobPostingNum + ", companyId=" + companyId + ", title=" + title
				+ ", careerStatus=" + careerStatus + ", content=" + content + ", questionAnswerVOList="
				+ questionAnswerVOList + ", keywordNameList=" + keywordNameList + ", locCatVOList=" + locCatVOList
				+ ", recruitCatVOList=" + recruitCatVOList + ", empTypeCatVOList=" + empTypeCatVOList
				+ ", devCatVOList=" + devCatVOList + ", acaCatVOList=" + acaCatVOList + ", locCatNumList="
				+ locCatNumList + ", recruitCatNumList=" + recruitCatNumList + ", empTypeCatNumList="
				+ empTypeCatNumList + ", devCatNumList=" + devCatNumList + ", acaCatNumList=" + acaCatNumList + "]";
	}
	
	/**
	 * 
	 * @param jobPostingNum 구인공고번호
	 * @param companyId 기업아이디(구인공고 등록자)
	 * @param title 구인공고 제목(String) 인재를 찾습니다
	 * @param careerStatus 경력 상태(String) ex) Java 개발 3년 이상
	 * @param content 공고 내용(String) ex) 함께할 가족같은 인재를 모십니다
	 * @param questionAnswerVOList 질의응답(공고 하나가 여러 질문을 받을 수 있음)
	 * @param keywordNameList 키워드명(String)
	* @param locCatVOList 지역분류 리스트(VO,출력용)
	 * @param recruitCatVOList 모집직군 분류 리스트(VO, 출력용)
	 * @param empTypeCatVOList 고용형태 분류 리스트(VO, 출력용)
	 * @param devCatVOList 개발분야 분류 리스트(VO, 출력용)
	 * @param acaCatVOList 학력 분류 리스트(VO, 출력용)
	 * @param locCatNumList 지역번호 리스트(String, 입력용, 포트폴리오 등록시 지역명을 복수 선택(체크박스) 후 등록버튼을 누르면 PortfolioVO.locCatNumList에 지역 번호가 순서대로 저장)
	 * @param recruitCatNumList 모집직군 번호 리스트(String, 입력용, 포트폴리오 등록시 모집직군을 복수 선택(체크박스) 후 등록버튼을 누르면 PortfolioVO.recruitCatNumList에 모집직군 번호가 순서대로 저장) 
	 * @param empTypeCatNumList 고용형태 번호 리스트(String, 입력용, 포트폴리오 등록시 고용형태명을 복수 선택(체크박스) 후 등록버튼을 누르면 PortfolioVO.empTypeCatNumList에 고용형태 번호가 순서대로 저장)
	 * @param devCatNumList 개발분야 번호 리스트(String, 입력용, 포트폴리오 등록시 개발분야명을 복수 선택(체크박스) 후 등록버튼을 누르면 PortfolioVO.devCatNumList에 개발분야 번호가 순서대로 저장)
	 * @param acaCatNumList 학력 번호 리스트(String, 입력용, 포트폴리오 등록시 학력명을 복수 선택(체크박스) 후 등록버튼을 누르면 PortfolioVO.acaCatNumList에 학력 번호가 순서대로 저장)
	 */

}