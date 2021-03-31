package car1;

import java.util.Scanner;

public class CarMain {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Car mycar = new Car();
		do {
			if(mycar.pwCheck())
				System.out.println("1.시동끄기 2.가속패달 3.브레이크                                                                                  4.풀악셀을 밟는다!!!");
			else
				System.out.println("1.시동켜기 2.가속패달 3.브레이크");
			System.out.print(">");
			switch(scan.nextInt()) {
			case 1: // 시동켜기
				mycar.pwChange();
				break;
			case 2: // 가속
				mycar.carDrive();
				break;
			case 3: // 감속
				mycar.carBreak();
				break;
			case 4:
				while(mycar.spCheck()<100)
					mycar.carDrive();
				break;
			default :
				System.out.println("졸음운전하냐?");
			}
		}
		while(mycar.pwCheck());
		scan.close();
	}
}
