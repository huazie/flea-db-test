package com.huazie.jpa.split.entity;

import com.huazie.fleaframework.common.FleaEntity;
import com.huazie.fleaframework.db.common.FleaTableGenerator;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * <p> flea订单表对应的实体类 </p>
 *
 * @author huazie
 * @version 1.2.0
 * @since 1.2.0
 */
@Entity
@Table(name = "order")
public class Order extends FleaEntity {

    private static final long serialVersionUID = -4227307709873971328L;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ORDER_GENERATOR")
    @TableGenerator(
        // 唯一的生成器名称，可以由一个或多个类引用以作为id值的生成器。
        name = "ORDER_GENERATOR",
        // 存储生成的ID值的表的名称
        table = "flea_id_generator",
        // 表中主键列的名称
        pkColumnName = "id_generator_key",
        // 存储最后生成的主键值的列的名称
        valueColumnName = "id_generator_value",
        // ID生成器表中的主键值模板，用于将该生成值集与其他可能存储在表中的值区分开
        pkColumnValue = "pk_order",
        // 从ID生成器表中分配ID号时增加的数量
        allocationSize = 1
    )
    @FleaTableGenerator(generatorFlag = false)
    @Column(name = "order_id", unique = true, nullable = false)
    private Long orderId; // 订单编号

    @Column(name = "order_name")
    private String orderName; // 订单名称

    @Column(name = "order_price", nullable = false)
    private Long orderPrice; // 订单价格（单位：分）

    @Column(name = "order_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate; // 下单时间

    @Column(name = "order_state", nullable = false)
    private Integer orderState; // 订单状态（0：初始 1：待支付 2：待发货 3：待收货 4：完结）

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}