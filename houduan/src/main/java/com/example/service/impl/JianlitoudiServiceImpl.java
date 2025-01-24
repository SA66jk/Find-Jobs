package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Jianlitoudi;
import com.example.exception.CustomException;
import com.example.service.JianlitoudiService;
import com.example.vo.JianlitoudiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("jianlitoudiService")
public class JianlitoudiServiceImpl extends ServiceImpl<JianlitoudiDao, Jianlitoudi> implements JianlitoudiService {

    @Resource
    private JianlitoudiDao jianlitoudiDao;

    public Jianlitoudi add(Jianlitoudi jianlitoudi) {
		
	   //youquchong1
        jianlitoudi.setAddtime(new Date());
        jianlitoudiDao.insert(jianlitoudi);
        return jianlitoudi;
    }
	
	@Override    public List<Map<String,Object>> jianlitoudi_tj_gangweimingcheng() {    List<Map<String,Object>> returnMap = jianlitoudiDao.jianlitoudi_tj_gangweimingcheng();    return returnMap;    }    
	
    public void delete(Long id) {
        jianlitoudiDao.deleteById(id);
    }
	

    public void update(Jianlitoudi jianlitoudi) {
        //youquchong2
        jianlitoudiDao.updateById(jianlitoudi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return jianlitoudiDao.daochuexcel();
    }

    @Override
    public Jianlitoudi findById(Integer id) {
        return jianlitoudiDao.selectById(id);
    }

    public JianlitoudiVo findPage(JianlitoudiVo jianlitoudiVo) {
        LambdaQueryWrapper<Jianlitoudi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getGangweimingcheng()), Jianlitoudi::getGangweimingcheng,jianlitoudiVo.getGangweimingcheng());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getGongzuoshijian()), Jianlitoudi::getGongzuoshijian,jianlitoudiVo.getGongzuoshijian());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getQiyehao()), Jianlitoudi::getQiyehao,jianlitoudiVo.getQiyehao());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getQiyemingcheng()), Jianlitoudi::getQiyemingcheng,jianlitoudiVo.getQiyemingcheng());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getFuzeren()), Jianlitoudi::getFuzeren,jianlitoudiVo.getFuzeren());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getYonghuming()), Jianlitoudi::getYonghuming,jianlitoudiVo.getYonghuming());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getXingming()), Jianlitoudi::getXingming,jianlitoudiVo.getXingming());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getShouji()), Jianlitoudi::getShouji,jianlitoudiVo.getShouji());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getJianliwenjian()), Jianlitoudi::getJianliwenjian,jianlitoudiVo.getJianliwenjian());        wrapper.like(ObjectUtils.isNotEmpty(jianlitoudiVo.getIssh()), Jianlitoudi::getIssh,jianlitoudiVo.getIssh());        
        Page<Jianlitoudi> page = new Page<>(jianlitoudiVo.getCurrent(),jianlitoudiVo.getCurrentNum());
        jianlitoudiDao.selectPage(page,wrapper);
        List<Jianlitoudi> jianlitoudis = page.getRecords();
        jianlitoudiVo.setList(jianlitoudis);
        jianlitoudiVo.setPages(page.getPages());
        jianlitoudiVo.setTotal(page.getTotal());
        jianlitoudiVo.setCurrent(page.getCurrent());
        jianlitoudiVo.setCurrentNum(page.getSize());
        return jianlitoudiVo;
    }

    @Override
    public void deleteList(List<Jianlitoudi> list) {
        List<Integer> ids =  list.stream().map(Jianlitoudi::getId).collect(Collectors.toList());
        jianlitoudiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
