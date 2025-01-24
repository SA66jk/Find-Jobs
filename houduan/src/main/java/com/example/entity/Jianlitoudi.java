package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("jianlitoudi")
@Data
public class Jianlitoudi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "gangweimingcheng")	private String gangweimingcheng;	@TableField(value = "gongzuoshijian")	private String gongzuoshijian;	@TableField(value = "qiyehao")	private String qiyehao;	@TableField(value = "qiyemingcheng")	private String qiyemingcheng;	@TableField(value = "fuzeren")	private String fuzeren;	@TableField(value = "yonghuming")	private String yonghuming;	@TableField(value = "xingming")	private String xingming;	@TableField(value = "shouji")	private String shouji;	@TableField(value = "jianliwenjian")	private String jianliwenjian;	@TableField(value = "issh")	private String issh;	@TableField(value = "shhf")	private String shhf;	
    
	
	
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
    }	public String getGongzuoshijian() {
        return gongzuoshijian;
    }
    public void setGongzuoshijian(String gongzuoshijian) {
		this.gongzuoshijian = gongzuoshijian;
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
    }	public String getShouji() {
        return shouji;
    }
    public void setShouji(String shouji) {
		this.shouji = shouji;
    }	public String getJianliwenjian() {
        return jianliwenjian;
    }
    public void setJianliwenjian(String jianliwenjian) {
		this.jianliwenjian = jianliwenjian;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}