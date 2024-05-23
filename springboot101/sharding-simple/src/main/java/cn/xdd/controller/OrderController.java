package cn.xdd.controller;


import cn.xdd.dao.OrderItemMapper;
import cn.xdd.dao.OrderMapper;
import cn.xdd.entity.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * 公众号：程序员小富
 *
 * @author Jiahai
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderMapper orderMapper;





    @Resource
    private OrderItemMapper orderItemMapper;
    public static long getRandomNumber(int i) {
        int digits = 11; // 要生成的位数
        long min = (long) Math.pow(10, digits - 1); // 最小值
        long max = (long) Math.pow(10, digits) - 1; // 最大值
        Random random = new Random();
        long randomNumber = min + ((long) (random.nextDouble() * (max - min)));
        return randomNumber;
    }
    @RequestMapping("/test1")
    public String test1() {
        ArrayList<Order> list=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Order order = new Order();

            order.setOrderNumber("WIN000" + i);
            order.setCustomerId((long) i);
            long orderId = getRandomNumber(11);
            order.setOrderId(orderId);
            order.setOrderDate(new Date());
            order.setTotalAmount(new BigDecimal("0" + i));
//            orderMapper.insert(order);
            list.add(order);
        }
        System.out.printf( list.toString());
        orderMapper.batchInsert(list);


        return "ok";
    }
    @RequestMapping("/test2")
    public String test2() {
        ArrayList<Order> list=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Order order = new Order();

            order.setOrderNumber("WIN000" + i);
            order.setCustomerId((long) i);
            long orderId = getRandomNumber(11);
            order.setOrderId(orderId);
            order.setOrderDate(new Date());
            order.setTotalAmount(new BigDecimal("0" + i));
//            orderMapper.insert(order);
            list.add(order);
        }
        System.out.printf( list.toString());
        orderMapper.batchInsert(list);


        return "ok";
    }
    @RequestMapping("/test3")
    public String test3() {

        return "ok";
    }
}