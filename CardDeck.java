public class CardDeck {  // 카드 덱
    private int card_count; // 남은 카드 수
    private Card[] deck = new Card[4 * Card.SIZE_OF_ONE_SUIT];
    // 불변식: deck[0]...deck[card_count-1]에는 카드가 있다.

    private void createSuit(String which_suit) {
    for(int i = 1; i <= Card.SIZE_OF_ONE_SUIT; i++) {
    deck[card_count] = new Card(which_suit, i);
    card_count++;
    }
    }

    public CardDeck() { 
    createSuit(Card.SPADES); createSuit(Card.HEARTS); 
    createSuit(Card.CLUBS); createSuit(Card.DIAMONDS);
    }


    public Card newCard() {  // 덱에서 카드 꺼내주기
        Card next_card = null; 
        if(card_count != 0 ) { 
        int index = (int)(Math.random() * card_count);
        next_card = deck[index];
        // 카드를 뽑은 위치부터 앞으로 당겨 준다.
        for(int i=index+1; i<card_count; i++) 
            deck[i-1] = deck[i];
            card_count--;
        }
        return next_card;
    }

    public boolean moreCards() { 
        return card_count > 0; 
    }
}