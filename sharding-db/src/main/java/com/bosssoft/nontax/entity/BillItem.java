package com.bosssoft.nontax.entity;

import lombok.Data;

@Data
public class BillItem {

    //主键
    private Long id;

    //主表主键
    private Long fpid;

    //项目编码
    private String itemcode;

    //日期
    private String date;

    //单位编码
    private String agencode;
}
