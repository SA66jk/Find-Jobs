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
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
    }
        return xingming;
    }
    public void setXingming(String xingming) {
		this.xingming = xingming;
    }
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
    }
        return neirong;
    }
    public void setNeirong(String neirong) {
		this.neirong = neirong;
    }
        return tongzhishijian;
    }
    public void setTongzhishijian(String tongzhishijian) {
		this.tongzhishijian = tongzhishijian;
    }
        return qiyehao;
    }
    public void setQiyehao(String qiyehao) {
		this.qiyehao = qiyehao;
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