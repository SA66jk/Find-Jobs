package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Xiaoxitongzhi;
import com.example.exception.CustomException;
import com.example.service.XiaoxitongzhiService;
import com.example.vo.XiaoxitongzhiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("xiaoxitongzhiService")
public class XiaoxitongzhiServiceImpl extends ServiceImpl<XiaoxitongzhiDao, Xiaoxitongzhi> implements XiaoxitongzhiService {

    @Resource
    private XiaoxitongzhiDao xiaoxitongzhiDao;

    public Xiaoxitongzhi add(Xiaoxitongzhi xiaoxitongzhi) {
		
	   //youquchong1
        xiaoxitongzhi.setAddtime(new Date());
        xiaoxitongzhiDao.insert(xiaoxitongzhi);
        return xiaoxitongzhi;
    }
	
	
	
    public void delete(Long id) {
        xiaoxitongzhiDao.deleteById(id);
    }
	

    public void update(Xiaoxitongzhi xiaoxitongzhi) {
        //youquchong2
        xiaoxitongzhiDao.updateById(xiaoxitongzhi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return xiaoxitongzhiDao.daochuexcel();
    }

    @Override
    public Xiaoxitongzhi findById(Integer id) {
        return xiaoxitongzhiDao.selectById(id);
    }

    public XiaoxitongzhiVo findPage(XiaoxitongzhiVo xiaoxitongzhiVo) {
        LambdaQueryWrapper<Xiaoxitongzhi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getGangweimingcheng()), Xiaoxitongzhi::getGangweimingcheng,xiaoxitongzhiVo.getGangweimingcheng());        wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getYonghuming()), Xiaoxitongzhi::getYonghuming,xiaoxitongzhiVo.getYonghuming());        wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getXingming()), Xiaoxitongzhi::getXingming,xiaoxitongzhiVo.getXingming());        wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getBiaoti()), Xiaoxitongzhi::getBiaoti,xiaoxitongzhiVo.getBiaoti());        wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getNeirong()), Xiaoxitongzhi::getNeirong,xiaoxitongzhiVo.getNeirong());        wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getTongzhishijian()), Xiaoxitongzhi::getTongzhishijian,xiaoxitongzhiVo.getTongzhishijian());        wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getQiyehao()), Xiaoxitongzhi::getQiyehao,xiaoxitongzhiVo.getQiyehao());        wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getFuzeren()), Xiaoxitongzhi::getFuzeren,xiaoxitongzhiVo.getFuzeren());        wrapper.like(ObjectUtils.isNotEmpty(xiaoxitongzhiVo.getLianxidianhua()), Xiaoxitongzhi::getLianxidianhua,xiaoxitongzhiVo.getLianxidianhua());        
        Page<Xiaoxitongzhi> page = new Page<>(xiaoxitongzhiVo.getCurrent(),xiaoxitongzhiVo.getCurrentNum());
        xiaoxitongzhiDao.selectPage(page,wrapper);
        List<Xiaoxitongzhi> xiaoxitongzhis = page.getRecords();
        xiaoxitongzhiVo.setList(xiaoxitongzhis);
        xiaoxitongzhiVo.setPages(page.getPages());
        xiaoxitongzhiVo.setTotal(page.getTotal());
        xiaoxitongzhiVo.setCurrent(page.getCurrent());
        xiaoxitongzhiVo.setCurrentNum(page.getSize());
        return xiaoxitongzhiVo;
    }

    @Override
    public void deleteList(List<Xiaoxitongzhi> list) {
        List<Integer> ids =  list.stream().map(Xiaoxitongzhi::getId).collect(Collectors.toList());
        xiaoxitongzhiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
