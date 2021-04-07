package sec02.exam04;

public class CarExample {
	public static void main(String[] args) {
		Tire t1 = new HankookTire(); // Upcasting
		Tire t2 = new HankookTire();
		Tire t3 = new KumhoTire();
		Tire t4 = new KumhoTire();
		
		Tire[] tires = {t1, t2, t3, t4};
		for(Tire aTire : tires) {
			if(aTire instanceof HankookTire) {
				((HankookTire) aTire).hanRun();
			} else if (aTire instanceof KumhoTire) {
				((KumhoTire) aTire).kumRun();
			}
		}
	}
}
