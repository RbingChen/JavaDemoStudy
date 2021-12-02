package caixirank;

import tool.ReadResourcesFile;

import java.io.*;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
public class FeatureNameDiff {
    public static String getSample(String filename) throws Exception{
        ReadResourcesFile t = new ReadResourcesFile();
        InputStream is = t.getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder buffer = new StringBuilder();
        String tmp ="";
        while(tmp!=null){
            buffer.append(tmp.trim());
            tmp=br.readLine();
        }

        br.close();
        return buffer.toString();
    }
    public static void main(String args[]) throws Exception{

        String sample1 = getSample("sample1.json"); //外卖
        String sample2 = getSample("sample2.json"); //优选
        JSONObject json1 = JSON.parseObject(sample1);
        JSONObject json2  = JSON.parseObject(sample2);
        Set<String> key1 = json1.keySet();
        Set<String> key2 = json2.keySet();
        BufferedWriter out = new BufferedWriter(new FileWriter("sample1_result.txt"));
        BufferedWriter out1 = new BufferedWriter(new FileWriter("sample1_youxuan_kv.txt"));
        int count = 0 ;
        for(String str : key1){
            if(!key2.contains(str.toLowerCase())&&!key2.contains(str)){
                //System.out.println(str);
                out.write(str+"\n");
                count+=1;
            }
            if(json1.getString(str).indexOf("SKU_YOUXUAN")>=0){
                out1.write(str+"\t"+json1.getString(str)+"\n");
            }
        }
        System.out.println(count);
        out.close();out1.close();

        BufferedWriter out2 = new BufferedWriter(new FileWriter("sample2_result.txt"));
        BufferedWriter out3 = new BufferedWriter(new FileWriter("sample2_result_kv.txt"));
        BufferedWriter out4 = new BufferedWriter(new FileWriter("sample2_youxuan_kv.txt"));
        count = 0 ;
        for(String str : key2){
            if(!key1.contains(str.toLowerCase())&&!key1.contains(str)){
                //System.out.println(str);
                out2.write(str+"\n");
                out3.write(str+","+json2.getString(str)+"\n");
                count+=1;
            }
            if(json2.getString(str).indexOf("SKU_YOUXUAN")>=0){
                out4.write(str+"\t"+json2.getString(str)+"\n");
            }
        }
        System.out.println(count);
        out2.close();out3.close();out4.close();

    }
}
