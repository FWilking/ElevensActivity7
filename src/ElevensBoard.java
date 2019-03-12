import java.util.List;

public class ElevensBoard extends Board{

    public ElevensBoard(int size, String[] ranks, String[] suits, int[] points){
        super(size, ranks, suits, points);
    }

    public boolean isLegal(List<Integer> selectedCards) {
        if (selectedCards.size() == 2) {
            return containsPairSum11(selectedCards);
        } else if (selectedCards.size() == 3) {
            return containsJQK(selectedCards);
        } else {
            return false;
        }
    }

    public boolean anotherPlayIsPossible() {
        List<Integer> cIndexes = cardIndexes();
        return containsPairSum11(cIndexes) || containsJQK(cIndexes);
    }

    private boolean containsPairSum11(List<Integer> selectedCards) {
        for(Integer i : selectedCards){
            for(Integer j : selectedCards){
                if(cardAt(i).pointValue() + cardAt(j).pointValue() == 11){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsJQK(List<Integer> selectedCards) {
        boolean foundJack = false;
        boolean foundQueen = false;
        boolean foundKing = false;
        for (Integer kObj : selectedCards) {
            int k = kObj.intValue();
            if (cardAt(k).rank().equals("jack")) {
                foundJack = true;
            } else if (cardAt(k).rank().equals("queen")) {
                foundQueen = true;
            } else if (cardAt(k).rank().equals("king")) {
                foundKing = true;
            }
        }
        return foundJack && foundQueen && foundKing;
    }

    private boolean containsSuit(List<Integer> selectedCards, String suit){
        for(Integer i : selectedCards){
            if(cardAt(i).suit() == suit){
                return true;
            }
        }
        return false;
    }
}
