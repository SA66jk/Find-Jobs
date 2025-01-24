package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Jianlitoudi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface JianlitoudiDao extends BaseMapper<Jianlitoudi> {

@Select("select * from jianlitoudi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

@Select("SELECT distinct(gangweimingcheng) as aa, COUNT(id) as bb FROM jianlitoudi GROUP BY gangweimingcheng")
List<Map<String, Object>> jianlitoudi_tj_gangweimingcheng();

//tonxgji1

}
