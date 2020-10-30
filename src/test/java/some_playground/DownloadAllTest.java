package some_playground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DownloadAllTest {

    DownloadAll downloadAll;

    @BeforeEach
    public void initObject() {
        downloadAll = new DownloadAll();
    }

    @Test
    @DisplayName("File exists")
    void testFileExist() {
        String fileName = "/Users/alex/Desktop/links.txt";
        File file = new File(fileName);
        assertTrue(file.exists());
    }

    @Test
    @DisplayName("Generate links correctly")
    public void testGenerateLinks() {
        List<String> links = downloadAll.generateLinks();
        links.stream().forEach(System.out::println);
        assertEquals(15, links.size());
    }
}