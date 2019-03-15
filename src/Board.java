import java.util.ArrayList;
import java.util.List;

public abstract class Board {
    private final Card[] dealtCards;
    private final Deck deck;

    public Board(int size, String[] ranks, String[] suits, int[] points){
        this.dealtCards = new Card[size];
        this.deck = new Deck(ranks, suits, points);
        this.deck.shuffle();
        dealCards();
    }

    public void dealCards() {
        for (int i = 0; i < dealtCards.length; i++) {
            dealtCards[i] = deck.deal();
        }
        deck.setSize(52);
    }

    public int size() {
        return dealtCards.length;
    }

    public void newGame() {
        deck.shuffle();
        dealCards();
    }

    public void deal(int k) {
        dealtCards[k] = deck.deal();
    }

    public Card cardAt(int k) {
        return dealtCards[k];
    }

    public int deckSize() {
        return deck.size();
    }

    public void replaceSelectedCards(List<Integer> selectedCards) {
        for (Integer num : selectedCards) {
            deal(num.intValue());
        }
    }

    public List<Integer> cardIndexes() {
        List<Integer> selected = new ArrayList<Integer>();
        for (int k = 0; k < dealtCards.length; k++) {
            if (dealtCards[k] != null) {
                selected.add(new Integer(k));
            }
        }
        return selected;
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

    public abstract boolean isLegal(List<Integer> selectedCards);
    public abstract boolean anotherPlayIsPossible();

    public List<Integer> empties(){
        List<Integer> selected = new ArrayList<Integer>();
        for (int i = 0; i < dealtCards.length; i++){
            if(dealtCards[i] == null) selected.add(new Integer(i));
        }
        return selected;
    }

//    public void replaceCards(){
//        List<Integer> selected = empties();
//        for (Integer num : selected){
//            dealtCards[num.intValue()] = deck.deal();
//        }
//    }
}
