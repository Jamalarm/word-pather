package com.tomwoz.pather.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrefixTrie {

    private final Map<Integer, Map<Character, TrieNode>> nodeIntern = new HashMap<>();


    private TrieNode getNode(char value, int index) {

        final TrieNode node;

        if (nodeIntern.containsKey(index) && nodeIntern.get(index).containsKey(value)) {
            node = nodeIntern.get(index).get(value);
        } else {
            node = new TrieNode(value, index);


            Map<Character, TrieNode> indexMap;
            if (!nodeIntern.containsKey(index)) {
                indexMap = new HashMap<>();
                nodeIntern.put(index, indexMap);
            } else {
                indexMap = nodeIntern.get(index);
            }
            indexMap.put(value, node);
        }

        return node;
    }

    public class TrieNode {

        private final char value;
        private final Set<TrieNode> children = new HashSet<>();
        private final Set<TrieNode> parents = new HashSet<>();
        private final int index;

        private TrieNode(char value, int index) {
            this.value = value;
            this.index = index;
        }
    }

}
