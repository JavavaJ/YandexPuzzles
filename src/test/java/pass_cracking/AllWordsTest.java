package pass_cracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllWordsTest {

    @Test
    public void testConstructor() {
        AllWords allWords = new AllWords();
    }

    @Test
    public void testMatchWords() {
        PassCracking passCracking = new PassCracking();
        HashMap<Character, Boolean> letters =
            passCracking.getLetters();

        AllWords allWords = new AllWords();
        List<String> matchWords = allWords.getListOfMatchingWords(letters);
        System.out.println("matchWords size: " + matchWords.size());
        for (String word : matchWords) {
            System.out.println(word);
        }
    }

}