package com.springboot101.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 没有指定key 使用默认生成

 */
@Service
public class ExtendDemo {
    /**
     * "k0::SimpleKey []",
     * 没有参数的情况下，其他的方法生成的key也是同样的key
     * @return
     */
    @Cacheable(value = "k0")
    public String key0() {
        return "key0";
    }
    /**
     * 没有指定key时，采用默认策略 {@link org.springframework.cache.interceptor.SimpleKeyGenerator } 生成key
     * <p>
     * 对应的key为: k1::id
     *         "k1::3",
     * value --> 等同于 cacheNames
     * 有参数的情况下

     * @param id
     * @return
     */
    @Cacheable(value = "k1")
    public String key1(int id) {
        return "defaultKey:" + id;
    }


    /**
     * redis_key :  k2::SimpleKey[id,id2]
     * 两个参数的情况下
     *         "k2::SimpleKey [3,3]"
     * @param id
     * @param id2
     * @return
     */
    @Cacheable(value = "k2")
    public String key2(Integer id, Integer id2) {
        return "key1" + id + "_" + id2;
    }

    /**
     * key 是map 的情况下
     *         "k3::{key1=defaultKey:3, key2=key13_3, key0=key0}",
     * @param map
     * @return
     */
    @Cacheable(value = "k3")
    public String key3(Map map) {
        return "key3" + map;
    }
}
