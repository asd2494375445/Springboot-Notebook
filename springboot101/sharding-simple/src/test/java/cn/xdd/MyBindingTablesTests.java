package cn.xdd;


import cn.xdd.dao.OrderItemMapper;
import cn.xdd.dao.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 绑定表测试
 */
@SpringBootTest
class MyBindingTablesTests {

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

    @Test
    public void insertOrderAndItemsTest() {

        for (int i = 0; i < 2; i++) {
            Order order = new Order();

            long orderId = getRandomNumber(11);
//            order.setOrderId(orderId);
            order.setOrderNumber("WIN" + orderId);
            order.setCustomerId((long) i);
            order.setOrderDate(new Date());
            order.setOrderId(orderId);
            order.setTotalAmount(new BigDecimal("0" + i));
            // 初始化SnowflakeIdWorker，传入数据中心ID和机器ID
//            SnowFlakeUtil snowFlakeUtil = new SnowFlakeUtil();
//            long id = snowFlakeUtil.nextId();

            orderMapper.insert(order);

//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrderId(order.getOrderId());
//            orderItem.setProductId(i);
//            orderItem.setQuantity(i);
//            orderItem.setUnitPrice(new BigDecimal("0" + i));
//            orderItemMapper.insert(orderItem);
        }
    }
}
