package code2023;
/*
https://leetcode.cn/problems/find-missing-observations/solutions/1029101/java-tan-xin-on-by-ichwin-kk11/
 */
public class P3 {
     public static int[] solutions(int[] rolls, int mean, int n) { 
        int sum = 0;
        for(int i=0;i<rolls.length;i++) {
            sum += rolls[i];
        }
        int totalCount = rolls.length + n;
        int sumOfN = mean * totalCount - sum;
        int meanOfN = sumOfN / n;
        int other = sumOfN % n;
        if(meanOfN > 6 || meanOfN <= 0 || meanOfN == 6 && other != 0) return new int[0];

        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            if(other > 0){
                res[i] = 1;
                other--;
            }
            res[i] += meanOfN;
        }
        return res;

    }
    
}
