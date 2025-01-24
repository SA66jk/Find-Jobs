package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Gangweixinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface GangweixinxiDao extends BaseMapper<Gangweixinxi> {

@Select("select * from gangweixinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
