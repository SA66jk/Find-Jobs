package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("qiyexinxi")
@Data
public class Qiyexinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "qiyehao")	private String qiyehao;	@TableField(value = "mima")	private String mima;	@TableField(value = "qiyemingcheng")	private String qiyemingcheng;	@TableField(value = "qiyedizhi")	private String qiyedizhi;	@TableField(value = "qiyezhaopian")	private String qiyezhaopian;	@TableField(value = "fuzeren")	private String fuzeren;	@TableField(value = "lianxidianhua")	private String lianxidianhua;	@TableField(value = "qiyejianjie")	private String qiyejianjie;	@TableField(exist = false)	private String newPassword;	
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getQiyehao() {
        return qiyehao;
    }
    public void setQiyehao(String qiyehao) {
		this.qiyehao = qiyehao;
    }	public String getMima() {
        return mima;
    }
    public void setMima(String mima) {
		this.mima = mima;
    }	public String getQiyemingcheng() {
        return qiyemingcheng;
    }
    public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
    }	public String getQiyedizhi() {
        return qiyedizhi;
    }
    public void setQiyedizhi(String qiyedizhi) {
		this.qiyedizhi = qiyedizhi;
    }	public String getQiyezhaopian() {
        return qiyezhaopian;
    }
    public void setQiyezhaopian(String qiyezhaopian) {
		this.qiyezhaopian = qiyezhaopian;
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
    }	public String getQiyejianjie() {
        return qiyejianjie;
    }
    public void setQiyejianjie(String qiyejianjie) {
		this.qiyejianjie = qiyejianjie;
    }	public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
    }	
	

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtme(Date addtime) {
        this.addtime = addtime;
    }
}