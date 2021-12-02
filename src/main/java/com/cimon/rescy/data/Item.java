package com.cimon.rescy.data;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class Item extends Jsonable implements HasId {

    @JSONField
    private String id;

    @JSONField
    private String name;

}
