package com.example.esun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

@SpringBootTest
public class PracticeTest {

    @Test
    void StreamTest(){
        final String input = "1,2,3";

        final List<String> outPut = Stream.of(input.split(",")).map(PRE_FIX_TEST).toList();

        System.out.println(outPut);
    }

    private final static Function<String,String> PRE_FIX_TEST = key -> "TEST_" + key;

}
