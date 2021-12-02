import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestString {
    public static void doString(String a){
        a+=" 123";
    }
    public static String doStringV2(String a){
        a+="123";
        return a;
    }
    public static void main(String args[]){
        String a ="abc";
        System.out.println(a);
        doString(a);
        System.out.println(a);
        System.out.println(doStringV2(a));
        System.out.println(System.currentTimeMillis());
        System.out.println(a.indexOf("abdc"));
        GregorianCalendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
        System.out.println(Calendar.MINUTE);
        long t=4567336849508722817l;
        System.out.println(t>>52);
        String str1="e32b745d60d301b22ae5ed682d7c10a7-SKU_YOUXUAN-100098399379688-Ranker_homepage_Hp21H1NewBase_20210406_newLayer-59188966-1631669529000-0\t0 4611686018427387907:0.16483 4611686018427387915:0.25474 4611686018427387932:0.03996 4611686018427387939:0.40059 4611686018427387941:9.9E-4 4611686018427387944:0.01398 4611686018427387951:9.9E-4 4611686018427387959:1.0 4611686018427387969:0.4935 4611686018427387970:1.0 4611686018427387977:9.9E-4 4611686018427387979:0.00199";
        String str2=str1.split("\t")[1];
        String str3[]= str2.split(" ");
        for(String tmp1 : str3){
            System.out.println(Long.parseLong(tmp1.split(":")[0])>>52);
        }
    }
}
