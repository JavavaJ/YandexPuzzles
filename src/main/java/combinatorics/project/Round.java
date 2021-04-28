package combinatorics.project;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private List<Pair> pairs = new ArrayList<>();
    private int lastElemIndex = -1;

    public Round() {
    }

    public void addPair(Pair pair) {
        pairs.add(pair);
        lastElemIndex++;
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    public void removeLastPair() {
        pairs.remove(lastElemIndex);
        lastElemIndex--;
    }
}
