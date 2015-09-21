package com.tomwoz.pather.core;

import com.sun.xml.internal.ws.api.ResourceLoader;
import com.tomwoz.pather.traverser.WordSetTraverser;

import java.io.*;
import java.util.HashSet;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        final Stream<String> stream = new BufferedReader(new FileReader("src/main/resources/words/words.txt")).lines();


        final Set<String> wordSet = stream.filter(x -> x.length() == 4)
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println(wordSet.size());

        final WordSetTraverser traverser = new WordSetTraverser(stream);
    }

}
