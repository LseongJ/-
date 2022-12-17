import javax.swing.*;

public class Player_A extends CardPlayer {
    public Player_A(int max_cards) {
        super(max_cards);
    }
    public boolean wantsACard() {
        String response = JOptionPane.showInputDialog
        ("A : Do you want another card (Y or N)?"); 
        return response.equals("Y");
    }

    public String setBet(){
        String betting = JOptionPane.showInputDialog
        ("A : 베팅 금액을 입력하십시오");
        return betting;
    }

}