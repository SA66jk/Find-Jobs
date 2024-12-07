package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Jianlixinxi;
import com.example.exception.CustomException;
import com.example.service.JianlixinxiService;
import com.example.vo.JianlixinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("jianlixinxiService")
public class JianlixinxiServiceImpl extends ServiceImpl<JianlixinxiDao, Jianlixinxi> implements JianlixinxiService {

    @Resource
    private JianlixinxiDao jianlixinxiDao;

    public Jianlixinxi add(Jianlixinxi jianlixinxi) {
		
	   //youquchong1
        jianlixinxi.setAddtime(new Date());
        jianlixinxiDao.insert(jianlixinxi);
        return jianlixinxi;
    }
	
	
	
    public void delete(Long id) {
        jianlixinxiDao.deleteById(id);
    }
	

    public void update(Jianlixinxi jianlixinxi) {
        //youquchong2
        jianlixinxiDao.updateById(jianlixinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return jianlixinxiDao.daochuexcel();
    }

    @Override
    public Jianlixinxi findById(Integer id) {
        return jianlixinxiDao.selectById(id);
    }

    public JianlixinxiVo findPage(JianlixinxiVo jianlixinxiVo) {
        LambdaQueryWrapper<Jianlixinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(jianlixinxiVo.getJianlibianhao()), Jianlixinxi::getJianlibianhao,jianlixinxiVo.getJianlibianhao());        wrapper.like(ObjectUtils.isNotEmpty(jianlixinxiVo.getXingming()), Jianlixinxi::getXingming,jianlixinxiVo.getXingming());        wrapper.eq(ObjectUtils.isNotEmpty(jianlixinxiVo.getXingbie()), Jianlixinxi::getXingbie,jianlixinxiVo.getXingbie());        wrapper.like(ObjectUtils.isNotEmpty(jianlixinxiVo.getShouji()), Jianlixinxi::getShouji,jianlixinxiVo.getShouji());        wrapper.like(ObjectUtils.isNotEmpty(jianlixinxiVo.getZhuanye()), Jianlixinxi::getZhuanye,jianlixinxiVo.getZhuanye());        wrapper.like(ObjectUtils.isNotEmpty(jianlixinxiVo.getZhaopian()), Jianlixinxi::getZhaopian,jianlixinxiVo.getZhaopian());        wrapper.like(ObjectUtils.isNotEmpty(jianlixinxiVo.getGerenjianjie()), Jianlixinxi::getGerenjianjie,jianlixinxiVo.getGerenjianjie());        wrapper.like(ObjectUtils.isNotEmpty(jianlixinxiVo.getYonghuming()), Jianlixinxi::getYonghuming,jianlixinxiVo.getYonghuming());        wrapper.like(ObjectUtils.isNotEmpty(jianlixinxiVo.getWenjian()), Jianlixinxi::getWenjian,jianlixinxiVo.getWenjian());        
        Page<Jianlixinxi> page = new Page<>(jianlixinxiVo.getCurrent(),jianlixinxiVo.getCurrentNum());
        jianlixinxiDao.selectPage(page,wrapper);
        List<Jianlixinxi> jianlixinxis = page.getRecords();
        jianlixinxiVo.setList(jianlixinxis);
        jianlixinxiVo.setPages(page.getPages());
        jianlixinxiVo.setTotal(page.getTotal());
        jianlixinxiVo.setCurrent(page.getCurrent());
        jianlixinxiVo.setCurrentNum(page.getSize());
        return jianlixinxiVo;
    }

    @Override
    public void deleteList(List<Jianlixinxi> list) {
        List<Integer> ids =  list.stream().map(Jianlixinxi::getId).collect(Collectors.toList());
        jianlixinxiDao.deleteBatchIds(ids);
    }
	
	
	
	
	
	//youxxianxci
}
