public class Card {   //카드
    public static String SPADES = "spades"; 
    public static String HEARTS = "hearts"; 
    public static String DIAMONDS = "diamonds"; 
    public static String CLUBS = "clubs";

    public static int ACE = 1; 
    public static int JACK = 11; 
    public static int QUEEN = 12; 
    public static int KING = 13;

    public static int SIZE_OF_ONE_SUIT = 13;

    private String suit;  // 문양
    private int count;    // 숫자

    public Card(String s, int c) { 
        suit = s; count = c; 
    }
    public String getSuit() { 
        return suit; 
    }  // 문양을 반환
    public int getCount() { 
        return count; 
    }     // 숫자를 반환
}