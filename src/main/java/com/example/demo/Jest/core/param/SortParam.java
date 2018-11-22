package com.example.demo.Jest.core.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 排序相关
 *
 **/
@Data
public class SortParam implements Serializable {
    private static final long serialVersionUID = -7769118859444567883L;

    public static final String ASC = "asc";
    public static final String DESC = "desc";

    //排序字段
    private String sortField = "id";
    //排序类型
    private String sortOrder = DESC;
}
