import javax.swing.*;
class Main {
    public static void main(String[] args) {
        
        while (true){
            CardDeck carddeck = new CardDeck();   // 52장 생성
            CardPlayer cp = new ComputerPlayer(5);
            CardPlayer hm = new HumanPlayer(52);

            cp.receiveCard(carddeck.newCard());
            cp.receiveCard(carddeck.newCard());

            hm.receiveCard(carddeck.newCard());
            hm.receiveCard(carddeck.newCard());
            System.out.println("플레이어의 처음 카드합: " + hm.get_sum());
            System.out.println("딜러의 처음 카드합: " + cp.get_sum());

            if (hm.get_sum() >= 22){       // hm이 22가 넘으면,
                // 패배를 선언함
                System.out.println("플레이어의 패배(Bust)");
                // 패배
                // 프로그램 종료
            }

            else if (hm.get_sum() == 21){
                System.out.println("플레이어의 승리(Blackjack1)");
                // 승리
                // 프로그램 종료
            }
            else if (cp.get_sum() == 21){
                System.out.println("딜러의 승리(Blackjack1)");
                // 승리
                // 프로그램 종료
            }

            else if (hm.get_sum() < 21 && cp.get_sum() >= 22){
                // 승리
                // 종료
                System.out.println("플레이어의 승리2)");
            }

            // 둘 다 초기sum < 21인 경우
            boolean cp_stay = false;
            boolean hm_stay = false;
            while (true) {
                if (hm_stay == false && (hm.wantsACard() == true)){   //hit
                    hm.receiveCard(carddeck.newCard());
                    System.out.println("플레이어의 카드합: " + hm.get_sum());
                    if (hm.get_sum() >= 22){       // hm이 22가 넘으면,
                        // 패배를 선언함
                        System.out.println("플레이어의 패배(Bust)");
                        // 패배
                        // 프로그램 종료
                        break;
                    }
            
                    else if (hm.get_sum() == 21){
                        System.out.println("플레이어의 승리3(Blackjack!!!)");
                        // 승리
                        // 프로그램 종료
                        break;
                    }     
                }
                else{
                    hm_stay = true;
                }
                if (cp_stay == false && (cp.wantsACard() == true)){   //hit
                    cp.receiveCard(carddeck.newCard());
                    System.out.println("딜러의 카드합: " + cp.get_sum());
                    if (cp.get_sum() >= 22){
                        System.out.println("플레이어의 승리4");
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

            if (cp.get_sum() > hm.get_sum()){
                System.out.println("딜러의 승리");
            }
            else if (cp.get_sum() < hm.get_sum() && hm.get_sum() < 21){
                System.out.println("플레이어의 승리5");
            }
            else if (cp.get_sum() == hm.get_sum() && hm.get_sum() < 21){
                System.out.println("무승부"); }
            

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