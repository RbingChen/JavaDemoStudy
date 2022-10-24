package code2022;
import java.util.*;
public class P9 {
    public static String getActualNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> created = new HashSet<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (created.contains(name)) {
                int id = map.getOrDefault(name, 1);
                while (created.contains(name + "(" + id + ")")) {
                    id++;
                }
                map.put(name, id + 1);
                name += "(" + id + ")";
            } else {
                map.put(name, 1);
            }
            ans[i] = name;
            created.add(name);
        }

        String t ="";
        for(int i = 0;i<ans.length;i++){
            if(i==0)
                t = t+ ans[i];
            else
                t = t+" "+ans[i];;
        }
        return t;
    }
    public  static void main(String args[]){
        String arr[] = {"pes","fifa","gta","pes(2019)"};
        System.out.println(getActualNames(arr));
    }
}
