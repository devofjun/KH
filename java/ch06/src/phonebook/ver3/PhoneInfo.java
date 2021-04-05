package phonebook.ver3;

public class PhoneInfo {
	private String name;
	private String number;
	
	public PhoneInfo() {
		
	}
	public PhoneInfo(String name){
		this.name = name;
	}
	public PhoneInfo(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "PhoneInfo [name=" + name + ", number=" + number + "]";
	}
	
	public void showInfo() {
		System.out.println("이름: "+name);
		System.out.println("전번: "+number);
		System.out.println("------------------");
	}
}
