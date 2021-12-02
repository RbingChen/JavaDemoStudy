package caixirank.feature;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestShortSeqFeatureTask {
    @Test
    public void test(){
        Map<String, Object> featureMap = new HashMap<>();
        featureMap.put("UP_VIEW_ACTION_MODEL","[{\"mentalCateId\":1,\"classId\":226,\"cateId\":10,\"brandId\":0,\"typeId\":2099,\"id\":6753833,\"type\":\"POI_WAIMAI\",\"timestamp\":1609923727},{\"mentalCateId\":1,\"classId\":226,\"cateId\":10,\"brandId\":0,\"typeId\":11,\"id\":815648388,\"type\":\"POI_WAIMAI\",\"timestamp\":1609923689},{\"mentalCateId\":1,\"classId\":226,\"cateId\":24,\"brandId\":0,\"typeId\":24,\"id\":163436073,\"type\":\"POI_WAIMAI\",\"timestamp\":1609923637},{\"mentalCateId\":1,\"classId\":226,\"cateId\":10,\"brandId\":0,\"typeId\":251,\"id\":1720114534,\"type\":\"POI_WAIMAI\",\"timestamp\":1609923626}]");
        featureMap.put("UP_ORDER_ACTION_MODEL","[{\"mentalCateId\":1,\"classId\":226,\"cateId\":10,\"brandId\":0,\"typeId\":2099,\"id\":6753833,\"type\":\"POI_WAIMAI\",\"timestamp\":1609923727},{\"mentalCateId\":1,\"classId\":226,\"cateId\":10,\"brandId\":0,\"typeId\":11,\"id\":815648388,\"type\":\"POI_WAIMAI\",\"timestamp\":1609923689},{\"mentalCateId\":1,\"classId\":226,\"cateId\":24,\"brandId\":0,\"typeId\":24,\"id\":163436073,\"type\":\"POI_WAIMAI\",\"timestamp\":1609923637},{\"mentalCateId\":1,\"classId\":226,\"cateId\":10,\"brandId\":0,\"typeId\":251,\"id\":1720114534,\"type\":\"POI_WAIMAI\",\"timestamp\":1609923626}]");
        featureMap.put("CTX_TIMESTAMP",1609923688226L);
        ShortSeqFeatureTask seq = new ShortSeqFeatureTask();
        FeatureEntry feat = new FeatureEntry();
        seq.translate(featureMap,feat);
        System.out.println("ddddddd");
    }
}
