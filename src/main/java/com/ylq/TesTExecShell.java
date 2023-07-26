package com.ylq;

import org.springframework.core.io.DefaultResourceLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesTExecShell {
    public static void main(String[] args) throws IOException {
        Process process = null;
        String path = "testbash.sh";
        File file1 = new DefaultResourceLoader().getResource(path).getFile();
        System.out.println(file1.getAbsoluteFile());
        //String command = "cat " + file1.getAbsoluteFile() +" > /Users/bing/Desktop/IDEA/JavaDemoStudy/hello.test";
        String command = "bash "+file1.getAbsoluteFile();
        System.out.println("command : "+command);
        try {
            process = Runtime.getRuntime().exec(command);
            int status = process.waitFor();  //
            if (status != 0){  //
               System.out.println("restart go server error");
                return;
            }
            System.out.println("restart go server success");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
