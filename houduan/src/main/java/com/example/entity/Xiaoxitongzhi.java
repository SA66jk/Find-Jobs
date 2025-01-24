package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("xiaoxitongzhi")
@Data
public class Xiaoxitongzhi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "gangweimingcheng")	private String gangweimingcheng;	@TableField(value = "yonghuming")	private String yonghuming;	@TableField(value = "xingming")	private String xingming;	@TableField(value = "biaoti")	private String biaoti;	@TableField(value = "neirong")	private String neirong;	@TableField(value = "tongzhishijian")	private String tongzhishijian;	@TableField(value = "qiyehao")	private String qiyehao;	@TableField(value = "fuzeren")	private String fuzeren;	@TableField(value = "lianxidianhua")	private String lianxidianhua;	
    
	
	
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
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
    }	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
		this.neirong = neirong;
    }	public String getTongzhishijian() {
        return tongzhishijian;
    }
    public void setTongzhishijian(String tongzhishijian) {
		this.tongzhishijian = tongzhishijian;
    }	public String getQiyehao() {
        return qiyehao;
    }
    public void setQiyehao(String qiyehao) {
		this.qiyehao = qiyehao;
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