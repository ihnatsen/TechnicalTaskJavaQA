package org.example;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class TaskOne {
    static String[] names = {"John"};
    static Pattern namePattern = Pattern.compile("^[A-Za-z]+(-[A-Za-z]+)*$");
    static Pattern numericPattern = Pattern.compile("-*\\d+(\\.?\\d+)?");
    static Pattern numericArrayPattern = Pattern.compile("^\\{-*\\d+(\\.?\\d+)?(,-?\\d+(\\.?\\d+)?)*\\}$");

    String printIntoConsole(String input) {

        if (isNumber(input))
            return Float.parseFloat(input) > 7 ? "Hello" : "";

        else if (isName(input))

            return Arrays.asList(names).contains(input)
                    ? "Hello, " + input
                    : "There is no such name";

        else if (isEmptyArray(input)) {
            return "[]";

        } else if (isNumericArray(input)) {
            Matcher matcher = numericPattern.matcher(input);
            ArrayList<Float> numbers = new ArrayList<>();

            while (matcher.find()) {
                numbers.add(Float.parseFloat(matcher.group()));
            }
            return numbers.stream()
                    .filter(n -> n % 3 == 0)
                    .distinct()
                    .collect(Collectors.toList()).toString();
        } else
            return "";
    }

    protected static Boolean isEmptyArray(String input){
        return input.contains("{}");

    }

    protected static Boolean isNumber(String input) {
        Matcher matcher = numericPattern.matcher(input);
        return matcher.matches();
    }

    protected static Boolean isName(String input) {
        return namePattern.matcher(input).find();

    }

    protected static Boolean isNumericArray(String input) {
        Matcher matcher = numericArrayPattern.matcher(input);
        return matcher.matches();
    }

}