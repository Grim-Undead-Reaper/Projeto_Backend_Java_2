package com.ProductCrud.demo.service;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HandlerValues {
    public static String CapitalizeWord(String FullString){

        return Arrays.stream(FullString.split("\\s"))
        .map(word -> Character.toTitleCase(word.charAt(0)) + word.substring(1))
        .collect(Collectors.joining(" "));
    }
}
