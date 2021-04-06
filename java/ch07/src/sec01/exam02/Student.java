package sec01.exam02;

public class Student extends People{
	/* 아무 생성자도 만들지 않으면 이렇게 default로 만들어지는데
	 * super() => People에 기본생성자가 없기 때문에 에러가 뜨는것임
	public Student() {
		super();
	}
	*/ 
	public int studentNo;
	
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.name = name;
		this.ssn = ssn;
		this.studentNo = studentNo;
	}
}
