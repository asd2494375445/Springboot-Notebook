package com.shardingsphere_101.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shardingsphere_101.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

//    @Select("SELECT o.orderId, o.orderNumber, oi.itemId, oi.productId, oi.quantity FROM t_order o" +
//            "JOIN t_order_item oi ON o.orderId = oi.orderId")
//    List<Order> selectOrderWithItems();

    @Insert("<script>INSERT INTO t_order  ( order_number,customer_id,order_date,total_amount )  VALUES "+
            "<foreach item='item' index='index' collection='orders' separator=','>"+
            "(#{item.orderNumber},#{item.customerId},#{item.orderDate},#{item.totalAmount} )"+
            "</foreach></script>")
    int batchInsert( List<Order> orders);
}