package com.bosssoft.nontax.entity;

import lombok.Data;

import java.util.List;

@Data
public class Bill {

    //主键
    private Long id;

    //单位识别码
    private String agencode;

    //日期
    private String date;

    //票号
    private String no;

    //项目明细
    private List<BillItem> billItems;
}
