/**
 * Created by Teacher on 1/7/2019.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

    /**
     * cards contains all the cards in the deck.
     */
    private List<Card> cards;

    /**
     * size is the number of not-yet-dealt cards.
     * Cards are dealt from the top (highest index) down.
     * The next card to be dealt is at size - 1.
     */
    private int size;


    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits,
     * and produces one of the corresponding card.
     * @param ranks is an array containing all of the card ranks.
     * @param suits is an array containing all of the card suits.
     * @param values is an array containing all of the card point values.
     *
     */
    public Deck(String[] ranks, String[] suits, int[] values) {
        cards = new ArrayList<Card>();
        for(int i = 0; i < ranks.length; i++){
            for(String suit : suits){
                cards.add(new Card(ranks[i], suit, values[i]));
            }
        }
        size = cards.size();
        shuffle();
    }


    /**
     * Determines if this deck is empty (no undealt cards).
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Accesses the number of undealt cards in this deck.
     * @return the number of undealt cards in this deck.
     */
    public int size() {
		return size;
    }

    /**
     * Randomly permute the given collection of cards
     * and reset the size to represent the entire deck.
     */
    public void shuffle() {
		for(int i = 0; i < cards.size(); i++){
		    Card temp = cards.get(i);
		    int random = (int) (Math.random() * size);
		    cards.set(i, cards.get(random));
		    cards.set(random, temp);
        }
    }

    /**
     * Deals a card from this deck.
     * @return the card just dealt, or null if all the cards have been
     *         previously dealt.
     */
    public Card deal() {
		if(!isEmpty()){
		    size--;
		    return cards.get(size);
        }
        return null;
    }

    /**
     * Generates and returns a string representation of this deck.
     * @return a string representation of this deck.
     */
    @Override
    public String toString() {
        String output = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            output = output + cards.get(k);
            if (k != 0) {
                output = output + ", ";
            }
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                output = output + "\n";
            }
        }

        output = output + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; k--) {
            output = output + cards.get(k);
            if (k != size) {
                output = output + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                output = output + "\n";
            }
        }

        output = output + "\n";
        return output;
    }
}
