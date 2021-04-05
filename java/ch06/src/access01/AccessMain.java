package access01;

import access02.Dog;

public class AccessMain {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "홍길동"; // public이라서 접근 가능
		p1.age = 26; // 같은 패키지 안에 있기 때문에 접근 가능
		//p1.weight = 50.0f; 
		// private으로 감춰놨기 떄문에 보이지 않는다고(not visible) 오류뜸.
		
		Dog d1 = new Dog();
		d1.name = "RR"; // public은 다른 패키지여도 사용가능
		//d1.age = 4; // default는 다른 패키지에선 보이지 않는다.
		//d1.weight = 0.0f; // private
		d1.eat();
		System.out.println(d1.getWeight());
		d1.setWeight(10.0f);
		System.out.println(d1.getWeight());
	}
}
