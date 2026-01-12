package org.example;

public class PreprocessorOne {
    public String preprocess(String data){
        data = deleteSpace(data);
        return data;
    }

    static protected String deleteSpace(String data){
        return data.replaceAll("\\s+", "");
    }
}
