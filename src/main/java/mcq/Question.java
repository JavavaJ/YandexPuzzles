package mcq;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Question {

    @JsonIgnore
    private Long id;

    private String question;

    private String a;

    private String b;

    private String c;

    private String d;

    private String rightAn;

    private String tags;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getRightAn() {
        return rightAn;
    }

    public void setRightAn(String rightAn) {
        this.rightAn = rightAn;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
