package some_playground;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pass_cracking.PassCracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PassCrackingTest {

    @Test
    public void testCrackThePass() {
        PassCracking obj = new PassCracking();
        Set<String> matchChars = obj.getMatchChars();
        Set<String> noMatchChars = obj.getNoMatchChars();

    }

    @Test
    public void testSomePasses() {
        PassCracking passCracking = new PassCracking();

        List<String> passes = Arrays.asList(
            "prayers",
            "servers",
            "missing",
            "solving",
            "posting",
            "seating",
            "logging",
            "secrets",
            "booking",
            "ranking",
            "parking",
            "sitting",
            "staying",
            "raising",
            "posters",
            "folders",
            "textfile",
            "pockets",
            "testing",
            "healing",
            "marking",
            "beliefs",
            "markers",
            "putting",
            "packet",
            "profits",
            "factors",
            "designs",
            "service",
            "evening",
            "physics",
            "targets"
        );

        for (String pass : passes) {
            passCracking.analyze(pass);
        }

    }

    @Test
    public void testPasses() {
        PassCracking passCracking = new PassCracking();
        passCracking.analyze("sending");
    }

    @Test
    public void testLetters() {
        PassCracking passCracking = new PassCracking();
        HashMap<Character, Boolean> letters =
            passCracking.getLetters();

        Boolean bool = letters.get('x');

        assertNull(letters.get('x'));
        assertFalse(letters.get('f'));
        assertTrue(letters.get('t'));
    }

}