package caixirank.debugredofeature;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class TestNNMultiFeatureParse {
    private static void initFeatureBin() throws Exception {
        //String line = " 0 1.0 -1.0E60 1000.0 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60 1.0E60";
        String line = "0";
        int index = 0;
        boolean firstLine = true;
       // while ( line  != null)
         {
            if (firstLine) {
                firstLine = false;
                //continue;
            }
            String[] token = StringUtils.split(line, ' ');

            if (!StringUtils.isNumeric(token[0].trim())) {
                System.out.println(token[0]+" "+ token[0].length());
                throw new Exception("1 feature.split parse error : " + line);
            }
            Integer count = Integer.parseInt(token[0].trim());
            if (count + 1 != token.length) {
                System.out.println(token.length);
                throw new Exception("2 feature.split parse error : " + line);
            }
            List<Float> splitList = new ArrayList<Float>();
            for (int i = 1; i < token.length; ++i) {
                if (!NumberUtils.isNumber(token[i].trim())) {
                    throw new Exception("3 feature.split parse error : " + line);
                }
                splitList.add(Float.parseFloat(token[i].trim()));
            }
            splitList.add(Float.MAX_VALUE);
            //splits.put(index, splitList);
            index++;
        }
    }
    public static void main(String args[]) throws Exception{
        initFeatureBin();
    }
}
