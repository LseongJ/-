import javax.swing.*;

public class HumanPlayer extends CardPlayer {
    public HumanPlayer(int max_cards) {
        super(max_cards);
    }
    public boolean wantsACard() {
        String response = JOptionPane.showInputDialog
        ("Do you want another card (Y or N)?"); 
        return response.equals("Y");
    }

    public int calc(){
        int sum_player = 0;
        for(int j = 0; j < card_count; j++){
            sum_player += my_hand[j].getCount();
        }
        return sum_player;
    }
}