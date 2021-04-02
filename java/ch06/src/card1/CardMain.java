package card1;

public class CardMain {
	public static void main(String[] args) {
		CardCreator creator = new CardCreator();
		Card[][] cards = creator.createCards();
		Dealder dealer = new Dealder();
		dealer.setCards(cards);
		//dealder.showCards();
		dealer.shuffleCards();
		//dealer.showCards();
		Card card = dealer.giveOneCard();
		card.showInfo();
		Card anothercard = dealer.giveOneCard();
		anothercard.showInfo();
	}
	
}
