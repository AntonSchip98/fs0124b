package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
     log.debug("ciao");

     var list = IntStream.range(0, 1000)
             .filter(n -> n % 2 == 0)
             .boxed()
             .toList();
    }
}