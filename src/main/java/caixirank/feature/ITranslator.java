package caixirank.feature;

import java.util.Map;

public interface ITranslator {
    void  translate(Map<String,Object> featureMap, FeatureEntry featureEntry);

}
