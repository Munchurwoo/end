package join.us.GoodJob.model.vo;

public class QuestionAnswerVO {
	private String normalId;
	private String qaNum;
	private String jobPostingNum;
	private String question;
	private String answer;
	public QuestionAnswerVO() {
		super();
		
	}
	public QuestionAnswerVO(String normalId, String qaNum, String jobPostingNum, String question, String answer) {
		super();
		this.normalId = normalId;
		this.jobPostingNum = jobPostingNum;
		this.question = question;
		this.answer = answer;
	}
	public String getNormalId() {
		return normalId;
	}
	public void setNormalId(String normalId) {
		this.normalId = normalId;
	}
	public String getQaNum() {
		return qaNum;
	}
	public void setQaNum(String qaNum) {
		this.qaNum = qaNum;
	}
	public String getJobPostingNum() {
		return jobPostingNum;
	}
	public void setJobPostingNum(String jobPostingNum) {
		this.jobPostingNum = jobPostingNum;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "QuestionAnswerVO [normalId=" + normalId + ", qaNum=" + qaNum + ", jobPostingNum=" + jobPostingNum
				+ ", question=" + question + ", answer=" + answer + "]";
	}
}
