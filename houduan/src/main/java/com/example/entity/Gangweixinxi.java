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
	
	@TableField(value = "gangweimingcheng")	private String gangweimingcheng;	@TableField(value = "gongzuodidian")	private String gongzuodidian;	@TableField(value = "gongzuoshijian")	private String gongzuoshijian;	@TableField(value = "xuqiurenshu")	private String xuqiurenshu;	@TableField(value = "xinzi")	private String xinzi;	@TableField(value = "gangweimiaoshu")	private String gangweimiaoshu;	@TableField(value = "tupian")	private String tupian;	@TableField(value = "qiyehao")	private String qiyehao;	@TableField(value = "qiyemingcheng")	private String qiyemingcheng;	@TableField(value = "fuzeren")	private String fuzeren;	@TableField(value = "lianxidianhua")	private String lianxidianhua;	
    
	
	
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
    }	public String getGongzuodidian() {
        return gongzuodidian;
    }
    public void setGongzuodidian(String gongzuodidian) {
		this.gongzuodidian = gongzuodidian;
    }	public String getGongzuoshijian() {
        return gongzuoshijian;
    }
    public void setGongzuoshijian(String gongzuoshijian) {
		this.gongzuoshijian = gongzuoshijian;
    }	public String getXuqiurenshu() {
        return xuqiurenshu;
    }
    public void setXuqiurenshu(String xuqiurenshu) {
		this.xuqiurenshu = xuqiurenshu;
    }	public String getXinzi() {
        return xinzi;
    }
    public void setXinzi(String xinzi) {
		this.xinzi = xinzi;
    }	public String getGangweimiaoshu() {
        return gangweimiaoshu;
    }
    public void setGangweimiaoshu(String gangweimiaoshu) {
		this.gangweimiaoshu = gangweimiaoshu;
    }	public String getTupian() {
        return tupian;
    }
    public void setTupian(String tupian) {
		this.tupian = tupian;
    }	public String getQiyehao() {
        return qiyehao;
    }
    public void setQiyehao(String qiyehao) {
		this.qiyehao = qiyehao;
    }	public String getQiyemingcheng() {
        return qiyemingcheng;
    }
    public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
    }	public String getFuzeren() {
        return fuzeren;
    }
    public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
    }	public String getLianxidianhua() {
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