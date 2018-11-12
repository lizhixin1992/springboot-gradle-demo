package com.example.demo.Jest.blog.param;


import java.io.Serializable;

import com.example.demo.Jest.core.param.SortParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @desc 搜索公共参数
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchParam extends SortParam implements Serializable {
    private static final long serialVersionUID = -2009509747353786691L;
    //最小ID
    private long minId = 0L;
    //最大ID
    private long maxId = 0L;
    //条数
    private int fetchSize = 10;
    //标签
    private String[] tags;
    //分类
    private String categroy;
    //关键字(title和content)
    private String keyWord;

}
