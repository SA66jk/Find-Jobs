package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Xiaoxitongzhi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface XiaoxitongzhiDao extends BaseMapper<Xiaoxitongzhi> {

@Select("select * from xiaoxitongzhi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
