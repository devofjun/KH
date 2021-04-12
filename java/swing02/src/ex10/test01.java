package ex10;

public class test01 {
	public static void main(String[] args) {
		String ssn = "880815-1234567";
		String front = ssn.substring(0, 6);
		String rear = ssn.substring(7);
		System.out.println(front);
		System.out.println(rear);
		int len = ssn.length();
		System.out.println("ssn의 길이: " + len);
		System.out.println(ssn.charAt(2));
	}
}
