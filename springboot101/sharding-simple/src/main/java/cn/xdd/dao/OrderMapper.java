package cn.xdd.dao;

import cn.xdd.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

//    @Select("SELECT o.orderId, o.orderNumber, oi.itemId, oi.productId, oi.quantity FROM t_order o" +
//            "JOIN t_order_item oi ON o.orderId = oi.orderId")
//    List<Order> selectOrderWithItems();

    @Insert("<script>INSERT INTO t_order_0  ( order_number,customer_id,order_date,total_amount,order_id )  VALUES "+
            "<foreach item='item' index='index' collection='orders' separator=','>"+
            "(#{item.orderNumber},#{item.customerId},#{item.orderDate},#{item.totalAmount},#{item.orderId} )"+
            "</foreach></script>")
    int batchInsert( List<Order> orders);
}