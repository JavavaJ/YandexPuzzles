package some_playground.jsoup;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static void main(String[] args) {
        Parser obj = new Parser();
        String url = "https://www.kindgirls.com/photo/metart/avery_20_39505/9097/15/5/";

        String sourceUrl = obj.getImageSourceUrlFromUrl(url);
        System.out.println(sourceUrl);
    }

    public String getImageSourceUrlFromUrl(String url) {
        String html = getHTMLFromUrl(url);
        return getImageSourceUrl(html);
    }

    public String getImageSourceUrl(String html) {
        Document doc = Jsoup.parse(html);
        Element imgElement = doc.select("img")
            .first();
        String sourceUrl = imgElement.attr("src");
        return sourceUrl;
    }

    @SneakyThrows
    public String  getHTMLFromUrl(String url) {
        String html = IOUtils.toString(new URL(url));
        return html;
    }
}
