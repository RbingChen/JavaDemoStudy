package protobuf.mlxfeature;
import protobuf.mlxfeature.Feature.ItemFeature;
import protobuf.mlxfeature.Feature.UserFeature;
import protobuf.mlxfeature.Feature.RequestFeature;
import protobuf.mlxfeature.Feature.*;
import protobuf.mlxfeature.Feature.RawFeature;
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

        itemFeatureBuilder.addPairs(getKvPair("itemid","98394"));
        itemFeatureBuilder.addPairs(getKvPair("price","12.2"));
        rawFeatureBuilder.addItemFeature(itemFeatureBuilder);
        rawFeatureBuilder.setUserFeature(userFeatureBuilder);
        RawFeature rawFeature = rawFeatureBuilder.build();
        System.out.println(rawFeature);
    }
}
