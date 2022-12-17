import java.util.*;
import javax.swing.*;

class Main {
    public static void main(String[] args) {
        while (true) {
            boolean flag = true;
            CardDeck carddeck = new CardDeck();   // 52장 생성
            CardPlayer cp = new ComputerPlayer(52);
            CardPlayer hm = new HumanPlayer(52);
            int money = 1000;
            
            System.out.println("얼마를 베팅할 건가요?");

            //처음에 2장씩 가진다.
            hm.receiveCard(carddeck.newCard());
            hm.receiveCard(carddeck.newCard());
            System.out.println(Arrays.toString(hm.showCards()));

            cp.receiveCard(carddeck.newCard());
            cp.receiveCard(carddeck.newCard());

            System.out.println("플레이어의 처음 카드합은 " + hm.get_sum() + " 입니다");
            System.out.println("딜러의 처음 카드합은 " + cp.get_sum() + " 입니다");
            
            if (hm.get_sum() > 21) {
                System.out.println("플레이어의 패배");
                flag = false;
            }
            else if (hm.get_sum() == 21) {
                System.out.println("플레이어의 승리(Blackjack!!!)");
                flag = false;
            }
            else if (cp.get_sum() > 21) {
                System.out.println("플레이어의 승리");
                flag = false;
            }

            boolean cp_stay = false;
            boolean hm_stay = false;
            while (flag) {
                if (hm_stay == false && (hm.wantsACard() == true)){
                    hm.receiveCard(carddeck.newCard());     // hit
                    System.out.println("플레이어의 카드합: " + hm.get_sum());
                    if (hm.get_sum() > 21) {
                        System.out.println("플레이어의 패배");
                        flag = false;
                        break;
                    }
                    else if (hm.get_sum() == 21) {
                        System.out.println("플레이어의 승리(Blackjack!!!)");
                        flag = false;
                        break;
                    }
                }
                else{
                    hm_stay = true;
                }
                if (cp_stay == false && (cp.wantsACard() == true)){
                    cp.receiveCard(carddeck.newCard());     // hit
                    System.out.println("딜러의 카드합은: " + cp.get_sum());
                    if (cp.get_sum() > 21) {
                        System.out.println("플레이어의 승리");
                        flag = false;
                        break;
                    }
                }
                else{
                    cp_stay = true;
                }
                if (cp_stay && hm_stay) {
                    break;
                }
            }
            if (flag) {
                if (hm.get_sum() > cp.get_sum()) {
                    System.out.println("플레이어의 승리");
                }
                else if (cp.get_sum() > hm.get_sum()) {
                    System.out.println("플레이어의 패배");
                }
                else {
                    System.out.println("무승부");
                }
            }
            String response = JOptionPane.showInputDialog
                ("Do you want play more? (Y or N)?"); 
                if (response.equals("Y") == true){
                    System.out.println("더한다는뎁쇼?");
                }
                else {
                    System.out.println("응안해");
                    break;
                }
        }
    }
}