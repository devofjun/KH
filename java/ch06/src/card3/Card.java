package card3;

public class Card {
	private int number;
	private String shape;
	public static final int width = 50;
	public static final int height = 100;

	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	Card(int num, String s){
		this.number = num;
		this.shape = s;
	}
	
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

	public static int getWidth() {
		return width;
	}

	public static int getHeight() {
		return height;
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
