package com.ylq;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class FilterSensitiveWord {
    public static void main(String args[]){
        TrieNode trieNode = new TrieNode();
        trieNode.addWord("毛泽东");
        trieNode.addWord("日本鬼子");
        trieNode.addWord("日本人");
        System.out.println(trieNode.filter("毛泽东是中国第一任主席，日本人啊不是日本鬼子"));
    }
}
