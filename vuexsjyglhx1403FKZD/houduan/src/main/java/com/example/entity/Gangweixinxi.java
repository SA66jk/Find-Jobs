package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("gangweixinxi")
@Data
public class Gangweixinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "gangweimingcheng")
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getGangweimingcheng() {
        return gangweimingcheng;
    }
    public void setGangweimingcheng(String gangweimingcheng) {
		this.gangweimingcheng = gangweimingcheng;
    }
        return gongzuodidian;
    }
    public void setGongzuodidian(String gongzuodidian) {
		this.gongzuodidian = gongzuodidian;
    }
        return gongzuoshijian;
    }
    public void setGongzuoshijian(String gongzuoshijian) {
		this.gongzuoshijian = gongzuoshijian;
    }
        return xuqiurenshu;
    }
    public void setXuqiurenshu(String xuqiurenshu) {
		this.xuqiurenshu = xuqiurenshu;
    }
        return xinzi;
    }
    public void setXinzi(String xinzi) {
		this.xinzi = xinzi;
    }
        return gangweimiaoshu;
    }
    public void setGangweimiaoshu(String gangweimiaoshu) {
		this.gangweimiaoshu = gangweimiaoshu;
    }
        return tupian;
    }
    public void setTupian(String tupian) {
		this.tupian = tupian;
    }
        return qiyehao;
    }
    public void setQiyehao(String qiyehao) {
		this.qiyehao = qiyehao;
    }
        return qiyemingcheng;
    }
    public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
    }
        return fuzeren;
    }
    public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
    }
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
    }
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}