package join.us.GoodJob.model.vo;

public class MemberVO {
	private String id;
	private String password;
	private String email;
	private String name;
	private String tel;
	private String type;
	private String address;
	public MemberVO() {
		super();
	}
	public MemberVO(String id, String password, String email, String name, String tel, String type, String address) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.tel = tel;
		this.type = type;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "memberVO [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", tel=" + tel
				+ ", type=" + type + ", address=" + address + "]";
	}
	
}

