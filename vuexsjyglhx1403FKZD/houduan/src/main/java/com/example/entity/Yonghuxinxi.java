package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@TableName("yonghuxinxi")
@Data
public class Yonghuxinxi {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
	
	@TableField(value = "yonghuming")
    
	
	
    @TableField(value = "addtime")
    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getYonghuming() {
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
        return xingbie;
    }
    public void setXingbie(Boolean xingbie) {
		this.xingbie = xingbie;
    }
        return mima;
    }
    public void setMima(String mima) {
		this.mima = mima;
    }
        return shouji;
    }
    public void setShouji(String shouji) {
		this.shouji = shouji;
    }
        return shenfenzheng;
    }
    public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
    }
        return touxiang;
    }
    public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
    }
        return beizhu;
    }
    public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
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