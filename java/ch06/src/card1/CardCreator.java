package card1;

public class CardCreator {
	Card[][] createCards() {
		// 2~10, A J Q K = 13
		// ♠ ◆ ♥ ♣ = 4
		Card[][] cards = new Card[13][4];
		for(int i=0; i<13; i++) {
			cards[i][0] = new Card(i+1,"♠");
			cards[i][1] = new Card(i+1,"◆");
			cards[i][2] = new Card(i+1,"♥");
			cards[i][3] = new Card(i+1,"♣");
		}
		//System.out.println(cards[12][3].number+cards[12][3].shape);
		//System.out.println(cards[12][2].number+cards[12][2].shape);
		return cards;
	}
}
