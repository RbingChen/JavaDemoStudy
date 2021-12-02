package ylq.leetcode;

import java.util.Scanner;

public class TestEnvYc {
    public static int support(int arr[]){
        return 0;
    }
    public static String println(int arr[]){
        StringBuilder st = new StringBuilder();
        for(int a :arr)
            st.append(a+" ");
        return st.toString().trim();
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int g[] = new int[5];
        int i=0;
        while(scanner.hasNext()){
            g[i++] = scanner.nextInt();
            if(i == g.length) break;
        }

        int result = support(g);
        System.out.println(println(g));
    }
}
