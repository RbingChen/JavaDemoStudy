package caixirank.feature;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FeatureEntry {
    public Map<String, Float> floatFeatureMap =new ConcurrentHashMap<>(1024);
    public Map<String, List<Float>> vectorFeatureMap =new ConcurrentHashMap<>(512);
    public Map<String, String> categoryFeatueMap =new ConcurrentHashMap<>(512);
    public Map<String, List<String>> multiCategoryFeatureMap =new ConcurrentHashMap<>(512);

}
