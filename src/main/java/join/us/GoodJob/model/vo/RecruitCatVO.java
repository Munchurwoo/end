package join.us.GoodJob.model.vo;

public class RecruitCatVO {
	private String rcNum;
	private String rcName;
	public RecruitCatVO() {
		super();
		
	}
	public RecruitCatVO(String rcNum, String rcName) {
		super();
		this.rcNum = rcNum;
		this.rcName = rcName;
	}
	public String getRcNum() {
		return rcNum;
	}
	public void setRcNum(String rcNum) {
		this.rcNum = rcNum;
	}
	public String getRcName() {
		return rcName;
	}
	public void setRcName(String rcName) {
		this.rcName = rcName;
	}
	@Override
	public String toString() {
		return "RecruitCatVO [rcNum=" + rcNum + ", rcName=" + rcName + "]";
	}
}
