package org.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreprocessorTwo {
    public String preprocess(String data){
        data = deleteSpace(data);
        return data;
    }

    public String findAllBrackets(String data){
        ArrayList<String> brackets = new ArrayList<>();

        Pattern pattern = Pattern.compile("[\\[\\]()]*");
        Matcher matcher = pattern.matcher(data);

        while (matcher.find()){
            brackets.add(matcher.group());
        }
        return String.join("", brackets);
    }

    static protected String deleteSpace(String data){
        return data.replaceAll("\\s+", "");
    }
}

