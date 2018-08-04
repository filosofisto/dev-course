package com.cursojava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w+");
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);

        // check all occurance
        while (matcher.find()) {
            System.out.printf("%s [%d, %d]\n", matcher.group(), matcher.start(), matcher.end());
        }
    }
}
