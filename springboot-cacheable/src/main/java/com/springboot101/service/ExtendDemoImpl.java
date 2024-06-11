// package com.springboot101.service;
//
// import org.springframework.cache.annotation.Cacheable;
//
// import java.util.Map;
//
// public class ExtendDemoImpl implements ExtendDemo{
//     /**
//      * 没有指定key时，采用默认策略 {@link org.springframework.cache.interceptor.SimpleKeyGenerator } 生成key
//      * <p>
//      * 对应的key为: k1::id
//      * value --> 等同于 cacheNames
//      * @param id
//      * @return
//      */
//     @Cacheable(value = "k1")
//     public String key1(int id) {
//         return "defaultKey:" + id;
//     }
//     /**
//      * redis_key :  k2::SimpleKey[]
//      *
//      * @return
//      */
//     @Cacheable(value = "k0")
//     public String key0() {
//         return "key0";
//     }
//
//     /**
//      * redis_key :  k2::SimpleKey[id,id2]
//      *
//      * @param id
//      * @param id2
//      * @return
//      */
//     @Cacheable(value = "k2")
//     public String key2(Integer id, Integer id2) {
//         return "key1" + id + "_" + id2;
//     }
//
//
//     @Cacheable(value = "k3")
//     public String key3(Map map) {
//         return "key3" + map;
//     }
//
// }
