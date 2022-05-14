package com.nextwork.leetcode;

import java.util.*;

public class P126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet(wordList);
        if(!dict.contains((endWord))) return res;

        dict.remove(beginWord);
        Map<String,Integer> steps = new HashMap();
        steps.put(beginWord,0);
        Map<String,List<String>> from = new HashMap();
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length();
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                String currWord = queue.poll();
                char[] charArray = currWord.toCharArray();
                for(int j=0;j<wordLen;j++){
                    char origin = charArray[j];
                    for(char c = 'a';c<='z';c++){
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if(steps.containsKey(nextWord) && step==steps.get(nextWord)){
                            from.get(nextWord).add(currWord);
                        }
                        if(!dict.contains(nextWord)) continue;
                        dict.remove(nextWord);
                        queue.offer(nextWord);
                        if(!from.containsKey(nextWord)) from.put(nextWord,new ArrayList());
                        from.get(nextWord).add(currWord);
                        steps.put(nextWord,step);
                        if(nextWord.equals(endWord)){
                            found=true;
                        }
                    }
                    charArray[j] = origin;
                }


            }
            if(found) {
                System.out.println(step);
                break;
            }
            step++;
        }

        if(found){
            Deque<String> path = new LinkedList<>();
            path.add(endWord);
            dfs(from,path,beginWord,endWord,res);
        }



        return res;
    }

    public void dfs(Map<String,List<String>> from,Deque<String> path,String beginWord,String cur,List<List<String>> res){
        if(cur.equals(beginWord)){
            res.add(new ArrayList(path));
            return;
        }
        for(String pre : from.get(cur)){
            path.addFirst(pre);
            dfs(from,path,beginWord,pre,res);
            path.removeFirst();
        }
    }
    public static void main(String args[]){
       P126 p126 = new P126();
       String begin = "hit",end = "cog";
       String[] strs = new String[]{"hot","dot","dog","lot","log","cog"};
       List<String> lt = new ArrayList(Arrays.asList(strs));

       List<List<String>> res = p126.findLadders(begin,end,lt);
       for(List<String> ll : res){
           for(String ss : ll){
               System.out.print(ss+" ");
           }
           System.out.println();
       }

    }

}
