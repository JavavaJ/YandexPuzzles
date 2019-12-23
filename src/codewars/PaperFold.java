package codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public class PaperFold implements IntSupplier {

    private int currInd = 0;
    private List<Integer> sequence;
    private int paddingNum = 1; // it can be only zero or one

    public PaperFold() {
        initList();
    }

    @Override
    public int getAsInt() {
        Integer currValue = null;
        if (currInd >= sequence.size()) {
            // do one more doubling
            doubleSequence();
            currValue = getIntFromSequence();
        } else {
            currValue = getIntFromSequence();
        }

        return currValue;
    }

    private void doubleSequence() {
        List<Integer> newSequence = new ArrayList<>();
        for (Integer num : sequence) {
            newSequence.add(getPaddingNum());
            newSequence.add(num);
            changePaddingNum();
        }
        newSequence.add(0);
        setPaddingNumToInitialState();
        sequence = newSequence;
    }

    private Integer getIntFromSequence() {
        Integer currValue = sequence.get(currInd);
        incrementCurrInd();
        return currValue;
    }

    private void incrementCurrInd() {
        currInd++;
    }

    private void initList() {
        sequence = new ArrayList<>();
        sequence.add(new Integer(1));
    }

    private void changePaddingNum() {
        if (paddingNum == 0) {
            paddingNum = 1;
        } else if (paddingNum == 1) {
            paddingNum = 0;
        }
    }

    private int getPaddingNum() {
        return paddingNum;
    }

    private void setPaddingNumToInitialState() {
        paddingNum = 1;
    }

}
