package card1;

public class Card {
	int number;
	String shape;
	Card(int num, String s){
		this.number = num;
		this.shape = s;
	}
	void showInfo() {
		String strNumber = null;
		switch(number) {
		case 1:
			strNumber = "A";
			break;
		case 11:
			strNumber = "J";
			break;
		case 12:
			strNumber = "Q";
			break;
		case 13:
			strNumber = "K";
			break;
		default:
			strNumber = number+"";
		}
		System.out.println(strNumber + " " + shape);
	}
}
