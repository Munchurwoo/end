package join.us.GoodJob.model.vo;

public class InterviewVO {
	private String interviewNum;
	private String normalId;
	private String companyId;
	private String jobPostingNum;
	private String title;
	private String content;
	private NormalMemberVO normalMemberVO;
	public InterviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InterviewVO(String interviewNum, String normalId, String companyId, String jobPostingNum, String title,
			String content, NormalMemberVO normalMemberVO) {
		super();
		this.interviewNum = interviewNum;
		this.normalId = normalId;
		this.companyId = companyId;
		this.jobPostingNum = jobPostingNum;
		this.title = title;
		this.content = content;
		this.normalMemberVO = normalMemberVO;
	}
	public String getInterviewNum() {
		return interviewNum;
	}
	public void setInterviewNum(String interviewNum) {
		this.interviewNum = interviewNum;
	}
	public String getNormalId() {
		return normalId;
	}
	public void setNormalId(String normalId) {
		this.normalId = normalId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getJobPostingNum() {
		return jobPostingNum;
	}
	public void setJobPostingNum(String jobPostingNum) {
		this.jobPostingNum = jobPostingNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public NormalMemberVO getNormalMemberVO() {
		return normalMemberVO;
	}
	public void setNormalMemberVO(NormalMemberVO normalMemberVO) {
		this.normalMemberVO = normalMemberVO;
	}
	@Override
	public String toString() {
		return "InterviewVO [interviewNum=" + interviewNum + ", normalId=" + normalId + ", companyId=" + companyId
				+ ", jobPostingNum=" + jobPostingNum + ", title=" + title + ", content=" + content + ", normalMemberVO="
				+ normalMemberVO + "]";
	}
	
	
}
