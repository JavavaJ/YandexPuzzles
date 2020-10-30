//package some_playground.junit;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.RepeatedTest;
//import org.junit.jupiter.api.Test;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class JUnit5PlaygroundTest {
//
//    @Test
//    @DisplayName("Two lists are equal")
//    public void testIterables() {
//        List<Integer> list1 = Arrays.asList(11, 99, 77);
//        List<Integer> list2 = Arrays.asList(11, 99, 77);
//
//        assertIterableEquals(list2, list1);
//    }
//
//    @RepeatedTest(5)
//    @DisplayName("Repeated Test")
//    public void repeatedTest() {
//        System.out.println("This test runs 5 times");
//    }
//
//}