package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

class TaskOneTest {

    TaskOne taskOne = new TaskOne();

    @ParameterizedTest
    @CsvSource({
            "-1, ",
            " 0, ",
            " 6, ",
            " 7, ",
            "-1.0, ",
            " 0.0, ",
            " 6.0, ",
            " 7.0, ",
            " 8.0, Hello"
    })
    public void isGreaterThan7(String data, String expected){
        // problems of input empty value in CscSource
        String factResults = taskOne.printIntoConsole(data);
        if(expected==null)
            expected = "";
        assertEquals(expected, factResults);
    }

    @ParameterizedTest
    @MethodSource
    public void sayHelloName(String data, String expected){
        String factResults = taskOne.printIntoConsole(data);
        assertEquals(expected, factResults);
    }

    public static Stream<Arguments> sayHelloName(){
        return Stream.of(
                Arguments.of("John", "Hello, John"));
    }

    @ParameterizedTest
    @MethodSource
    public void multipleOfThreeArray(String data, List<String> multiplyNumbers){
        boolean hasAllMultiplyNumbers = multiplyNumbers.stream()
                .allMatch(taskOne.printIntoConsole(data)::contains);
        assertTrue(hasAllMultiplyNumbers);
    }

    public static Stream<Arguments> multipleOfThreeArray(){
        return Stream.of(
                Arguments.of("{3,3,-3,-3,3.0,-3.0,9,9,-9,-9,9,-9.0}", List.of("3.0", "-3.0", "9.0","-9.0")),
                Arguments.of("{-9,12,-3,6.0,-27.0,90.0}", List.of("-9.0","12.0","6.0","-27.0", "90.0"))
        );
    }
    @Test
    public void emptyArray(){
        String input = "{}";
        String factResult = taskOne.printIntoConsole(input);

        assertEquals("[]", factResult);
    }

    @ParameterizedTest
    @MethodSource
    public void sayThereIsNoSuchName(String data){
        String factResults = taskOne.printIntoConsole(data);
        assertEquals("There is no such name", factResults);
    }

    public static Stream<Arguments> sayThereIsNoSuchName(){
        return Stream.of(
               Arguments.of("xxx"),
               Arguments.of("Johnn"),
                Arguments.of("XXX"),
        Arguments.of("dad-daD"));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "", " ", "\t", "\n",
            "{1,-3,}",
            "123-",
            "-.",
            "0.0-",
            "!@#$%^&*()[]?/\"'",
            "-"
    })
    public void inputEmptyString(String data){
        String factResults = taskOne.printIntoConsole(data);
        assertEquals("", factResults);
    }
}
