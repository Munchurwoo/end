package join.us.GoodJob.model.vo;

public class AcaCatVO {
	private String academicNum;
	private String academicName;
	public AcaCatVO() {
		super();
		
	}
	public AcaCatVO(String academicNum, String academicName) {
		super();
		this.academicNum = academicNum;
		this.academicName = academicName;
	}
	public String getAcademicNum() {
		return academicNum;
	}
	public void setAcademicNum(String academicNum) {
		this.academicNum = academicNum;
	}
	public String getAcademicName() {
		return academicName;
	}
	public void setAcademicName(String academicName) {
		this.academicName = academicName;
	}
	@Override
	public String toString() {
		return "AcaCatVO [academicNum=" + academicNum + ", academicName=" + academicName + "]";
	}
}
