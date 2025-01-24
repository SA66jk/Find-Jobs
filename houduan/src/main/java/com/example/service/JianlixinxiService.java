package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Jianlixinxi;
import com.example.vo.JianlixinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface JianlixinxiService extends IService<Jianlixinxi> {
    Jianlixinxi add(Jianlixinxi jianlixinxi);
    void delete(Long id);
    void update(Jianlixinxi jianlixinxi);
    Jianlixinxi findById(Integer id);
    JianlixinxiVo findPage(JianlixinxiVo jianlixinxiVo);
	
    void deleteList(List<Jianlixinxi> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
