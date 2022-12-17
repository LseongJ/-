public class ComputerPlayer extends CardPlayer {
    public ComputerPlayer(int max_cards) { 
        super(max_cards); 
    }
    public boolean wantsACard() { 
        int sum = 0;
        for(int i=0; i<card_count; i++)
            sum += my_hand[i].getCount();
        return sum < 15;
    }
}