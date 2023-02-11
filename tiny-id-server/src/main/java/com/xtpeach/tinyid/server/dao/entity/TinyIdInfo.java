package com.xtpeach.tinyid.server.dao.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * 表名： tiny_id_info
 * ------------------------------------------------------------
 * 字段：id int4 (32)                 pk           主键编码
 * 字段：biz_type varchar (63)        not null     业务类型，唯一
 * 字段：begin_id int4 (32)           not null     开始id，仅记录初始值，无其他含义。初始化时begin_id和max_id应相同
 * 字段：max_id int4 (32)             not null     当前最大id
 * 字段：step int4 (32)               not null     步长
 * 字段：delta int4 (32)              not null     每次id增量
 * 字段：remainder int4 (32)          not null     余数
 * 字段：create_time timestamp (6)    not null     创建时间
 * 字段：update_time timestamp (6)    not null     更新时间
 * 字段：version int4 (32)            not null     版本号
 * ------------------------------------------------------------
 */

// jpa-hibernate
@Entity
@Table(
        name = "tiny_id_info"
)
/**
 * @author xtpeach
 */
public class TinyIdInfo {

    @Id
    @Column(name = "id", length = 64, nullable = false)
    @Excel(name = "id", orderNum = "0")
    private Long id;

    @Column(name = "biz_type", length = 63, nullable = false)
    @Excel(name = "biz_type", orderNum = "1")
    private String bizType;

    @Column(name = "begin_id", length = 32, nullable = false)
    @Excel(name = "begin_id", orderNum = "2")
    private Long beginId;

    @Column(name = "max_id", length = 32, nullable = false)
    @Excel(name = "max_id", orderNum = "3")
    private Long maxId;

    @Column(name = "step", length = 32, nullable = false)
    @Excel(name = "step", orderNum = "4")
    private Integer step;

    @Column(name = "delta", length = 32, nullable = false)
    @Excel(name = "delta", orderNum = "5")
    private Integer delta;

    @Column(name = "remainder", length = 32, nullable = false)
    @Excel(name = "remainder", orderNum = "6")
    private Integer remainder;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(updatable = false)
    @Excel(name = "create_time", orderNum = "7", importFormat = "yyyy-MM-dd HH:mm:ss", exportFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Excel(name = "update_time", orderNum = "8", importFormat = "yyyy-MM-dd HH:mm:ss", exportFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Column(name = "version", length = 32, nullable = false)
    @Excel(name = "version", orderNum = "9")
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Long getBeginId() {
        return beginId;
    }

    public void setBeginId(Long beginId) {
        this.beginId = beginId;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

    public Integer getRemainder() {
        return remainder;
    }

    public void setRemainder(Integer remainder) {
        this.remainder = remainder;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}