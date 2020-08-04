package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TinyURL {

    private int currentId;
    private Map<Integer, String> id2URLMap;
    private Map<String, Integer> URL2idMap;
    private Map<Integer, Character> baseId2CharMap;
    private Map<Character, Integer> baseChar2IdMap;
    private int base;


    public TinyURL() {
        // add initialization of id generator and map
        id2URLMap = new HashMap<>();
        URL2idMap = new HashMap<>();
        initBaseMap();
        currentId = 1;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int id = saveLongURL(longUrl);

        StringBuffer sb = new StringBuffer();
        while (id > 0) {
            sb.append(baseId2CharMap.get(id % base));
            id = id / base;
        }
        return sb.reverse().toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int id = 0;
        for (int i = 0; i < shortUrl.length(); i++) {
            char currChar = shortUrl.charAt(i);
            Integer integer = baseChar2IdMap.get(currChar);
            id = id * base + integer;
        }
        return id2URLMap.get(id);
    }

    public int saveLongURL(String longUrl) {
        int savedId = currentId;
        id2URLMap.put(currentId, longUrl);
        URL2idMap.put(longUrl, currentId);
        currentId++;
        return savedId;
    }

    public void initBaseMap() {
        baseId2CharMap = new HashMap<>();
        baseChar2IdMap = new HashMap<>();
        String baseStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        base = baseStr.length();
        for (int i = 0; i < baseStr.length(); i++) {
            baseId2CharMap.put(i, baseStr.charAt(i));
            baseChar2IdMap.put(baseStr.charAt(i), i);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));