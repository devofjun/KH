package exam04;

public class Member {
	String name;
	String id;
	String pw;
	int age;
	
	public Member() {
	}
	
	public Member(String name, String id, String pw, int age) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pw=" + pw + ", age=" + age + "]";
	}
	
	
	
}
