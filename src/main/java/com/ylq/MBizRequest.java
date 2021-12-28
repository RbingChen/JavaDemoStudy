package com.ylq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MBizRequest extends  BizRequest{
    private int c;
    public MBizRequest(int a,int b ,int c){
        super(a,b);
        this.c = c;
    }
}
