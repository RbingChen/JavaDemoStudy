package code2022;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
public class P7 {
    public double average(int[] age) {
        Arrays.sort(age);
        int n = age.length, tot = 0;
        for (int i = n / 20; i < n - n / 20; i++) tot += age[i];
        double score =  tot * 1.0 / (n * 0.9);
        return score;
        /* 如果过不了，用下面代码
        score = new BigDecimal(score).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        DecimalFormat decimalFormat = new DecimalFormat("0.00000#");
        String scoreStr = decimalFormat.format(score);
        return scoreStr;
         */

    }
}
