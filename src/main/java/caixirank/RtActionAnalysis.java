package caixirank;

import com.alibaba.fastjson.JSONArray;
import tool.ReadResourcesFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;

public class RtActionAnalysis {
    public static String getSample(String filename) throws Exception{
        ReadResourcesFile t = new ReadResourcesFile();
        InputStream is = t.getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder buffer = new StringBuilder();
        String tmp ="";
        while(tmp!=null){
            buffer.append(tmp.trim());
            tmp=br.readLine();
        }

        br.close();
        return buffer.toString();
    }
    public static void main(String args[]) throws Exception{
        String sample1 = getSample("rt_action_sample.json");
        JSONObject features = JSON.parseObject(sample1);

        JSONArray view_action = JSON.parseArray(features.getString("UP_VIEW_ACTION_MODEL"));
        long timestamp = Long.valueOf(features.getString("TIMESTAMP"))/1000;
        long min = Long.MAX_VALUE; //1609923727
        //timestamp 1609923688 226 //"CTX_TIMESTAMP":1609923688 226,
        for(int i=0;i< view_action.size();i++){
            long tmp = Long.valueOf(view_action.getJSONObject(i).getString("timestamp"));
            long delta = timestamp - tmp;
            System.out.println(delta);
            if(delta<min)
                min =delta;
        }
        System.out.println("result"+min);
    }
}
