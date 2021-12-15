package com.bondarenko.io.fileanalyzer;

import java.util.List;

public class Result {
    private String word;
    private List<String> sentences;
    private int count;

    String getWord() {
        return word;
    }

    List<String> getSentences() {
        return sentences;
    }

    int getCount() {
        return count;
    }

    Result(String word, List<String> sentences, int count) {
        this.word = word;
        this.sentences = sentences;
        this.count = count;
    }
}
