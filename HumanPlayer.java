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
}