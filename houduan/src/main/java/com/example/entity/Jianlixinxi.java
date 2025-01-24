package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("jianlixinxi")
@Data
public class Jianlixinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "jianlibianhao")	private String jianlibianhao;	@TableField(value = "xingming")	private String xingming;	@TableField(value = "xingbie")	private Boolean xingbie;	@TableField(value = "shouji")	private String shouji;	@TableField(value = "zhuanye")	private String zhuanye;	@TableField(value = "zhaopian")	private String zhaopian;	@TableField(value = "gerenjianjie")	private String gerenjianjie;	@TableField(value = "yonghuming")	private String yonghuming;	@TableField(value = "wenjian")	private String wenjian;	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getJianlibianhao() {
        return jianlibianhao;
    }
    public void setJianlibianhao(String jianlibianhao) {
		this.jianlibianhao = jianlibianhao;
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }	public Boolean getXingbie() {
        return xingbie;
    }
    public void setXingbie(Boolean xingbie) {
		this.xingbie = xingbie;
    }	public String getShouji() {
        return shouji;
    }
    public void setShouji(String shouji) {
		this.shouji = shouji;
    }	public String getZhuanye() {
        return zhuanye;
    }
    public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
    }	public String getZhaopian() {
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
    }	public String getGerenjianjie() {
        return gerenjianjie;
    }
    public void setGerenjianjie(String gerenjianjie) {
		this.gerenjianjie = gerenjianjie;
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }	public String getWenjian() {
        return wenjian;
    }
    public void setWenjian(String wenjian) {
		this.wenjian = wenjian;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}