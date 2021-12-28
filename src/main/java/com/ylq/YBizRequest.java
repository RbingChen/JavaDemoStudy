package com.ylq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class YBizRequest extends  BizRequest{
    private int c;

    public YBizRequest(int a,int b ,int c){
        super(a,b);
        this.c = c;
    }
}
