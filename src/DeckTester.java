/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

    /**
     * The main method in this class checks the Deck operations for consistency.
     *	@param args is not used.
     */
    public static void main(String[] args) {
        int arrSize = 10;
        String[] ranks = new String[arrSize];
        String[] suits = new String[arrSize];
        int[] points = new int[arrSize];
        for(int i = 0; i < ranks.length; i++){
            ranks[i] = generateName();
            suits[i] = generateName();
            points[i] = (int) (Math.random() * arrSize);
        }
        Deck d = new Deck(ranks, suits, points);
    }

    private static String generateName(){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String vowels = "aeiou";
        String name = "";
        for(int i = 0; i < ((int) (Math.random() * 5 + 1)); i++){
            name += letters.charAt((int) (Math.random() * letters.length()));
            name += letters.charAt((int) (Math.random() * vowels.length()));
        }
        return name;
    }
}
