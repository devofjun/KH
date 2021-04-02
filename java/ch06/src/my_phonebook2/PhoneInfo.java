package my_phonebook2;

public class PhoneInfo {
	String name;
	String number;
	
	PhoneInfo(String name,String number){
		this.name = name;
		this.number = number;
	}
	void showInfo(){
		System.out.println(name+" : "+number);
	}
}
