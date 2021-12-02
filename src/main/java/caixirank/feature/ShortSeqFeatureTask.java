package caixirank.feature;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShortSeqFeatureTask implements ITranslator{
    public ShortSeqFeatureTask(){}
    public void trans(Map<String, Object> featureMap,FeatureEntry featureEntry,String action){
        Object actionObject = featureMap.get("UP_"+action+"_ACTION_MODEL");
        Map<String, String> feature_map = new HashMap<String, String>();

        String timeStampStr =String.valueOf(featureMap.get("CTX_TIMESTAMP"));
        //System.out.println(timeStampStr);
        if(actionObject==null|| StringUtils.isEmpty(timeStampStr))
            return;

        String actionSeq = (String)actionObject;
        long timestamp = Long.valueOf(timeStampStr)/1000; //ms 转成 s

        if(StringUtils.isEmpty(actionSeq)) return;
        String poiList5Min="";
        String poiList10Min="";
        String poiList15Min="";
        JSONArray actionArray = JSON.parseArray(actionSeq);
        for(int i=0;i< actionArray.size();i++){
            JSONObject json = actionArray.getJSONObject(i);
            long tmp = Long.valueOf(json.getString("timestamp"));
            String poiId = json.getString("id");
            String type = json.getString("type");

            if(StringUtils.isEmpty(poiId)||StringUtils.isEmpty(type)) continue;
            String typePoi = type+"-"+poiId;
            long delta = (timestamp - tmp)/60; // s 转成 分钟
            if(delta <= 5){
                poiList5Min = appendPoi(poiList5Min,typePoi);
                poiList10Min = appendPoi(poiList10Min,typePoi);
                poiList15Min = appendPoi(poiList15Min,typePoi);
            }else if(delta<=10){
                poiList10Min = appendPoi(poiList10Min,typePoi);
                poiList15Min = appendPoi(poiList15Min,typePoi);
            }else if(delta<=15){
                poiList15Min = appendPoi(poiList15Min,typePoi);
            }
        }
        if(StringUtils.isNotEmpty(poiList5Min)){
            feature_map.put(action+"_SHORT_ITEM_LIST_5MIN",poiList5Min);
        }
        if(StringUtils.isNotEmpty(poiList10Min)){
            feature_map.put(action+"_SHORT_ITEM_LIST_10MIN",poiList10Min);
        }
        if(StringUtils.isNotEmpty(poiList15Min)){
            feature_map.put(action+"_SHORT_ITEM_LIST_15MIN",poiList15Min);
        }
        Iterator<Map.Entry<String, String>> entries = feature_map.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            String feature_name = entry.getKey();
            String feature_value = entry.getValue();
            System.out.println(feature_name);
            if(StringUtils.isNotBlank(feature_value)){
                featureEntry.categoryFeatueMap.put(feature_name, feature_value);
            }
        }

    }
    public String appendPoi(String str,String add){
        if(StringUtils.isEmpty(str)){
            str+=add;
        }else{
            str+=","+add;
        }
        return str;
    }
    @Override
    public void translate(Map<String, Object> featureMap, FeatureEntry featureEntry) {
        trans(featureMap,featureEntry,"VIEW");
        trans(featureMap,featureEntry,"ORDER");
    }
}
