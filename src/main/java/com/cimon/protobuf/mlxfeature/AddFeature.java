package com.cimon.protobuf.mlxfeature;
import com.cimon.protobuf.mlxfeature.Feature.ItemFeature;
import com.cimon.protobuf.mlxfeature.Feature.UserFeature;
import com.cimon.protobuf.mlxfeature.Feature.*;
import com.cimon.protobuf.mlxfeature.Feature.RawFeature;

/**
 * @Author: Renbingchen123@126.com
 * @Date: 2020-05-22 21:32
 * @explain:测试 mlx feature 使用
 * */
public class AddFeature {
    public static KVPair.Builder getKvPair(String k ,String v){
        KVPair.Builder kvPairBuilder = Feature.KVPair.newBuilder();
        kvPairBuilder.setKey(k);
        kvPairBuilder.setValue(v);
        return kvPairBuilder;
    }
    public static void main(String args[]){
        RawFeature.Builder rawFeatureBuilder = RawFeature.newBuilder();
        ItemFeature.Builder itemFeatureBuilder = ItemFeature.newBuilder();
        UserFeature.Builder userFeatureBuilder = UserFeature.newBuilder();

        userFeatureBuilder.addPairs(getKvPair("userid","1232323"));
        userFeatureBuilder.addPairs(getKvPair("gender","female"));
        /**
         * List 
         * */
        itemFeatureBuilder.addPairs(getKvPair("itemid","98394"));
        itemFeatureBuilder.addPairs(getKvPair("price","12.2"));
        rawFeatureBuilder.addItemFeature(itemFeatureBuilder);
        rawFeatureBuilder.setUserFeature(userFeatureBuilder);
        RawFeature rawFeature = rawFeatureBuilder.build();
        System.out.println(rawFeature);
    }
}
