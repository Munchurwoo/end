package join.us.GoodJob.model.vo;

import java.util.List;

public class NormalMemberVO extends MemberVO {
	
	private String normalId;	
	private String picturePath;	
	private String careerStatus;	
	private String gender;	
	private PortfolioVO portfolio;
	private List<QuestionAnswerVO> questionAnswerVOList;
	public NormalMemberVO() {
		super();
		
	}
	/**
	 * 모집직군 번호 리스트(String, 입력용) 
	 * @param normalId 개인회원 아이디
	 * @param picturePath 취업 사진 경로
	 * @param careerStatus 경력 여부(String) ex) C개발자로 ~에서 3년 활동했음.
	 * @param gender 성별
	 * @param portfolio 개인 포트폴리오 하나
	 * @param questionAnswerVOList 개인이 질문을 여러 개 등록
	 */
	public NormalMemberVO(String normalId, String picturePath, String careerStatus, String gender,
			PortfolioVO portfolio, List<QuestionAnswerVO> questionAnswerVOList) {
		super();
		this.normalId = normalId;
		this.picturePath = picturePath;
		this.careerStatus = careerStatus;
		this.gender = gender;
		this.portfolio = portfolio;
		this.questionAnswerVOList = questionAnswerVOList;
	}
	public String getNormalId() {
		return normalId;
	}
	public void setNormalId(String normalId) {
		this.normalId = normalId;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getCareerStatus() {
		return careerStatus;
	}
	public void setCareerStatus(String careerStatus) {
		this.careerStatus = careerStatus;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public PortfolioVO getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(PortfolioVO portfolio) {
		this.portfolio = portfolio;
	}
	public List<QuestionAnswerVO> getQuestionAnswerVOList() {
		return questionAnswerVOList;
	}
	public void setQuestionAnswerVOList(List<QuestionAnswerVO> questionAnswerVOList) {
		this.questionAnswerVOList = questionAnswerVOList;
	}
	@Override
	public String toString() {
		return "NormalMemberVO [normalId=" + normalId + ", picturePath=" + picturePath + ", careerStatus="
				+ careerStatus + ", gender=" + gender + ", portfolio=" + portfolio + ", questionAnswerVOList="
				+ questionAnswerVOList + "]";
	}
}
