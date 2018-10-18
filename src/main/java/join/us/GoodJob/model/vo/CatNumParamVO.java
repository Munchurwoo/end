package join.us.GoodJob.model.vo;

import java.util.List;

public class CatNumParamVO {
		private List<String> locCatNumList;
		private List<String> recruitCatNumList;
		private List<String> empTypeCatNumList;
		private List<String> devCatNumList;
		private List<String> acaCatNumList;
	private List<String> keywordNameList;
	public CatNumParamVO() {
		super();
	}
	public CatNumParamVO(List<String> locCatNumList, List<String> recruitCatNumList, List<String> empTypeCatNumList,
			List<String> devCatNumList, List<String> acaCatNumList, List<String> keywordNameList) {
		super();
		this.locCatNumList = locCatNumList;
		this.recruitCatNumList = recruitCatNumList;
		this.empTypeCatNumList = empTypeCatNumList;
		this.devCatNumList = devCatNumList;
		this.acaCatNumList = acaCatNumList;
		this.keywordNameList = keywordNameList;
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
	public List<String> getKeywordNameList() {
		return keywordNameList;
	}
	public void setKeywordNameList(List<String> keywordNameList) {
		this.keywordNameList = keywordNameList;
	}
	@Override
	public String toString() {
		return "CatNumParamVO [locCatNumList=" + locCatNumList + ", recruitCatNumList=" + recruitCatNumList
				+ ", empTypeCatNumList=" + empTypeCatNumList + ", devCatNumList=" + devCatNumList + ", acaCatNumList="
				+ acaCatNumList + ", keywordNameList=" + keywordNameList + "]";
	}
	
	
	
}
