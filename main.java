import javax.swing.*;

class Main {
    public static void main(String[] args) {
        int money = 1000;
        while (true) {
            boolean flag = true;
            CardDeck carddeck = new CardDeck();   // 52장 생성
            CardPlayer cp = new ComputerPlayer(10);
            CardPlayer hm = new HumanPlayer(10);

            System.out.println("현재 보유 금액: " + money);
            int betting_money = Integer.valueOf(hm.setBet());
            while (true){  
                // betting_money < 0인 경우를 예외처리 해야함(money가 오히려 더 늘어남) 
                money = money - betting_money;     
                if (money < 0){
                    System.out.println("현재 보유 금액보다 높은 금액은 베팅할 수 없습니다.");
                    money += betting_money;  //복구
                    betting_money = Integer.valueOf(hm.setBet());
                }
                else{
                    System.out.println("현재 잔금:" + money);
                    break;
                }    
            }
          
            //처음에 2장씩 가진다.
            hm.receiveCard(carddeck.newCard());
            hm.receiveCard(carddeck.newCard());

            cp.receiveCard(carddeck.newCard());
            cp.receiveCard(carddeck.newCard());

            System.out.println("플레이어의 처음 카드합은 " + hm.get_sum() + " 입니다");
            System.out.println("딜러의 처음 카드합은 " + cp.get_sum() + " 입니다");
            
            if (hm.get_sum() > 21) {
                System.out.println("플레이어의 패배");
                flag = false;
            }
            else if (hm.get_sum() == 21) {
                money = money + (betting_money * 3);
                System.out.println("플레이어의 승리(Blackjack!!!)");
                flag = false;
            }
            else if (cp.get_sum() > 21) {
                System.out.println("플레이어의 승리");
                money = money + (betting_money * 2);
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
                        money = money + (betting_money * 3);
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
                        money = money + (betting_money * 2);
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
                    money = money + (betting_money * 2);
                }
                else if (cp.get_sum() > hm.get_sum()) {
                    System.out.println("플레이어의 패배");
                }
                else {
                    System.out.println("무승부");
                    money += betting_money; // 원금회복
                }
            }
           
            System.out.println("현재 보유 금액: " + money);
            String response = JOptionPane.showInputDialog
                ("Do you want play more? (Y or N)?"); 
                if (response.equals("Y") == true){
                    System.out.println("---------------------------");
                }
                else {
                    System.out.println("프로그램을 종료합니다."); 
                    break;
                }
        }
    }
}