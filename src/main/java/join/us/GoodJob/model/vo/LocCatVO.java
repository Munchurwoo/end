package join.us.GoodJob.model.vo;

public class LocCatVO {
	private String locNum;
	private String locName;
	public LocCatVO() {
		super();
		
	}
	public LocCatVO(String locNum, String locName) {
		super();
		this.locNum = locNum;
		this.locName = locName;
	}
	public String getLocNum() {
		return locNum;
	}
	public void setLocNum(String locNum) {
		this.locNum = locNum;
	}
	public String getLocName() {
		return locName;
	}
	public void setLocName(String locName) {
		this.locName = locName;
	}
	@Override
	public String toString() {
		return "LocCatVO [locNum=" + locNum + ", locName=" + locName + "]";
	}
}
