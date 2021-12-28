package com.ylq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BizRequest {
    private int a;
    private int b;
    private BizRequest(){

    }
    public BizRequest(int a,int b){
        this.a = a;
        this.b = b;
    }
    public int getC(){
        return 0;
    }
}
