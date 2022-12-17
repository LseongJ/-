public interface CardPlayerBehaviour { 
    public boolean wantsACard(); 
    public void receiveCard(Card c);
    public int get_sum();
    public abstract String setBet();
}