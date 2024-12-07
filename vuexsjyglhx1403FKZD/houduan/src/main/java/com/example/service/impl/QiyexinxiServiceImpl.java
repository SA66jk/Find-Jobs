package com.example.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.ResultCode;
import com.example.dao.*;
import com.example.entity.Qiyexinxi;
import com.example.exception.CustomException;
import com.example.service.QiyexinxiService;
import com.example.vo.QiyexinxiVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service("qiyexinxiService")
public class QiyexinxiServiceImpl extends ServiceImpl<QiyexinxiDao, Qiyexinxi> implements QiyexinxiService {

    @Resource
    private QiyexinxiDao qiyexinxiDao;

    public Qiyexinxi add(Qiyexinxi qiyexinxi) {
		if(qiyexinxi.getMima()==null) {qiyexinxi.setMima(SecureUtil.md5("001"));}else {qiyexinxi.setMima(SecureUtil.md5(qiyexinxi.getMima())); }
	    LambdaQueryWrapper<Qiyexinxi> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Qiyexinxi::getQiyehao,qiyexinxi.getQiyehao());
        Qiyexinxi findQiyexinxi = qiyexinxiDao.selectOne(wrapper);
        if (findQiyexinxi != null) {
            throw new CustomException("1001", "" + qiyexinxi.getQiyehao() + "\"已存在");
        }
        qiyexinxi.setAddtime(new Date());
        qiyexinxiDao.insert(qiyexinxi);
        return qiyexinxi;
    }
	
	
	
    public void delete(Long id) {
        qiyexinxiDao.deleteById(id);
    }
	

    public void update(Qiyexinxi qiyexinxi) {
         LambdaQueryWrapper<Qiyexinxi> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Qiyexinxi::getQiyehao,qiyexinxi.getQiyehao());
        Qiyexinxi findQiyexinxi = qiyexinxiDao.selectOne(wrapper);
		if (findQiyexinxi != null && qiyexinxi.getId() != findQiyexinxi.getId()) {
            throw new CustomException("1001", "" + qiyexinxi.getQiyehao() + "\"已存在");
        }
        qiyexinxiDao.updateById(qiyexinxi);
    }
	
	@Override
    public List<Map<String, Object>> daochuexcel() {
        return qiyexinxiDao.daochuexcel();
    }

    @Override
    public Qiyexinxi findById(Integer id) {
        return qiyexinxiDao.selectById(id);
    }

    public QiyexinxiVo findPage(QiyexinxiVo qiyexinxiVo) {
        LambdaQueryWrapper<Qiyexinxi> wrapper = Wrappers.lambdaQuery();
		wrapper.like(ObjectUtils.isNotEmpty(qiyexinxiVo.getQiyehao()), Qiyexinxi::getQiyehao,qiyexinxiVo.getQiyehao());        wrapper.like(ObjectUtils.isNotEmpty(qiyexinxiVo.getMima()), Qiyexinxi::getMima,qiyexinxiVo.getMima());        wrapper.like(ObjectUtils.isNotEmpty(qiyexinxiVo.getQiyemingcheng()), Qiyexinxi::getQiyemingcheng,qiyexinxiVo.getQiyemingcheng());        wrapper.like(ObjectUtils.isNotEmpty(qiyexinxiVo.getQiyedizhi()), Qiyexinxi::getQiyedizhi,qiyexinxiVo.getQiyedizhi());        wrapper.like(ObjectUtils.isNotEmpty(qiyexinxiVo.getQiyezhaopian()), Qiyexinxi::getQiyezhaopian,qiyexinxiVo.getQiyezhaopian());        wrapper.like(ObjectUtils.isNotEmpty(qiyexinxiVo.getFuzeren()), Qiyexinxi::getFuzeren,qiyexinxiVo.getFuzeren());        wrapper.like(ObjectUtils.isNotEmpty(qiyexinxiVo.getLianxidianhua()), Qiyexinxi::getLianxidianhua,qiyexinxiVo.getLianxidianhua());        wrapper.like(ObjectUtils.isNotEmpty(qiyexinxiVo.getQiyejianjie()), Qiyexinxi::getQiyejianjie,qiyexinxiVo.getQiyejianjie());        
        Page<Qiyexinxi> page = new Page<>(qiyexinxiVo.getCurrent(),qiyexinxiVo.getCurrentNum());
        qiyexinxiDao.selectPage(page,wrapper);
        List<Qiyexinxi> qiyexinxis = page.getRecords();
        qiyexinxiVo.setList(qiyexinxis);
        qiyexinxiVo.setPages(page.getPages());
        qiyexinxiVo.setTotal(page.getTotal());
        qiyexinxiVo.setCurrent(page.getCurrent());
        qiyexinxiVo.setCurrentNum(page.getSize());
        return qiyexinxiVo;
    }

    @Override
    public void deleteList(List<Qiyexinxi> list) {
        List<Integer> ids =  list.stream().map(Qiyexinxi::getId).collect(Collectors.toList());
        qiyexinxiDao.deleteBatchIds(ids);
    }
	
	@Override
    public Qiyexinxi login(Qiyexinxi qiyexinxi) {
        LambdaQueryWrapper<Qiyexinxi> wrapper = new LambdaQueryWrapper();
        wrapper.eq(ObjectUtils.isNotEmpty(qiyexinxi.getQiyehao()), Qiyexinxi::getQiyehao,qiyexinxi.getQiyehao());
        Qiyexinxi qiyexinxiInfo = qiyexinxiDao.selectOne(wrapper);
        if (qiyexinxiInfo == null) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        if (!SecureUtil.md5(qiyexinxi.getMima()).equalsIgnoreCase(qiyexinxiInfo.getMima())) {
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return qiyexinxiInfo;
    }
	
	 @Override
    public void findqiyexinxiqiyehao(Qiyexinxi qiyexinxi) {
        LambdaQueryWrapper<Qiyexinxi> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Qiyexinxi::getQiyehao,qiyexinxi.getQiyehao());
        Qiyexinxi findQiyexinxi = qiyexinxiDao.selectOne(wrapper);
        if (findQiyexinxi != null) {
            throw new CustomException("1001", "" + qiyexinxi.getQiyehao() + "\"已存在");
        }
    }
	
	//youxxianxci
}
