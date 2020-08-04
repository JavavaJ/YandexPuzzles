package some_playground;

public class MockBook {

    private String name;
    private String author;

    public MockBook(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "MockBook{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
