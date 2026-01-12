package org.example;
import java.util.*;
import java.util.stream.Collectors;


public class TaskTwo {

    public String printIntoConsole(String input){
        if(isCorrectSequence(input)){
            return "yes";
        }
        else {
            return "No. Change the brackets until the sequence is correct: " + fixBrackets(input);
        }

    }

    public Boolean isCorrectSequence(String s){
        Stack<Character> stack = new Stack<>();
        List<Character> openBrackets = List.of('(', '[');
        Map<Character, Character> openToClose = Map.of
                ('[',']', '(',')');
        List<Character> sequence = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        for(char c: sequence) {
            if (openBrackets.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                Character left_bracket = stack.pop();
                if (!openToClose.get(left_bracket).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static String fixBrackets(String s) {
        StringBuilder fixed = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
                fixed.append(c);
            } else {
                if (stack.isEmpty()) continue;

                char open = stack.pop();
                if (open == '(') fixed.append(')');
                else if (open == '[') fixed.append(']');
            }
        }

        while (!stack.isEmpty()) {
            char open = stack.pop();
            if (open == '(') fixed.append(')');
            else if (open == '[') fixed.append(']');
        }

        return fixed.toString();
    }

}

