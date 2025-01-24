package com.example.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Qiyexinxi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface QiyexinxiDao extends BaseMapper<Qiyexinxi> {

@Select("select * from qiyexinxi")
List<Map<String, Object>> daochuexcel();

//youxxianxci

//tonxgji1

}
