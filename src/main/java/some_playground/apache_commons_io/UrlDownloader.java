package some_playground.apache_commons_io;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.UUID;

public class UrlDownloader {

    public static void main(String[] args) {
        UrlDownloader obj = new UrlDownloader();

        String url = "https://hwcdn.ddstatic.com/bp-content/fhg/legacy/photo_gals/1794/gal-1024-jpg/0001.jpg";
        obj.download(url);
    }

    public void download(String urlStr) {
        download(urlStr, generateUniqPath());
    }

    @SneakyThrows
    public void download(String urlStr, String fileStr) {
        URL url = new URL(urlStr);
        FileUtils.copyURLToFile(url, new File(fileStr));
        System.out.println("success");
    }

    public String generateUniqPath() {
        String folderPath = "/Users/alex/Desktop/images/";
        String uniquePath = folderPath + UUID.randomUUID()
            .toString() + ".jpg";
        return uniquePath;
    }
}
