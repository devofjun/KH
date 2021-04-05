package my_card4;

public class Card {
	private int number;
	private String shape;
	
	public Card() {	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public void showInfo() {
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

	@Override
	public String toString() {
		return "Card [number=" + number + ", shape=" + shape + "]";
	}
	
}
