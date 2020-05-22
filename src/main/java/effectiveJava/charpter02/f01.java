package effectiveJava.charpter02;

import java.util.HashMap;
import java.util.Map;

public class f01 {
    public static Map newInstance(){
        return new HashMap();
    }
    public static void main(String args[]){
        Map<String,String> map = newInstance();
    }
}
