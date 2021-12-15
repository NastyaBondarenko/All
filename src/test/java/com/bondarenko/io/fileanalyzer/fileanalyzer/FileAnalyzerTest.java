package com.bondarenko.io.fileanalyzer.fileanalyzer;

import com.bondarenko.io.fileanalyzer.FileAnalyzer;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileAnalyzerTest {
    FileAnalyzer fileAnalyzer = new FileAnalyzer();
    String separator = File.separator;
    String path = "E:" + separator + "Робоча 2021" + separator + "Java" + separator + "datastructure" + separator + "src" + separator + "test" + separator + "java" + separator + "com" + separator + "bondarenko" + separator + "io" + separator + "fileanalyzer" + separator + "fileanalyzer" + separator + "story";

    String story = "Listen!One day! What happened?duck tried to kill hunter.It was a very angry duck.Was duck.";

    @Test
    public void testReadFile() throws IOException {

        String text = fileAnalyzer.readFile(path);
        assertEquals(story, text);
    }

    @Test
    public void testFilteredSentences() {
        List<String> expected = new ArrayList<>();
        expected.add("duck tried to kill hunter");
        expected.add("it was a very angry duck");
        expected.add("was duck");

        List<String> actual = fileAnalyzer.filteredSentences(story, "duck");

        assertEquals(expected, actual);
    }

    @Test
    public void testCountsWords() {
        int expected = 3;
        int actual = fileAnalyzer.countWords(story, "duck");

        assertEquals(expected, actual);
    }
}
