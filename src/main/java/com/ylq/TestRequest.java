package com.ylq;
import java.util.List;
public class TestRequest {

    public static void printlnC(BizRequest bizRequest){
        System.out.println(bizRequest.getA());
        System.out.println(bizRequest.getC());
    }
//    public static <T> int printlnB(< ? extends > t ){
//       t.getA();
//    }
    public static void main(String args[]){
        YBizRequest yBizRequest = new YBizRequest(1,2,3);
        MBizRequest mBizRequest = new MBizRequest(4,5,6);
        printlnC(yBizRequest);

    }
}
