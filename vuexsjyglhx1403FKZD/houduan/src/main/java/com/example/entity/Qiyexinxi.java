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
	
	@TableField(value = "qiyehao")
    
	
	
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
    }
        return mima;
    }
    public void setMima(String mima) {
		this.mima = mima;
    }
        return qiyemingcheng;
    }
    public void setQiyemingcheng(String qiyemingcheng) {
		this.qiyemingcheng = qiyemingcheng;
    }
        return qiyedizhi;
    }
    public void setQiyedizhi(String qiyedizhi) {
		this.qiyedizhi = qiyedizhi;
    }
        return qiyezhaopian;
    }
    public void setQiyezhaopian(String qiyezhaopian) {
		this.qiyezhaopian = qiyezhaopian;
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
        return qiyejianjie;
    }
    public void setQiyejianjie(String qiyejianjie) {
		this.qiyejianjie = qiyejianjie;
    }
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