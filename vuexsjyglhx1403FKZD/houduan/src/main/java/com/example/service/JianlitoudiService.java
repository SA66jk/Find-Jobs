package com.example.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Jianlitoudi;
import com.example.vo.JianlitoudiVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface JianlitoudiService extends IService<Jianlitoudi> {
    Jianlitoudi add(Jianlitoudi jianlitoudi);
    void delete(Long id);
    void update(Jianlitoudi jianlitoudi);
    Jianlitoudi findById(Integer id);
    JianlitoudiVo findPage(JianlitoudiVo jianlitoudiVo);
	
    void deleteList(List<Jianlitoudi> list);
	List<Map<String,Object>> jianlitoudi_tj_gangweimingcheng();    
	
	List<Map<String, Object>> daochuexcel();
	//youxxianxci
}
