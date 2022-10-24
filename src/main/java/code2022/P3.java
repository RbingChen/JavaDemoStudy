package code2022;
import java.util.Scanner;
import java.util.*;
public class P3 {
    public static int solution(int[] nums){
        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
//        int max1 = 0;
//        int max2 = 0;
//        for (int i = 0; i < nums.length; i++){
//            int num = nums[i];
//            if (num > max2) {
//                if (num > max1) {
//                    max1 = max2;
//                    max2 = num;
//                }
//                else {
//                    max2 = num;
//                }
//            }
//        }
//        return (max1-1)*(max2-
    }

    public static void main(String[] args){
//        Scanner reader = new Scanner(System.in);
//        int length = reader.nextInt();
//        int[] nums = new int[length];
//        for (int i = 0; i < length; i++) {
//            nums[i] = reader.nextInt();
//        }
        int nums[]= {1,4,4,1};

        System.out.println(solution(nums));

    }
}