package com.cimon.rescy.data;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public abstract class Jsonable implements Serializable {

    @Override
    public String toString(){ return toJSON();}

    public String toJSON(){
        return JSON.toJSONString(this);
    }
}
