package card1;

public class Dealder {
	Card[][] cards;
	int indexNumber; // 카드배열의 인덱스, 최대 13
	int indexShape; // 카드배열의 인덱스, 최대 4 
	
	void setCards(Card[][] cards) {
		this.cards = cards;
	}
	// 카드 섞기
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
	//카드 배열 출력(테스트용)
	void showCards() {
		for(int i=0; i<cards.length; i++) {
			for(int j=0; j<cards[0].length; j++) {
				System.out.println(cards[i][j].number+cards[i][j].shape+"   ");
			}
		}
	}

	// 이 메소드가 호출 될 때 마다 index를 증가시켜서 배열의 다음 요소를 가르키게 한다. = 다음카드
    // 현재 카드배열 [13][4]
	Card giveOneCard() {
	    Card card = cards[indexNumber][indexShape];
	    if(indexShape>=cards[0].length-1 && indexNumber<cards.length){
	        indexShape = 0;
	        indexNumber++;
	    } else if(indexShape<cards.length-1 && indexNumber<cards.length){
	        indexShape++;
	    } else {
	        System.out.println("카드 없음");
    	}
		return card;
	}
	
}
