package ch05;

public class ArrayExample4 {
	public static void main(String[] args) {
		int[] staff = {200, 250, 300, 350, 400};
		addBonus(staff);
		int sum = calculateTotal(staff);
		for(int i=0; i<staff.length; i++)
			System.out.println("직원"+(i+1)+"에게 보너스 50추가하여 월급은"+staff[i]+"만원 입니다.");
		System.out.println("총 지급액: "+sum+"만원");
	}
	static void addBonus(int[] staffpay) {
		for(int i=0; i<staffpay.length; ++i) {
			staffpay[i] += 50;
		}
	}
	static int calculateTotal(int[] pay) {
		int sum = 0;
		for(int i=0; i<pay.length; ++i) {
			sum+=pay[i];
		}
		return sum;
	}
}
