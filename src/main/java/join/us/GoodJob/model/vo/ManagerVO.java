package join.us.GoodJob.model.vo;

public class ManagerVO extends MemberVO {
	private String managerLevel;

	public ManagerVO() {
		super();
		
	}

	public ManagerVO(String managerLevel) {
		super();
		this.managerLevel = managerLevel;
	}

	public String getManagerLevel() {
		return managerLevel;
	}

	public void setManagerLevel(String managerLevel) {
		this.managerLevel = managerLevel;
	}

	@Override
	public String toString() {
		return "ManagerVO [managerLevel=" + managerLevel + "]";
	}
	
}
