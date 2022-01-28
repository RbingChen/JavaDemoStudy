package caixirank;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jpcase {
    public static String getDate(String time){

        long time1 = Long.valueOf(time);
        String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time1 * 1000));
        return result;
    }
    public static long getTimeDelta(String arr[]){
        if(arr.length==1) return 0;
        Arrays.sort(arr);
        return Math.abs(Long.valueOf(arr[0].trim()).longValue() - Long.valueOf(arr[arr.length-1].trim()).longValue());
    }
    public static void main(String args[]) throws IOException {
        File file = new File("/Users/bing/Desktop/IDEA/JavaDemoStudy/src/main/resources/rt_exp.json");
        String content= FileUtils.readFileToString(file,"UTF-8");
        JSONObject jsonObject= JSON.parseObject(content);
        JSONObject json1 = jsonObject.getJSONObject("value").getJSONObject("{userid=378915651}").getJSONObject("userExposure_realtime");

        JSONObject json2 = (JSONObject)json1.getJSONArray("userActionMap").get(0);
        JSONArray jsonArray = json2.getJSONArray("userActionList");
        Map<String,String> map = new HashMap();
        Map<String,String> mapTs = new HashMap();

        for(int i =0 ;i< jsonArray.size(); i++){
            JSONObject tmpJson = (JSONObject)jsonArray.get(i);
            int type = tmpJson.getInteger("itemType");
            if(type!=15){
                continue;
            }
            //System.out.println(type);
            String itemId = tmpJson.getString("itemId");
            String timeStamp = tmpJson.getString("timestamp");
            //System.out.println(timeStamp);
            if(map.containsKey(itemId)){
               map.put(itemId,map.get(itemId)+" , "+getDate(timeStamp));
                mapTs.put(itemId,mapTs.get(itemId)+" , "+ timeStamp);
            }else{
                map.put(itemId,getDate(timeStamp));
                mapTs.put(itemId,timeStamp);
            }
        }

//        for(Map.Entry<String,String> entry : map.entrySet()){
//            String value = entry.getValue();
//            if(value.split(",").length>1){
//                System.out.println(entry.getKey()+"  "+entry.getValue());
//            }
//        }

        for(Map.Entry<String,String> entry : mapTs.entrySet()){
            String value = entry.getValue();
            long timeDelta = getTimeDelta(value.split(","));
            if(timeDelta > 10 ){
                System.out.println("时间差: "+timeDelta +"秒， "+entry.getKey()+" "+map.get(entry.getKey()));
            }
        }

    }

}
