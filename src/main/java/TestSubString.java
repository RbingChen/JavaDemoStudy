import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class  TestSubString{
    public static void main(String args[]){
         String tt="asdasd_asdasd_sdsd";
         System.out.println(tt.indexOf("_"));
         System.out.println(tt.substring(tt.indexOf("_")+1));
         String title = "name";
         String oldprice = "12";
         String currentPrice = "10";
         String skuContent = "{\"title\":\""+ title+"\","+
                "\"oldPrice\":\""+oldprice+"\","+
                "\"currentPrice\":\""+currentPrice+"\"}";
         String t1 = "imeituan://www.meituan.com/takeout/foods?poi_id=969448329234679&spu_id=0";
         System.out.println(t1.startsWith("imeituan://www.meituan.com/takeout/foods"));

         String t2="\"“我是中国人\"””“";

         t2= t2.replaceAll("\"","").replaceAll("“","").replaceAll("”","");
         System.out.println(t2);
         String wmurl="https://i.waimai.meituan.com/c/foryou/index.html?wm_ctype=";
         String ct="mtiphone";
         String url = "imeituan://www.meituan.com/web?url=" + wmurl+ct+"&g_source=58";
         System.out.println(url);

         String uss ="{\"mt_all\":{\"cnt\":283,\"its\":1401543688,\"ts\":1578653973}}";
         String usst= String.valueOf(JSON.parseObject(uss).getString("mt_all"));
         System.out.println(usst);
         System.out.println(String.valueOf(JSON.parseObject(usst).getString("its")));

        String json1 = "{\"wxrv2f\":\"40937223:0.493,165063214:0.1701,181530412:0.0948,162047780:0.033,175334048:0.0242,190886770:0.0208,6513229:0.0179,159737413:0.0168,2578172:0.0153,159992475:0.0148,165885589:0.0139,5694461:0.0128,170563776:0.0097,164645956:0.0092,165543686:0.0086,189847802:0.0085,84403949:0.008,157791633:0.0078,188666458:0.0077,1287095133:0.0074\"}";
        JSONObject jsonO1 = JSON.parseObject(json1);
        System.out.println(jsonO1.getString("wxrv2f"));
        String jsonR1 = jsonO1.getString("wxrv2f");
        if(StringUtils.isNotEmpty(jsonR1)){
             String arr[] = jsonR1.split(",");
             System.out.println(arr[0].split(":")[0]);
        }
        }
}