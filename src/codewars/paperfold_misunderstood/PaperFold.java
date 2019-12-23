package codewars.paperfold_misunderstood;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public class PaperFold implements IntSupplier {

    // Wikipedia: The regular paperfolding sequence, also known as the dragon curve sequence,
    // is an infinite automatic sequence of 0s and 1s defined as the limit of the following process:
    //
    //1
    //1 1 0
    //1 1 0 1 1 0 0
    //1 1 0 1 1 0 0 1 1 1 0 0 1 0 0
    //
    //At each stage an alternating sequence of 1s and 0s is inserted between the terms of the previous sequence.

    private int currInd = 0;
    private List<Integer> sequence;
    private int paddingNum = 0; // it can be only zero or one

    public PaperFold() {
        initList();
    }

    @Override
    public int getAsInt() {
        Integer currValue = null;
        if (currInd >= sequence.size()) {
            // do one more doubling
            getDoubleList();
            currValue = getIntegerIfNoDoublingRequired();
        } else {
            currValue = getIntegerIfNoDoublingRequired();
        }

        return currValue;
    }

    private Integer getIntegerIfNoDoublingRequired() {
        Integer currValue = sequence.get(currInd);
        incrementCurrInd();
        return currValue;
    }

    private void getDoubleList() {
        List<Integer> doubledList = new ArrayList<>(sequence);
        doubledList.addAll(sequence);
        doubledList.add(paddingNum);
        changePaddingNum();
        sequence = doubledList;
    }

    public void incrementCurrInd() {
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

    // debug method
    public int getPaddingNum() {
        return paddingNum;
    }

}
