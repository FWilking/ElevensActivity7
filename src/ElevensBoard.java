import java.util.ArrayList;
import java.util.List;

public class ElevensBoard {
    private final Card[] dealtCards;
    private final Deck deck;

    public ElevensBoard(int size, String[] ranks, String[] suits, int[] points){
        this.dealtCards = new Card[size];
        this.deck = new Deck(ranks, suits, points);
        dealCards();
    }

    public void dealCards(){
        for(int i = 0; i < dealtCards.length; i++){
            dealtCards[i] =  deck.deal();
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < dealtCards.length; i++) {
            s = s + i + ": " + dealtCards[i] + "\n";
        }
        return s;
    }

    public boolean isEmpty(){
        for (Card card : dealtCards){
            if (card != null){
                return false;
            }
        }
        return true;
    }

    public boolean win(){
        if (deck.isEmpty()){
            return isEmpty();
        }
        return false;
    }

    public List<Integer> empties(){
        List<Integer> selected = new ArrayList<Integer>();
        for (int i = 0; i < dealtCards.length; i++){
            if(dealtCards[i] == null) selected.add(new Integer(i));
        }
        return selected;
    }

    public void replaceCards(){
        List<Integer> selected = empties();
        for (Integer num : selected){
            dealtCards[num.intValue()] = deck.deal();
        }
    }
}