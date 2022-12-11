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

    public int calc(){
        int sum_other = 0;
        for(int j = 0; j < card_count; j++){
            sum_other += my_hand[j].getCount();
        }
        return sum_other;
    }
}