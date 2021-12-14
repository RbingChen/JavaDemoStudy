package com.ylq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class LoadStatus{
   private  String loadTime;
   private  String nodeStatus;

}

public class JSONQuestion20211214 {
    public static void main(String args[]){

        JSONArray jsonArray = produceJsonArray();

        List<LoadStatus> loadStatusList1 = method1(jsonArray);
        List<LoadStatus> loadStatusList2 = method2(jsonArray);

    }

    public static JSONArray  produceJsonArray(){
        LoadStatus loadStatus1 = new LoadStatus("2021-12-14 14:00","sucess");
        LoadStatus loadStatus2 = new LoadStatus("2021-12-13 11:11","sucess");

        JSONArray jsonArray = new JSONArray();

        jsonArray.add(JSON.parseObject(JSONObject.toJSONString(loadStatus1)));
        jsonArray.add(JSON.parseObject(JSONObject.toJSONString(loadStatus1)));

        return jsonArray;
    }
    public static List<LoadStatus> method1(JSONArray jsonArray){
        // 使用该方法，类必须有无参数构造器，如上：使用NoArgsConstructor注解
        List<LoadStatus> loadStatusList = new ArrayList<>();
        for(Object object : jsonArray){
            JSONObject jsonObject = (JSONObject)object;
            LoadStatus loadStatus = JSON.toJavaObject(jsonObject,LoadStatus.class);
            loadStatusList.add(loadStatus);
        }
        return loadStatusList;
    }
    public static List<LoadStatus> method2(JSONArray jsonArray){
        List<LoadStatus> loadStatusList = new ArrayList<>();
        for(Object object : jsonArray){
            JSONObject jsonObject = (JSONObject)object;
            String jsonString = JSON.toJSONString(jsonObject);
            LoadStatus loadStatus = JSONObject.parseObject(jsonString,LoadStatus.class);
            loadStatusList.add(loadStatus);

        }
        return loadStatusList;
    }
}
