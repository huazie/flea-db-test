package com.huazie.fleadbtest.jpa.split.entity;

import com.huazie.fleaframework.common.FleaEntity;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * flea订单属性表对应的实体类
 *
 * @author huazie
 * @version 2.0.0
 * @since 2.0.0
 */
@Entity
@Table(name = "order_attr")
public class OrderAttr extends FleaEntity {

    private static final long serialVersionUID = 4051659319280392497L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attr_id", unique = true, nullable = false)
    private Long attrId; // 属性编号

    @Column(name = "order_id", nullable = false)
    private Long orderId; // 订单编号

    @Column(name = "attr_code", nullable = false)
    private String attrCode; // 属性码

    @Column(name = "attr_value", nullable = false)
    private String attrValue; // 属性值

    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate; // 创建时间

    @Column(name = "remarks")
    private String remarks; // 备注

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getAttrCode() {
        return attrCode;
    }

    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}