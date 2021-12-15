package com.bondarenko.io.fileanalyzer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FileAnalyzer {

    public Result analyze(String path, String word) throws IOException {

        validatePath(path);
        validateWord(word);

        String text = readFile(path);
        List<String> sentences = filteredSentences(text, word);
        int count = countWords(text, word);

        return new Result(word, sentences, count);
    }

    public String readFile(String path) throws IOException {
        String text = "";
        try (FileInputStream fileInputStream = new FileInputStream(path);
             InputStreamReader inputReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferReader = new BufferedReader(inputReader)) {
            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
                text += line;
            }
            return text;
        } catch (IOException e) {
            throw new IOException("The path for keystore file is blank. Provide a valid path");
        }
    }

    public List<String> filteredSentences(String text, String word) {
        List<String> list = new ArrayList<>();
        String[] sentences = text.split("\\.|!|\\?");
        for (String sentence : sentences) {
            String lowerSentence = sentence.toLowerCase();
            if (lowerSentence.contains(word.toLowerCase())) {
                list.add(lowerSentence);
            }
        }
        return list;
    }

    public int countWords(String text, String word) {
        int count = 0;
        List<String> list = new ArrayList<>();
        String[] sentences = text.split("\\.|!|\\?");
        for (String sentence : sentences) {
            String lowerSentence = sentence.toLowerCase();
            if (lowerSentence.contains(word.toLowerCase())) {
                String words[] = lowerSentence.split(" ");
                for (String element : words) {
                    if (element.equals(word)) {
                        list.add(word);
                        count = list.size();
                    }
                }
            }
        }
        return count;
    }

    private List<String> splitToSentences(String text) {
        List list = new ArrayList();
        String[] sentences = text.split("\\.|!|\\?");
        list.add(sentences);
        for (int i = 0; i < sentences.length; i++) {
            list.add(sentences[i]);

        }
        return list;
    }

    private void validatePath(String path) {
        if (path == null) {
            throw new NullPointerException("The path for keystore file is blank. Provide a valid path");
        }
    }

    private void validateWord(String word) {
        if (word == null) {
            throw new NullPointerException("The word is blank. Provide a valid word");
        }
    }


    String formatResult(Result result) {
        StringBuilder stringBuilder = new StringBuilder("\n" +
                "Outputs: \nIn the text,the word (");
        stringBuilder.append(result.getWord());
        stringBuilder.append(") occurs ");
        stringBuilder.append(result.getCount());
        stringBuilder.append(" times.");
        stringBuilder.append(" All the sentences with this word:\n");
        for (String sentence : result.getSentences()) {
            stringBuilder.append(sentence).append("\r\n");
        }
        return stringBuilder.toString();
    }
}
