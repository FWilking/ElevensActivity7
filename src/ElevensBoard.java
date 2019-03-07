import java.util.List;

public class ElevensBoard extends Board{

    public ElevensBoard(int size, String[] ranks, String[] suits, int[] points){
        super(size, ranks, suits, points);
    }

    public boolean isLegal(List<Integer> selectedCards) {
        return false;
    }

    public boolean anotherPlayIsPossible() {
        return false;
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
        if(containsSuit(selectedCards, "J") && containsSuit(selectedCards, "Q") && containsSuit(selectedCards, "K")){
            return true;
        }
        return false;
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
