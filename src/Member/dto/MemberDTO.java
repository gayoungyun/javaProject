package Member.dto;

public class MemberDTO {
	private String id, pwd, name, birth, tel, add;
	private int gender;
	private int num;
	
	public MemberDTO()
	{
		
	}
	
	public MemberDTO(String id, String name, String birth, String tel, String add)
	{
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.add = add;

	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getNum() {
		return gender;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
