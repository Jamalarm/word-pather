package com.tomwoz.pather.traverser;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class WordSetTraverserTest {


    public static final Stream<String> WORDS_1 = Stream.of("cake", "beans", "coat", "canada");
    public static final Stream<String> WORDS_2 = Stream.of("cat", "cap", "can", "car");


    @Test
    public void shouldReturnAbsentWhenWordDoesNotExist() {

        final WordSetTraverser traverser = new WordSetTraverser(WORDS_1);

        final Optional<List<String>> result = traverser.traverse("cat", "dog");

        assertFalse(result.isPresent());
    }

    @Test
    public void shouldReturnSingletonWhenStartAndEndWordAreTheSame() {

        final WordSetTraverser traverser = new WordSetTraverser(WORDS_1);

        final Optional<List<String>> result = traverser.traverse("cat", "cat");

        assertTrue(result.isPresent());
        assertEquals(result.get(), Collections.singletonList("cat"));
    }

    @Test
    public void shouldReturnSingleStepWhenWordsAreSingleDirectLetterApart() {

        final WordSetTraverser traverser = new WordSetTraverser(WORDS_2);

        final Optional<List<String>> result = traverser.traverse("cat", "car");

        assertTrue(result.isPresent());
        assertEquals(result.get(), Lists.newArrayList("cat", "car"));


    }

}