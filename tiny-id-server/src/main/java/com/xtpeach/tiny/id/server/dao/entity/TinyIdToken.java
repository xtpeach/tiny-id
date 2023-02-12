package com.xtpeach.tiny.id.server.dao.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


/**
 * 表名： tiny_id_token
 * ------------------------------------------------------------
 * 字段：id int4 (32)                 pk           主键编码
 * 字段：token varchar (255)          not null     token
 * 字段：biz_type varchar (63)        not null     此token可访问的业务类型标识
 * 字段：remark varchar (255)         not null     当前最大id
 * 字段：create_time timestamp (6)    not null     创建时间
 * 字段：update_time timestamp (6)    not null     更新时间
 * ------------------------------------------------------------
 */

// jpa-hibernate
@Entity
@Table(
        name = "tiny_id_token"
)
/**
 * @author xtpeach
 */
public class TinyIdToken {

    @Id
    @Column(name = "id", length = 64, nullable = false)
    @Excel(name = "id", orderNum = "0")
    private Integer id;

    @Column(name = "token", length = 255, nullable = false)
    @Excel(name = "token", orderNum = "1")
    private String token;

    @Column(name = "biz_type", length = 63, nullable = false)
    @Excel(name = "biz_type", orderNum = "2")
    private String bizType;

    @Column(name = "remark", length = 255, nullable = false)
    @Excel(name = "remark", orderNum = "3")
    private String remark;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(updatable = false)
    @Excel(name = "create_time", orderNum = "4", importFormat = "yyyy-MM-dd HH:mm:ss", exportFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Excel(name = "update_time", orderNum = "5", importFormat = "yyyy-MM-dd HH:mm:ss", exportFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}