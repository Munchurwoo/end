package join.us.GoodJob.model.vo;

public class EmpTypeCatVO {
	private String empTypeNum;
	private String empTypeName;
	public EmpTypeCatVO() {
		super();
		
	}
	public EmpTypeCatVO(String empTypeNum, String empTypeName) {
		super();
		this.empTypeNum = empTypeNum;
		this.empTypeName = empTypeName;
	}
	public String getEmpTypeNum() {
		return empTypeNum;
	}
	public void setEmpTypeNum(String empTypeNum) {
		this.empTypeNum = empTypeNum;
	}
	public String getEmpTypeName() {
		return empTypeName;
	}
	public void setEmpTypeName(String empTypeName) {
		this.empTypeName = empTypeName;
	}
	@Override
	public String toString() {
		return "EmpTypeCatVO [empTypeNum=" + empTypeNum + ", empTypeName=" + empTypeName + "]";
	}
}
