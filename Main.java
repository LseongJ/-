class Main {
    public static void main(String[] args) {
        CardDeck carddeck = new CardDeck();   // 52장 생성
        CardPlayer cp = new ComputerPlayer(5);
        CardPlayer hm = new HumanPlayer(52);
 
        //cp.receiveCard(carddeck.newCard());
        //cp.receiveCard(carddeck.newCard());
        hm.receiveCard(carddeck.newCard());
        hm.receiveCard(carddeck.newCard());
        System.out.println(hm.get_sum());

        //System.out.println("실행");
        //System.out.println(hm.wantsACard());
        //System.out.println(cp.wantsACard());
        //System.out.println("딜러의 카드합은 " + cp.get_sum() + " 입니다");
        
        while (true) {
            if (hm.wantsACard() == true){
                hm.receiveCard(carddeck.newCard());     // hit
                System.out.println(hm.get_sum());
            }
            else{
                break;
            }
        }
        System.out.println("밖으로나옴");
        
    }
}
