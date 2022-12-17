class Main {
    public static void main(String[] args) {
        CardDeck carddeck = new CardDeck();   // 52장 생성
        CardPlayer cp = new ComputerPlayer(5);
        CardPlayer hm = new HumanPlayer(52);
 
        cp.receiveCard(carddeck.newCard());
        cp.receiveCard(carddeck.newCard());

        hm.receiveCard(carddeck.newCard());
        hm.receiveCard(carddeck.newCard());
        System.out.println("플레이어의 처음 카드합: " + hm.get_sum());
        System.out.println("딜러의 처음 카드합: " + cp.get_sum());

        boolean cp_stay = false;
        boolean hm_stay = false;
        while (true) {
            if (hm_stay == false && (hm.wantsACard() == true)){
                hm.receiveCard(carddeck.newCard());     // hit
                System.out.println("플레이어의 카드합: " + hm.get_sum());
            }
            else{
                hm_stay = true;
            }
            if (cp_stay == false && (cp.wantsACard() == true)){
                cp.receiveCard(carddeck.newCard());     // hit
                System.out.println("딜러의 카드합: " + cp.get_sum());
            }
            else{
                cp_stay = true;
            }
            if (cp_stay && hm_stay) {
                break;
            }
        }
        
    }
}