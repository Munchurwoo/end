package join.us.GoodJob.model.vo;

public class DevCatVO {
	private String devCatNum;
	private String devCatName;
	public DevCatVO() {
		super();
		
	}
	public DevCatVO(String devCatNum, String devCatName) {
		super();
		this.devCatNum = devCatNum;
		this.devCatName = devCatName;
	}
	public String getDevCatNum() {
		return devCatNum;
	}
	public void setDevCatNum(String devCatNum) {
		this.devCatNum = devCatNum;
	}
	public String getDevCatName() {
		return devCatName;
	}
	public void setDevCatName(String devCatName) {
		this.devCatName = devCatName;
	}
	@Override
	public String toString() {
		return "DevCatVO [devCatNum=" + devCatNum + ", devCatName=" + devCatName + "]";
	}
}
