package com.cimon.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadResourcesFile {
    public static String readF() throws IOException  {
        ReadResourcesFile t = new ReadResourcesFile();
        InputStream is = t.getClass().getClassLoader().getResourceAsStream("test.json");
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
    public static void main(String args[]) throws IOException {
        System.out.println(readF());
    }
}
