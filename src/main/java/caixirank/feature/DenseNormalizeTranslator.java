package caixirank.feature;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class DenseNormalizeTranslator {
    public static List<String> getFeatureListByFeatureConfg() throws Exception {
        String str ="{\n" +
                "    \"SparseFeature\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"DenseEmbedding\": [\n" +
                "\n" +
                "    ],\n" +
                "    \"DenseFeature\": [\n" +
                "        {\n" +
                "            \"field\": 0,\n" +
                "            \"Features\": [\n" +
                "                \"EXP_ITEM_30DAYS_CXR_1\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject config = JSON.parseObject(str);
        JSONArray denseFeatureJson = config.getJSONArray("DenseFeature");
        if (denseFeatureJson.size() > 1) {
            throw new Exception("配置错误，DenseFeature 只能有一个");
        } else {
            List<String> features = new ArrayList();
            JSONObject denseInfo = denseFeatureJson.getJSONObject(0);
            JSONArray jsonFeatures = denseInfo.getJSONArray("Features");

            for(int idx = 0; idx < jsonFeatures.size(); ++idx) {
                String featureName = jsonFeatures.getString(idx).trim();
                String[] strArr = StringUtils.split(featureName, ',');
                if (strArr.length > 1) {
                    throw new Exception("配置错误，仅支持单特征,featureName=" + featureName);
                }

                if (!StringUtils.isNotBlank(featureName)) {
                    throw new Exception("featureName is empty,idx=" + idx);
                }

                features.add(featureName);
            }

            return features;
        }
    }
    public static void main(String args[]) throws Exception {
        getFeatureListByFeatureConfg();
    }
}
