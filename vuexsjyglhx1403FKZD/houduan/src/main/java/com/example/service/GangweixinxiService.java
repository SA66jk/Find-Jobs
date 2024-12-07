package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Gangweixinxi;
import com.example.vo.GangweixinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface GangweixinxiService extends IService<Gangweixinxi> {
    Gangweixinxi add(Gangweixinxi gangweixinxi);
    void delete(Long id);
    void update(Gangweixinxi gangweixinxi);
    Gangweixinxi findById(Integer id);
    GangweixinxiVo findPage(GangweixinxiVo gangweixinxiVo);
	
    void deleteList(List<Gangweixinxi> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
