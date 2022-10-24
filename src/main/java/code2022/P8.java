package code2022;
import java.util.*;

public class P8 {
    public static boolean canVisitAllGames(List<List<Integer>> games){
        int size = games.size();
        if(size==0) return true;
        for(int i=0;i< size;i++){
            List<Integer> lt = games.get(i);
            if(i==size-1) return true;
            if(lt.size()==0) return false;
            boolean canGo = false;
            for(int t : lt){
                if(t==i+1){
                    canGo = true;
                    break;
                }
            }
            if(!canGo) return false;
        }
        return true;
    }
//    public static void test1(){
//        List<Integer> lt1 = new ArrayList<>();
//        lt1.add(1);
//
//        List<Integer> lt2 = new ArrayList<>();
//        lt2.add(2);
//
//        List<Integer> lt3 = new ArrayList<>();
//        lt3.add(3);
//
//        List<Integer> lt4 = new ArrayList<>();
//
//        List<List<Integer>> test = new ArrayList();
//        test.add(lt1);
//        test.add(lt2);
//        test.add(lt3);
//        test.add(lt4);
//        System.out.println(canVisitAllGames(test));
//    }
//    public static void test2(){
//        List<Integer> lt1 = new ArrayList<>();
//        lt1.add(1);
//
//        List<Integer> lt2 = new ArrayList<>();
//        lt2.add(2);lt2.add(3);
//
//        List<Integer> lt3 = new ArrayList<>();
//        lt3.add(3);
//
//        List<Integer> lt4 = new ArrayList<>();
//        lt4.add(3);
//        List<Integer> lt5 = new ArrayList<>();
//
//        List<List<Integer>> test = new ArrayList();
//        test.add(lt1);
//        test.add(lt2);
//        test.add(lt3);
//        test.add(lt4);
//        test.add(lt5);
//        System.out.println(canVisitAllGames(test));
//    }
//    public static void main(String args[]){
//        test1();
//        test2();
//    }
}
