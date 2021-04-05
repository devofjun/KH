package my_card4;

public class Dealder {
	private Card[] cards;
	private int index; 
	
	public void setCards(Card[] cards) {
		this.cards = cards;
	}
	// 카드 섞기
	public void shuffleCards() {
		for(int i=0; i<cards.length; i++) {
			int rand = (int)(Math.random()*cards.length);
			Card tmp = cards[i];
			cards[i] = cards[rand];
			cards[rand] = tmp;
		}
	}
	//카드 배열 출력
	public void showCards() {
		for(int i=0; i<cards.length; i++) {
			System.out.println(cards[i]);
		}
	}

	// 이 메소드가 호출 될 때 마다 index를 증가시켜서 배열의 다음 요소를 가르키게 한다. = 다음카드
    // 현재 카드배열 [13][4]
	public Card giveOneCard() {
	    Card card = cards[index];
	    if(index>=cards.length-1){
	        System.out.println("카드 없음");
	    } else {
	        index++;
    	}
		return card;
	}
}
