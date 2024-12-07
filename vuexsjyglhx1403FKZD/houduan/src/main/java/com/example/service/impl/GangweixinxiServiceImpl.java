package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Gangweixinxi;
import com.example.exception.CustomException;
import com.example.service.GangweixinxiService;
import com.example.vo.GangweixinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("gangweixinxiService")
public class GangweixinxiServiceImpl extends ServiceImpl<GangweixinxiDao, Gangweixinxi> implements GangweixinxiService {

    @Resource
    private GangweixinxiDao gangweixinxiDao;

    public Gangweixinxi add(Gangweixinxi gangweixinxi) {
		
	   //youquchong1
        gangweixinxi.setAddtime(new Date());
        gangweixinxiDao.insert(gangweixinxi);
        return gangweixinxi;
    }
	
	
	
    public void delete(Long id) {
        gangweixinxiDao.deleteById(id);
    }
	

    public void update(Gangweixinxi gangweixinxi) {
        //youquchong2
        gangweixinxiDao.updateById(gangweixinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return gangweixinxiDao.daochuexcel();
    }

    @Override
    public Gangweixinxi findById(Integer id) {
        return gangweixinxiDao.selectById(id);
    }

    public GangweixinxiVo findPage(GangweixinxiVo gangweixinxiVo) {
        LambdaQueryWrapper<Gangweixinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getGangweimingcheng()), Gangweixinxi::getGangweimingcheng,gangweixinxiVo.getGangweimingcheng());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getGongzuodidian()), Gangweixinxi::getGongzuodidian,gangweixinxiVo.getGongzuodidian());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getGongzuoshijian()), Gangweixinxi::getGongzuoshijian,gangweixinxiVo.getGongzuoshijian());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getXuqiurenshu()), Gangweixinxi::getXuqiurenshu,gangweixinxiVo.getXuqiurenshu());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getXinzi()), Gangweixinxi::getXinzi,gangweixinxiVo.getXinzi());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getGangweimiaoshu()), Gangweixinxi::getGangweimiaoshu,gangweixinxiVo.getGangweimiaoshu());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getTupian()), Gangweixinxi::getTupian,gangweixinxiVo.getTupian());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getQiyehao()), Gangweixinxi::getQiyehao,gangweixinxiVo.getQiyehao());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getQiyemingcheng()), Gangweixinxi::getQiyemingcheng,gangweixinxiVo.getQiyemingcheng());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getFuzeren()), Gangweixinxi::getFuzeren,gangweixinxiVo.getFuzeren());        wrapper.like(ObjectUtils.isNotEmpty(gangweixinxiVo.getLianxidianhua()), Gangweixinxi::getLianxidianhua,gangweixinxiVo.getLianxidianhua());        
        Page<Gangweixinxi> page = new Page<>(gangweixinxiVo.getCurrent(),gangweixinxiVo.getCurrentNum());
        gangweixinxiDao.selectPage(page,wrapper);
        List<Gangweixinxi> gangweixinxis = page.getRecords();
        gangweixinxiVo.setList(gangweixinxis);
        gangweixinxiVo.setPages(page.getPages());
        gangweixinxiVo.setTotal(page.getTotal());
        gangweixinxiVo.setCurrent(page.getCurrent());
        gangweixinxiVo.setCurrentNum(page.getSize());
        return gangweixinxiVo;
    }

    @Override
    public void deleteList(List<Gangweixinxi> list) {
        List<Integer> ids =  list.stream().map(Gangweixinxi::getId).collect(Collectors.toList());
        gangweixinxiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
