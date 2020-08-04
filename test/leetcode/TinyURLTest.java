package leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class TinyURLTest {

    @Test
    public void testEncoding() {
        TinyURL tinyURL = new TinyURL();

        String longUrl1 = "https://codingbat.com/java/Map-1";
        String longUrl2 = "https://leetcode.com/problems/zigzag-conversion/";
        String longUrl3 = "https://www.codewars.com/dashboard";

        String shortUrl1 = tinyURL.encode(longUrl1);
        String shortUrl2 = tinyURL.encode(longUrl2);
        String shortUrl3 = tinyURL.encode(longUrl3);

        System.out.println("shortUrl1: " + shortUrl1);
        System.out.println("shortUrl2: " + shortUrl2);
        System.out.println("shortUrl3: " + shortUrl3);

        String decodedUrl1 = tinyURL.decode(shortUrl1);
        String decodedUrl2 = tinyURL.decode(shortUrl2);
        String decodedUrl3 = tinyURL.decode(shortUrl3);

        System.out.println("decodedUrl1: " + decodedUrl1);
        System.out.println("decodedUrl2: " + decodedUrl2);
        System.out.println("decodedUrl3: " + decodedUrl3);

        assertEquals(longUrl1, decodedUrl1);
        assertEquals(longUrl2, decodedUrl2);
        assertEquals(longUrl3, decodedUrl3);
    }

}