package code2023;

import java.util.Arrays;
import java.util.Scanner;

// 角色
public class P4 {
    public static int numberOfWeakCharacters(int[][] roles){
        Arrays.sort(roles, (a,b)->{return a[0] == b[0] ? b[1] - a[1] : b[0] - a[0];});
        int ans = 0;
        for(int i = 0, maxDefense = 0, n = roles.length; i < n;){
            int j = i, cur = maxDefense;
            maxDefense = Math.max(maxDefense, roles[i][1]);
            for(; j < n && roles[j][0] == roles[i][0]; j++)
                if(roles[j][1] < cur)
                    ans++;
            i = j;
        }
        return ans;
        
    }
    //TEMPLATE END

    //APPEND BEGIN
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        //总元素个数 = 二维数组长度*2
        int rolesNums = reader.nextInt();
        //二维数组长度
        int rolesLength = rolesNums/2;
        //ROLELENGTH
        int roleLength = 2;
        int[] role;
        int i = 0;
        //ROLES
        int[][] roles = new int[rolesLength][roleLength];
        for (int j = 0; j < rolesLength; j++) {
            role = new int[roleLength];
            while(reader.hasNext()) {
                role[i++] = reader.nextInt();
                if(i == roleLength) {
                    break;
                }
            }
            i = 0;
            roles[j] = role;
        }

        System.out.println(numberOfWeakCharacters(roles));
    }
//    public static void main(String[] args){
//        int roles[][] ={{2,3},{2,3}};
//
//        System.out.println(numberOfWeakCharacters(roles));
//        //System.out.println(result.substring(0,result.length()-1));
//    }

}
