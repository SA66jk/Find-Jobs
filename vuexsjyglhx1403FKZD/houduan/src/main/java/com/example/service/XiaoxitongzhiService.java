package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Xiaoxitongzhi;
import com.example.vo.XiaoxitongzhiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface XiaoxitongzhiService extends IService<Xiaoxitongzhi> {
    Xiaoxitongzhi add(Xiaoxitongzhi xiaoxitongzhi);
    void delete(Long id);
    void update(Xiaoxitongzhi xiaoxitongzhi);
    Xiaoxitongzhi findById(Integer id);
    XiaoxitongzhiVo findPage(XiaoxitongzhiVo xiaoxitongzhiVo);
	
    void deleteList(List<Xiaoxitongzhi> list);
	
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
