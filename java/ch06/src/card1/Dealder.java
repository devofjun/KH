package card1;

public class Dealder {
	Card[][] cards;
	int indexNumber;
	int indexShape;
	
	void setCards(Card[][] cards) {
		this.cards = cards;
	}
	
	void shuffleCards() {
		for(int i=0; i<cards.length; i++) {
			for(int j=0; j<cards[0].length; j++) {
				int rand1 = (int)(Math.random()*cards.length);
				int rand2 = (int)(Math.random()*cards[0].length);
				Card tmp = cards[i][j];
				cards[i][j] = cards[rand1][rand2];
				cards[rand1][rand2] = tmp;
			}
		}
	}
	void showCards() {
		for(int i=0; i<cards.length; i++) {
			for(int j=0; j<cards[0].length; j++) {
				System.out.println(cards[i][j].number+cards[i][j].shape+"   ");
			}
		}
	}

	Card giveOneCard() {
		Card card = cards[indexNumber][indexShape];
		indexShape++;
		return card;
	}
	
}
