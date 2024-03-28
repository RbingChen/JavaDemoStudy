package code2023;

import java.util.*;
/**
 * 作者：吹梦西洲
 *         链接：https://leetcode.cn/problems/intersection-of-two-arrays/solutions/1832267/by-wu-pu-pu-pu-g8wt/
 *         来源：力扣（LeetCode）
 *         著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
public class P2 {
    //TEMPLATE BEGIN
    public static int[] getInterSection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) { // step1
            nums1Set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) { // step2
            if (nums1Set.contains(nums2[i])){
                resultSet.add(nums2[i]);
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (Integer item : resultSet) { //step3
            result[index++] = item;
        }

        return result;

    }
    //TEMPLATE END

    //APPEND BEGIN
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int gn = reader.nextInt();
        int[] g = new int[gn];
        int i = 0;
        while (reader.hasNext()) {
            g[i++] = reader.nextInt();
            if (i == g.length) break;
        }
        i = 0;
        int sn = reader.nextInt();
        int[] s = new int[sn];
        while (reader.hasNext()) {
            s[i++] = reader.nextInt();
            if (i == s.length) break;
        }
        int[] intersection = getInterSection(g, s);
        Arrays.sort(intersection);
        String result = "";
        for(int j : intersection){
            result += j + ",";
        }
        result = result.trim();
        if(result.length()==0){
            System.out.println("");
        }else{
            System.out.println(result.trim().substring(0,result.length()-1));
        }
    }
    //APPEND END
//    public static void main(String[] args){
//        int g[] ={1,2,2,1};
//        int s[] = {2,2};
//        int[] intersection = getInterSection(g, s);
//        Arrays.sort(intersection);
//        String result = "";
//        for(int j : intersection){
//            result += j + ",";
//
//        }
//        System.out.println(result.trim().substring(0,result.length()-1));
//        //System.out.println(result.substring(0,result.length()-1));
//    }

}
