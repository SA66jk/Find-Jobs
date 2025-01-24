package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Qiyexinxi;
import com.example.vo.QiyexinxiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface QiyexinxiService extends IService<Qiyexinxi> {
    Qiyexinxi add(Qiyexinxi qiyexinxi);
    void delete(Long id);
    void update(Qiyexinxi qiyexinxi);
    Qiyexinxi findById(Integer id);
    QiyexinxiVo findPage(QiyexinxiVo qiyexinxiVo);
	Qiyexinxi login(Qiyexinxi qiyexinxi);
    void deleteList(List<Qiyexinxi> list);
	
	void findqiyexinxiqiyehao(Qiyexinxi qiyexinxi);
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
