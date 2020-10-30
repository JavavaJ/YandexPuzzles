package some_playground;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classification {

    public static final String ALL_LINKS = "/Users/alex/Desktop/Classification/all_links.txt";
    public static final String KIND = "/Users/alex/Desktop/Classification/kindgirls.txt";
    public static final String JPG = "/Users/alex/Desktop/Classification/jpg.txt";
    public static final String OTHERS = "/Users/alex/Desktop/Classification/others.txt";


    public static void main(String[] args) {
        Classification classification = new Classification();
        classification.classify();
    }

    public boolean isExtensionJpg(String url) {
        if (url.length() < 4) {
            return false;
        }
        return url.substring(url.length() - 4).equals(".jpg");
    }

    public void classify() {
        List<String> links = oldReadFile();

        List<String> kindLinks = new ArrayList<>();
        List<String> jpgLinks = new ArrayList<>();
        List<String> otherLinks = new ArrayList<>();

        for (String link : links) {
            if (link.contains("kindgirls")) {
                kindLinks.add(link);
            } else if (isExtensionJpg(link)) {
                jpgLinks.add(link);
            } else {
                otherLinks.add(link);
            }
        }

        System.out.println("================================= KIND LINKS =================================");
        kindLinks.forEach(System.out::println);

        writeString(KIND, collapseStreamToStr(kindLinks));

        System.out.println("================================= JPG LINKS =================================");
        jpgLinks.forEach(System.out::println);

        writeString(JPG, collapseStreamToStr(jpgLinks));

        System.out.println("================================= OTHER LINKS =================================");

        writeString(OTHERS, collapseStreamToStr(otherLinks));
    }

    public String collapseStreamToStr(List<String> strings) {
        return strings.stream()
            .collect(Collectors.joining("\n\r"));
    }

    @SneakyThrows
    public List<String> readFile() {
        String fileName = ALL_LINKS;
        Path path = Paths.get(fileName);
        List<String> links = Files.lines(path)
            .filter(link -> !link.equals(""))
            .collect(Collectors.toList());
        return links;
    }

    @SneakyThrows
    public List<String> oldReadFile() {
        List<String> lines = new ArrayList<>();

        File file = new File(ALL_LINKS);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    @SneakyThrows
    public void writeString(String fileName, String content) {
        Files.write(Paths.get(fileName), content.getBytes() );
    }
}
