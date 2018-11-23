package com.example.demo.dao;

import com.example.demo.model.ContentModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentMapper {

    List<ContentModel> selectAllModel(@Param("start") Integer start, @Param("size") Integer size);

    Integer selectCount();
}