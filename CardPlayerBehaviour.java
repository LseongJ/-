public interface CardPlayerBehaviour { 
    public boolean wantsACard(); 
    public void receiveCard(Card c);
    public void hit();
    public boolean stay();
    public int get_sum();
}