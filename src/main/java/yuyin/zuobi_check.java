package yuyin;


import org.apache.commons.lang3.StringUtils;

public class zuobi_check {
    public static String removeSpecialChar(String text){
        text = text.replaceAll("#|\\*|/|\\s","");
        text = text.replaceAll("[\\p{P}]", "");
        return text;
    }
    public static int editDistance(String str1, String str2) {
        if(StringUtils.isEmpty(str1)){
            if(StringUtils.isEmpty(str2)) return 0;
            return str2.length();
        }
        if(StringUtils.isEmpty(str2)){
            if(StringUtils.isEmpty(str1)) return 0;
            return str1.length();
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = str1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = str2.charAt(j);
                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i][j])); // 这里不需要递归实现了
                }
            }
        }
        return  dp[len1][len2];
    }
    public static void main(String args[]){
        String text ="在解答商家提出的问题时，美团销售人员需要在回答中包含某些要点。下面给你一段销售所说的话:\\n销售：{}\\n请你判断销售的话中是否包含了\"{}\"这个要点。输出结果用\"是\"或者\"否\"回答，不要输出其他无关内容 ";
        System.out.println(removeSpecialChar(text));
        System.out.println(editDistance(text,"sdsd"+text+"dsdsd"));


        String ref="老板您说的没错，确实有一小部分商家也是因为生意清淡的原因才做团购，这部分商家也是通过我们的合作让更多的人知道和了解他们，达到带来更多人气的效果，现如今团购模式和之前也发生了很大的变化，从之前的快速集聚人气到现在成为常规的营销渠道和满足商家的广告推广的需求，有很多商家告诉我在网上做推广成为了他们固定的营销渠道，主要也是顺应消费者消费习惯的改变。就像海底捞每天都排很长的队，但他也一直做团购，也是这个道理，这也好比可口可乐生意也很好，但他也在不断的做广告，王总您看一下这是我们合作的商家，他们每天生意也很好，但也在做团购，也是为了提前做好积累，更好的抓住线上用户，我们跟着消费者的习惯走总归没有错吧!";

        String query="老板您说的没错确实有一小部分 商家也是因为生意清淡的原因才做的团购这部分商家也是通过我们的合作让更多的人知道和了解他们达到带来的更多人气效果现如今团购模式和之前也发生了很大的变化从之前的快捷集聚人气到现在成为常规的营销渠道和满足商家的广告推广需求有很多的商家告诉我在网上推广成为了他们的固定的营营销渠道主要的消费习惯。";
        System.out.println(editDistance(removeSpecialChar(ref),removeSpecialChar(query)));
    }
}
