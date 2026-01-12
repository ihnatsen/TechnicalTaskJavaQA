package org.example;

import java.util.Scanner;

public class Main {
    static PreprocessorOne preprocessorOne = new PreprocessorOne();
    static PreprocessorTwo preprocessorTwo = new PreprocessorTwo();
    static Scanner input = new Scanner(System.in);
    static TaskOne taskOne = new TaskOne();
    static TaskTwo taskTwo = new TaskTwo();

    public static void main(String[] args) {
        System.out.println("=====Beginning of the first task=====\n");
        runTheFirstTask();
        System.out.println("=====Finishing of the first task=====\n");

        System.out.print("=====Beginning of the second task=====\n");
        runTheSecondTask();
        System.out.print("=====Finishing of the second task=====");

    }
    public static void runTheFirstTask(){
        System.out.print("Enter something:");
        String inputText = preprocessorOne.preprocess(input.nextLine());
        System.out.println(taskOne.printIntoConsole(inputText));
    }

    public static void runTheSecondTask(){
        System.out.println("Enter bracket sequence:");
        String inputText = preprocessorTwo.preprocess(input.nextLine());
        System.out.println(taskTwo.printIntoConsole(inputText));

    }
}
