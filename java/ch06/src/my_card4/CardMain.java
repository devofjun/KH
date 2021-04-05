package my_card4;

public class CardMain {
	public static void main(String[] args) {
		CardCreator creator = new CardCreator(); // 카드배열 생성하는 객체
		Card[] cards = creator.createCards(); // 카드 [13][4]만큼 만들고 배열 받아오기
		Dealer dealer = Dealer.getInstance(); // 카드 관리 객체
		dealer.setCards(cards); // 카드 관리 객체에 카드 주소 넘기기
		//dealder.showCards();
		dealer.shuffleCards(); // 카드 섞기
		//dealer.showCards();
		Card card = dealer.giveOneCard(); // 가장 위에있는 카드 한장 꺼내기
		card.showInfo(); // 카드 출력
		Card anothercard = dealer.giveOneCard();
		anothercard.showInfo();
		System.out.println("=================");
		dealer.showCards();
	}
}
