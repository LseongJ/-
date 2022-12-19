import javax.swing.*;
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        int money_A = 1000;
        int money_B = 1000;
        




        while (true) {
            boolean flag = true;
            CardDeck carddeck = new CardDeck();   // 52장 생성
            CardPlayer A = new Player_A(10);
            CardPlayer B = new Player_B(10);
            int betting_money_A = 0;
            int betting_money_B = 0;
            //-------------------------------------------------------------------------//
            System.out.println("A의 현재 보유 금액: " + money_A);    // A 
            while (true){
                try{
                    betting_money_A = Integer.valueOf(A.setBet());  // 입력이 숫자가 아닌 것에 대한 예외처리
                    if (betting_money_A <= 0){
                        throw new NumberFormatException();
                    }
                    break;
                }
                catch(NumberFormatException e){
                    System.out.println("A : 베팅금액은 양수만 넣으십시오");
                }
                
            }
            while (true){  
                // betting_money_A < 0인 경우를 예외처리 해야함(money가 오히려 더 늘어남)
                money_A = money_A - betting_money_A;   // A의 잔고
                if (money_A < 0){
                    System.out.println("A : 현재 보유 금액보다 높은 금액은 베팅할 수 없습니다.");
                    money_A += betting_money_A;  //복구
                    betting_money_A = Integer.valueOf(A.setBet());
                }
                else{
                    System.out.println("A의 현재 잔금:" + money_A);
                    break;
                }    
            }
            //-------------------------------------------------------------------------//
            System.out.println("B의 현재 보유 금액: " + money_B);    // B 
            while (true){
                try{
                    betting_money_B = Integer.valueOf(B.setBet());  // 입력이 숫자가 아닌 것에 대한 예외처리
                    if (betting_money_B <= 0){
                        throw new NumberFormatException();
                    }
                    break;
                }
                catch(NumberFormatException e){
                    System.out.println("B : 베팅금액은 양수만 넣으십시오");
                }
            }
            while (true){  
                // betting_money_B < 0인 경우를 예외처리 해야함(money가 오히려 더 늘어남) 
                money_B = money_B - betting_money_B;     
                if (money_B < 0){
                    System.out.println("B : 현재 보유 금액보다 높은 금액은 베팅할 수 없습니다.");
                    money_B += betting_money_B;  //복구
                    while (true){
                        try{
                            betting_money_B = Integer.valueOf(B.setBet());  // 입력이 숫자가 아닌 것에 대한 예외처리
                            if (betting_money_B <= 0){
                                throw new NumberFormatException();
                            }
                            break;
                        }
                        catch(NumberFormatException e){
                            System.out.println("B : 베팅금액은 양수만 넣으십시오");
                        }
                    }
                }
                else{
                    System.out.println("B의 현재 잔금:" + money_B);
                    break;
                }    
            }
            //-------------------------------------------------------------------------//
            //처음에 2장씩 가진다.
            A.receiveCard(carddeck.newCard());
            A.receiveCard(carddeck.newCard());

            B.receiveCard(carddeck.newCard());
            B.receiveCard(carddeck.newCard());

            System.out.println("A의 처음 카드합은 " + A.get_sum() + " 입니다");
            System.out.println("B의 처음 카드합은 " + B.get_sum() + " 입니다");
            //------------------------------------------------------------------------//
            //test 승부가 처음에 날려면 둘 중하나는 버스트거나 블랙잭이면 끝남
            if (A.get_sum() > 21){    // A가 버스트인 경우
                if (B.get_sum() > 21){       // A, B 둘 다 버스트
                    if (A.get_sum() > B.get_sum()){
                        System.out.println("B의 승리1");
                        money_B += (betting_money_B * 2);
                        flag = false;
                    }
                    else if (A.get_sum() == B.get_sum()){
                        System.out.println("무승부(Bust)");
                        money_A += betting_money_A;
                        money_B += betting_money_B;
                        flag = false;
                    }
                    else{
                        System.out.println("A의 승리1");
                        money_A += (betting_money_A * 2);
                        flag = false;
                    }
                }
                else if (B.get_sum() < 21){     // A만 버스트
                    if (B.get_sum() == 21){
                        System.out.println("B의 승리2(blackjack");  
                        money_B += (betting_money_B * 3);
                        flag = false;
                    }
                    else if(B.get_sum() < 21){
                        System.out.println("B의 승리3");  
                        money_B += (betting_money_B * 2);
                        flag = false;
                    }
                }
            }
            if (A.get_sum() == 21){
                if (B.get_sum() != 21){
                    System.out.println("A의 승리2(blackjack)");
                    money_A += (betting_money_A * 3);
                    flag = false;
                }
                else{
                    System.out.println("무승부(blackjack)");
                    money_A += betting_money_A;
                    money_B += betting_money_B;
                    flag = false;
                }
            }
            //---//
            if (B.get_sum() > 21){    // B가 버스트인 경우
                if (A.get_sum() > 21){       // A, B 둘 다 버스트
                    if (A.get_sum() > B.get_sum()){
                        System.out.println("B의 승리4");
                        money_B += (betting_money_B * 2);
                        flag = false;
                    }
                    else if (A.get_sum() == B.get_sum()){
                        System.out.println("무승부(Bust)");
                        money_A += betting_money_A;
                        money_B += betting_money_B;
                        flag = false;
                    }
                    else{
                        System.out.println("A의 승리3");
                        money_A += (betting_money_A * 2);
                        flag = false;
                    }
                }
                else if (A.get_sum() < 21){     // B만 버스트
                    if (A.get_sum() == 21){
                        System.out.println("A의 승리4(blackjack");  
                        money_B += (betting_money_B * 3);
                        flag = false;
                    }
                    else if(A.get_sum() < 21){
                        System.out.println("A의 승리5");  
                        money_B += (betting_money_B * 2);
                        flag = false;
                    }
                }
            }
            if (B.get_sum() == 21){
                if (B.get_sum() != 21){
                    System.out.println("A의 승리6(blackjack)");
                    money_A += (betting_money_A * 3);
                    flag = false;
                }
                else{
                    System.out.println("무승부(blackjack)");
                    money_A += betting_money_A;
                    money_B += betting_money_B;
                    flag = false;
                }
            }
            //------------------------------------------------------------------------//
            boolean B_stay = false;
            boolean A_stay = false;
            while (flag) {
                if (A_stay == false && (A.wantsACard() == true)){
                    A.receiveCard(carddeck.newCard());     // hit
                    System.out.println("A의 카드합: " + A.get_sum());
                    if (A.get_sum() > 21) {
                        System.out.println("B의 승리5");
                        money_B += (betting_money_B * 2);
                        flag = false;
                        break;
                    }
                    else if (A.get_sum() == 21) {
                        System.out.println("A의 승리(Blackjack!!!)");
                        money_A = money_A + (betting_money_A * 3);
                        flag = false;
                        break;
                    }
                }
                else{
                    System.out.println("A의 카드합: " + A.get_sum());
                    A_stay = true;
                }
                if (B_stay == false && (B.wantsACard() == true)){
                    B.receiveCard(carddeck.newCard());     // hit
                    System.out.println("B의 카드합은: " + B.get_sum());
                    if (B.get_sum() > 21) {
                        System.out.println("A의 승리7");
                        money_A = money_A + (betting_money_A * 2);
                        flag = false;
                        break;
                    }
                }
                else{
                    System.out.println("B의 카드합은: " + B.get_sum());
                    B_stay = true;
                }
                if (B_stay && A_stay) {
                    break;
                }
            }
            if (flag) {
                if (A.get_sum() > B.get_sum()) {
                    System.out.println("A의 승리8");
                    money_A = money_A + (betting_money_A * 2);
                }
                else if (B.get_sum() > A.get_sum()) {
                    System.out.println("B의 승리6");
                    money_B = money_B + (betting_money_B * 2);
                }
                else {
                    System.out.println("무승부");
                    money_A += betting_money_A; // 원금회복
                    money_B += betting_money_B;
                }
            }
           
            System.out.println("A의 현재 보유 금액: " + money_A);
            System.out.println("B의 현재 보유 금액: " + money_B);
            while (true){
                String response = JOptionPane.showInputDialog
                ("A, B : Do you want play more? (Y or N)?"); 
                if (response.equals("Y") == true){
                    System.out.println("---------------------------");
                    break;
                }
                else if (response.equals("N") == true){
                    System.out.println("프로그램을 종료합니다."); 
                    System.exit(0);
                }
                else{
                    System.out.println("Y 또는 N 만 입력해주십시오");
                }
            }
            
                
            
        }
    }
}
