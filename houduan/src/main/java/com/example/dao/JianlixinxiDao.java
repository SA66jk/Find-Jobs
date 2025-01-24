package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Jianlixinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface JianlixinxiDao extends BaseMapper<Jianlixinxi> {

@Select("select * from jianlixinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
