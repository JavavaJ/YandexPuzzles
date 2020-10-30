package some_playground.junit;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Simple JUnit 5 example")
class SimpleJUnit5TestsTest {

    private List<String> list;

    @BeforeAll
    public static void initDBConnection(TestInfo testInfo) {
        System.out.println("Initialize DB connection");
        System.out.println(testInfo.getDisplayName());
    }

    @BeforeEach
    @DisplayName("Initialize list")
    public void initList() {
        list = new ArrayList<>();
        list.add("work");
        list.add("home");
    }

    @Test
    @DisplayName("Assert size 2 list")
    public void testListSize() {
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Assert list's content")
    public void testListContent() {
        assertAll(
            () -> assertTrue(list.contains("home")),
            () -> assertTrue(list.contains("work"))
        );
    }

    @Test
    @DisplayName("Negative assert content")
    public void testNotHaveIrrelevantContent() {
        assertAll(
            () -> assertFalse(list.contains("Java")),
            () -> assertFalse(list.contains("docker"))
        );
    }

    @AfterEach
    @DisplayName("Clear the list")
    public void testClearList() {
        list.clear();
    }

    @AfterAll
    public static void cleanUpDBConnection() {
        System.out.println("Clean up DB connection");
    }
}