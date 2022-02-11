package model;

import java.io.Serializable;

public class DictionaryEntry
        implements Comparable<DictionaryEntry>, Serializable {
    private String keyword;
    private String content;

    @Override
    public String toString() {
        return "Từ khóa: " + keyword
                + "\nNội dung: \n"
                + content;
    }

    public DictionaryEntry(String keyword, String content) {
        this.keyword = keyword;
        this.content = content;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int compareTo(DictionaryEntry o) {
        return this.keyword.compareToIgnoreCase(o.getKeyword());
    }
}
