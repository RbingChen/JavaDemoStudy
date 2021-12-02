package caixirank.feature;

import caixirank.feature.FeatureEntry;
import caixirank.feature.SeqDiffBuFeatureTask;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSeqDiffBuFeatureTask {
    @Test
    public void test(){
        Map<String, Object> featureMap = new HashMap<>();
        featureMap.put("USER_ORDER_ITEM_DTYPE_LISTS","SKU_YOUXUAN-1255402015,TOPIC_12121,COMMENT-524762914,POI_GROUP-119038173,POI_WAIMAI-1305817785,DEAL_123113");
        featureMap.put("USER_VIEW_ITEM_DTYPE_LISTS","SKU_YOUXUAN-1255402015,TOPIC_12121,COMMENT-524762914,POI_GROUP-119038173,POI_WAIMAI-1305817785,DEAL_123113");
        SeqDiffBuFeatureTask seq = new SeqDiffBuFeatureTask();
        seq.translate(featureMap,new FeatureEntry());
        System.out.println("ddddddd");
    }
}
