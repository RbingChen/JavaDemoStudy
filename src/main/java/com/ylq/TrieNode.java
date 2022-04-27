package com.ylq;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TrieNode  {
    /**
     * true 关键词的终结 ； false 继续
     */
    private boolean end = false;

    /**
     * key下一个字符，value是对应的节点
     */
    private Map<Character, TrieNode> subNodes;
    public TrieNode(){
        this.subNodes = new HashMap<>();
    }
    /**
     * 向指定位置添加节点树
     */
    private void addSubNode(Character key, TrieNode node) {
        subNodes.put(key, node);
    }

    /**
     * 获取下个节点
     */
    private TrieNode getSubNode(Character key) {
        return subNodes.get(key);
    }

    private boolean isKeywordEnd() {
        return end;
    }

    private void setKeywordEnd(boolean end) {
        this.end = end;
    }

    /**
     * 判断是否是一个符号
     */
    private boolean isSymbol(char c) {
        int ic = (int) c;
        // 0x2E80-0x9FFF 东亚文字范围
        return !CharUtils.isAsciiAlphanumeric(c) && (ic < 0x2E80 || ic > 0x9FFF);
    }


    public  void addWord(String lineTxt) {
        TrieNode tempNode = this;
        // 循环每个字节
        for (int i = 0; i < lineTxt.length(); ++i) {
            Character c = lineTxt.charAt(i);
            // 过滤空格 不是英文 不是东亚文字，则过滤
            if (isSymbol(c)) {
                continue;
            }
            TrieNode node = tempNode.getSubNode(c);

            if (node == null) { // 没初始化
                node = new TrieNode();
                tempNode.addSubNode(c, node);
            }
            tempNode = node;
        }
        tempNode.setKeywordEnd(true);
    }

    /**
     * 过滤敏感词
     */
    public String filter(String text) {
        if (StringUtils.isBlank(text)) {
            return text;
        }
        String replacement = "***";//用***代替敏感词
        StringBuilder result = new StringBuilder();   //如果不是敏感词则存放在result中

        TrieNode tempNode = this;
        int begin = 0; // 回滚数
        int position = 0; // 当前比较的位置

        while (position < text.length()) {
            char c = text.charAt(position);
            // 空格直接跳过
            if (isSymbol(c)) {
                if (tempNode == this) {
                    result.append(c);
                    ++begin;
                }
                ++position;
                continue;
            }

            tempNode = tempNode.getSubNode(c);

            // 当前位置的匹配结束
            if (tempNode == null) {
                // 以begin开始的字符串不存在敏感词
                result.append(text.charAt(begin));
                // 跳到下一个字符开始测试
                position = begin + 1;
                begin = position;
                // 回到树初始节点
                tempNode = this;
            } else if (tempNode.isKeywordEnd()) {
                // 发现敏感词， 从begin到position的位置用replacement替换掉
                result.append(replacement);
                position = position + 1;
                begin = position;
                tempNode = this;
            } else {
                ++position;
            }
        }

        result.append(text.substring(begin));

        return result.toString();
    }
}
