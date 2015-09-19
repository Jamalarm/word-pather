package com.tomwoz.pather.core;

import com.sun.xml.internal.ws.api.ResourceLoader;

import java.io.*;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        final Stream<String> stream = new BufferedReader(new FileReader("src/main/resources/words/words.txt")).lines();

        final OptionalDouble average = stream.mapToInt(String::length).average();

        System.out.println(average);

    }

}
