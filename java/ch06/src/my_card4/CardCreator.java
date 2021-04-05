package my_card4;

public class CardCreator {
	public Card[] createCards() {
		// 2~10, A J Q K = 13
		// ♠ ◆ ♥ ♣ = 4
		String[] shapes = {"♠","◆","♥","♣"};
		Card[] cards = new Card[52];
		for(int i=0; i<cards.length; i++) {
			cards[i] = new Card();
			cards[i].setNumber((i%13)+1);
			cards[i].setShape(shapes[i/13]);
			//System.out.println(cards[i]);
		}
		return cards;
	}
}
