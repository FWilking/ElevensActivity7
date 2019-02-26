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

        System.out.println("**** Original Deck Methods ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        System.out.println("**** Deal a Card ****");
        System.out.println("  deal: " + d.deal());
        System.out.println();
        System.out.println();

        System.out.println("**** Deck Methods After 1 Card Dealt ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        System.out.println("**** Deal Remaining 5 Cards ****");
        for (int i = 0; i < 5; i++) {
            System.out.println("  deal: " + d.deal());
        }
        System.out.println();
        System.out.println();

        System.out.println("**** Deck Methods After All Cards Dealt ****");
        System.out.println("  toString:\n" + d.toString());
        System.out.println("  isEmpty: " + d.isEmpty());
        System.out.println("  size: " + d.size());
        System.out.println();
        System.out.println();

        System.out.println("**** Deal a Card From Empty Deck ****");
        System.out.println("  deal: " + d.deal());
        System.out.println();
        System.out.println();

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
