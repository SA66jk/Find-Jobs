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
	
	@TableField(value = "jianlibianhao")
    
	
	
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
    }
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }
        return xingbie;
    }
    public void setXingbie(Boolean xingbie) {
		this.xingbie = xingbie;
    }
        return shouji;
    }
    public void setShouji(String shouji) {
		this.shouji = shouji;
    }
        return zhuanye;
    }
    public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
    }
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
    }
        return gerenjianjie;
    }
    public void setGerenjianjie(String gerenjianjie) {
		this.gerenjianjie = gerenjianjie;
    }
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }
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