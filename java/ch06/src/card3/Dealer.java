package card3;

public class Dealer {
	private Card[] cards;
	private int index; // 카드배열의 인덱스, 최대 13
	private static Dealer instance;
	
	private Dealer() {}
	
	public static Dealer getInstance() {
		if(instance == null)
			instance = new Dealer();
		return instance;
	}
	
	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	// 카드 섞기
	public void shuffleCards() {
		for(int i=0; i<cards.length; i++) {
			for(int j=0; j<cards.length; j++) {
				int rand1 = (int)(Math.random()*cards.length);
				Card tmp = cards[i];
				cards[i] = cards[rand1];
				cards[rand1] = tmp;
			}
		}
	}
	//카드 배열 출력(테스트용)
	public void showCards() {
		for(int i=0; i<cards.length; i++) {
			cards[i].showInfo();
		}
	}

	// 이 메소드가 호출 될 때 마다 index를 증가시켜서 배열의 다음 요소를 가르키게 한다. = 다음카드
    // 현재 카드배열 [13][4]
	public Card giveOneCard() {
	    Card card = cards[index];
	    if(index>=cards.length-1) {
	    	System.out.println("카드가 없음");
	    } else {
	    	index++;
	    }
		return card;
	}
	
}
