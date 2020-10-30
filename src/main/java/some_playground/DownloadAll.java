package some_playground;

import lombok.SneakyThrows;
import some_playground.apache_commons_io.UrlDownloader;
import some_playground.jsoup.Parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DownloadAll {

    public static void main(String[] args) {
        DownloadAll downloadAll = new DownloadAll();
        Parser htmlParser = new Parser();
        UrlDownloader urlDownloader = new UrlDownloader();

        List<String> links = downloadAll.generateLinks();

        int count = 1;
//        List<String> links = downloadAll.readFile();
        int size = links.size();
        for (String link : links) {
            String imgUrl = htmlParser.getImageSourceUrlFromUrl(link);
            urlDownloader.download(imgUrl);
        }

    }

    @SneakyThrows
    public List<String> readFile() {
        String fileName = Classification.KIND;
        Path path = Paths.get(fileName);
        List<String> links = Files.lines(path)
            .filter(link -> !link.equals(""))
            .collect(Collectors.toList());
        return links;
    }

    public List<String> generateLinks() {
        List<String> links = new ArrayList<>();
        String template = "https://www.kindgirls.com/photo/metart/nata_olga_3334/3067/15/%d/";

        for (int i = 1; i <= 15; i++) {
            String link = String.format(template, i);
            links.add(link);
        }
        return links;
    }

}
