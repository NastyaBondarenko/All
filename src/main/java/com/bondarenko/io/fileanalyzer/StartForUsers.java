package com.bondarenko.io.fileanalyzer;

import java.io.IOException;

public class StartForUsers {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Write two arguments!");
        }

        FileAnalyzer fileAnalyzer = new FileAnalyzer();

        String path = args[0];
        String word = args[1];

        Result result = fileAnalyzer.analyze(path, word);
        System.out.println(fileAnalyzer.formatResult(result));
    }
}



