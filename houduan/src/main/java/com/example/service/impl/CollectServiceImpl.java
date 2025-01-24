package com.example.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.CollectDao;
import com.example.dao.FileInfoDao;
import com.example.entity.Collect;
import com.example.entity.FileInfo;
import com.example.entity.Qiyexinxi;
import com.example.entity.Gangweixinxi;

import com.example.service.CollectService;
import com.example.service.QiyexinxiService;
import com.example.service.GangweixinxiService;



import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("collectService")
public class CollectServiceImpl  extends ServiceImpl<CollectDao, Collect> implements CollectService {

    @Resource
    private CollectDao collectDao;
	
	@Resource
private QiyexinxiService qiyexinxiService;
@Resource
private GangweixinxiService gangweixinxiService;

   

    public Collect add(Collect collect) {
        Collect collect1 = collectDao.findByUser(collect);
        if(collect1 == null) {
            collectDao.insert(collect);
            return collect;
        }else {
            return null;
        }
    }

    public void delete(Integer id) {
        collectDao.deleteById(id);
    }

    public void update(Collect collect) {
        collectDao.updateById(collect);
    }

    public Collect findById(Long id) {
        return collectDao.selectById(id);
    }

    public List<Collect> findFrontPages(Integer userId) {
        List<Collect> collects;
        if (userId != null){
            collects = collectDao.findByEndUserId(userId);
        } else {
            collects = new ArrayList<>();
        }
        for (Collect collect : collects) {
            packOrder(collect);
        }
        return collects;
    }
    /**
     * 包装收藏的Job Seekers和商品信息
     */

	public List<Qiyexinxi> findPaperByQiyexinxi(Integer id) {
        List<Collect> collects = collectDao.findByEndUserId(id);
        List<Qiyexinxi> qiyexinxiList = new ArrayList<>();
        for (Collect collect : collects) {
            Integer foreignId = collect.getShangpinxinxiID();
            Qiyexinxi qiyexinxi = null;
            if(foreignId != null){
                qiyexinxi = qiyexinxiService.findById(foreignId);
            };
            if(qiyexinxi != null){
                qiyexinxiList.add(qiyexinxi);
            }
        }
        return qiyexinxiList;
    }

	
	private void packOrder(Collect collect) {
        collect.setQiyexinxi(qiyexinxiService.findById(collect.getUserId()));
        List<Gangweixinxi> goodsList = CollUtil.newArrayList();
        collect.setProductList(goodsList);
        Gangweixinxi goodsDetail = gangweixinxiService.findById(collect.getShangpinxinxiID());
        if (goodsDetail != null) {
            goodsList.add(goodsDetail);
        }
    }

	@Override
    public void deleteByUserId(Integer id, Integer userId) {
        collectDao.deleteByUserId(id,userId);
    }
    
}
