import javax.swing.*;

public class Player_B extends CardPlayer {
    public Player_B(int max_cards) { 
        super(max_cards); 
    }
    public boolean wantsACard() { 
        String response = JOptionPane.showInputDialog
        ("B : Do you want another card (Y or N)?"); 
        return response.equals("Y");
    }

    public String setBet(){
        String betting = JOptionPane.showInputDialog
        (" B : 베팅 금액을 입력하십시오");
        return betting;
    }
}