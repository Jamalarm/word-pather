package com.tomwoz.pather.traverser;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordSetTraverser {
    private final Stream<String> words;

    public WordSetTraverser(Stream<String> words) {
        this.words = words;
    }


    public Optional<List<String>> traverse(String start, String end) {

        if (start.equals(end)) {
            return Optional.of(Collections.singletonList(end));
        }

        if (start.length() != end.length()) {
            return Optional.empty();
        }

        final HashSet<String> dictionary = words
                .filter(x -> x.length() == start.length())
                .collect(Collectors.toCollection(HashSet::new));

        if (!dictionary.contains(start) || !dictionary.contains(end)) {
            return Optional.empty();
        }

        Optional<List<String>> path = traverseRecursively(dictionary, start, end);

        return null;
    }

    private Optional<List<String>> traverseRecursively(Set<String> dictionary, String start, String end) {
        return null;
    }
}
