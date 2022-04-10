package com.nextwork.leetcode;
/*
 *  2022 - 04 - 09 23:32
 *  注意长度相同
 * */

public class P32 {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int maxLen =0 ;
        for(int gap = 1 ; gap < len ;){
            for(int i =0;i+gap < len;i++){
                if(gap==1 ){
                    if(s.charAt(i)=='(' && s.charAt(i+gap)==')')
                        dp[i][i+gap] = true;
                    else dp[i][i+gap] = false;
                }else {
                    // 情况一 ( ( * ))
                    if (s.charAt(i) == '(' && s.charAt(i + gap) == ')' && dp[i + 1][i + gap - 1] == true) {
                        dp[i][i + gap] = true;
                    } else if (dp[i][i + 1] && dp[i + gap - 1][i + gap]) {
                    // 情况二 () * ()
                        if ((i + 2) > (i + gap - 2) || dp[i + 2][i + gap - 2]) dp[i][i + gap] = true;
                        else dp[i][i + gap] = false;
                    } else {
                      //  情况三 ()(())
                        for (int k = 1; k < gap; k += 2) {
                            if (dp[i][i + k] && dp[i + k + 1][i + gap]) {
                                dp[i][i + gap] = true;
                                break;
                            }
                        }
                    }
                }
                if(dp[i][i+gap]){
                    maxLen = Math.max(maxLen,gap+1);
                }
            }
            gap+=2;
        }
        return maxLen;
    }
    public static int longestValidParenthesesV2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    public static void main(String args[]){
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()(())"));

    }
}
