package caixirank.feature;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SeqDiffBuFeatureTask {
    public String formatString(String has,String add){
        if(StringUtils.isNotEmpty(has)){
            has+=",";
        }
        has+=add;
        return  has;
    }
    public void trans(Map<String, Object> featureMap, FeatureEntry featureEntry, String action){
        Object actionObject = featureMap.get("USER_"+action+"_ITEM_DTYPE_LISTS");
        Map<String, String> feature_map = new HashMap<String, String>();
        if(actionObject!=null){
            String orderStr = (String)actionObject;
            if(StringUtils.isNotEmpty(orderStr)){
                String waimaiList ="";
                String poiList="";
                String skuList="";
                String dealList="";
                String cardList="";
                String noWaimaiPoiList="";
                String orderArray[] = orderStr.split(",");
                for(String str : orderArray){
                    if(str.indexOf("POI_WAIMAI")>-1){
                        waimaiList = formatString(waimaiList,str);
                    }

                    if(str.indexOf("DEAL")>-1){
                        dealList = formatString(dealList, str);
                    }
                    if(str.indexOf("POI")>-1){
                        poiList = formatString(poiList,str);
                        if(str.indexOf("POI_WAIMAI")<0){
                            noWaimaiPoiList = formatString(noWaimaiPoiList,str);
                        }
                    }
                    if(str.indexOf("SPU")>-1||str.indexOf("SKU")>-1){
                        skuList = formatString(skuList,str);
                    }
                    if(str.indexOf("TOPIC")>-1||str.indexOf("COMMENT")>-1||str.indexOf("NOTE")>-1){
                        cardList = formatString(cardList,str);
                    }
                }
                if(StringUtils.isNotEmpty(waimaiList)){
                    feature_map.put(action+"_WAIMAI_ITEM_LIST_NEW",waimaiList);
                }
                if(StringUtils.isNotEmpty(dealList)){
                    feature_map.put(action+"_DEAL_ITEM_LIST_NEW",dealList);
                }
                if(StringUtils.isNotEmpty(poiList)){
                    feature_map.put(action+"_POI_ITEM_LIST_NEW",poiList);
                }
                if(StringUtils.isNotEmpty(noWaimaiPoiList)){
                    feature_map.put(action+"_NOWAIMAIPOI_ITEM_LIST_NEW",noWaimaiPoiList);
                }
                if(StringUtils.isNotEmpty(skuList)){
                    feature_map.put(action+"_SKUSPU_ITEM_LIST_NEW",skuList);
                }
                if(StringUtils.isNotEmpty(cardList)){
                    feature_map.put(action+"_CARD_ITEM_LIST_NEW",cardList);
                }
                Iterator<Map.Entry<String, String>> entries = feature_map.entrySet().iterator();

                while (entries.hasNext()) {
                    Map.Entry<String, String> entry = entries.next();
                    String feature_name = entry.getKey();
                    String feature_value = entry.getValue();

                    if(StringUtils.isNotBlank(feature_value)){
                        featureEntry.categoryFeatueMap.put(feature_name, feature_value);
                        System.out.print("\""+feature_name+"\",");
                    }
                }

            }
        }
    }

    public void translate(Map<String, Object> featureMap, FeatureEntry featureEntry) {
        trans(featureMap,featureEntry,"ORDER");
        trans(featureMap,featureEntry,"VIEW");
        System.out.println(".....");
    }

}
