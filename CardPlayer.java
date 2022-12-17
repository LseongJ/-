public abstract class CardPlayer implements CardPlayerBehaviour {
    protected Card[] my_hand; 
    protected int card_count;
    

    public CardPlayer(int max_cards) { 
        my_hand = new Card[max_cards];
        card_count = 0;
    }
    public abstract boolean wantsACard();

    public int get_sum() {
        int sum = 0;
        for(int i=0; i<card_count; i++)
            sum += my_hand[i].getCount();
        return sum;
    }

    public void receiveCard(Card c) { 
        my_hand[card_count] = c;
        card_count = card_count + 1;
    }

    public abstract String setBet();
}