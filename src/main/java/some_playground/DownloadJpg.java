package some_playground;

import lombok.SneakyThrows;
import some_playground.apache_commons_io.UrlDownloader;
import some_playground.jsoup.Parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DownloadJpg {

    public static void main(String[] args) {
        DownloadJpg obj = new DownloadJpg();
        UrlDownloader urlDownloader = new UrlDownloader();

        int count = 1;
        List<String> links = obj.readFile();
        int size = links.size();
        for (String link : links) {
            System.out.print(count + "/" + size + " ");
            urlDownloader.download(link.trim());
            count++;
        }
    }

    @SneakyThrows
    public List<String> readFile() {
        String fileName = Classification.JPG;
        Path path = Paths.get(fileName);
        List<String> links = Files.lines(path)
            .filter(link -> !link.equals(""))
            .collect(Collectors.toList());
        return links;
    }
}
