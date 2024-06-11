// package com.springboot101.config.cacheable.extend.aspect;
//
//
// import com.springboot101.config.cacheable.annotation.LybGeekCacheable;
// import com.springboot101.config.cacheable.extend.utils.CacheHelper;
// import lombok.extern.slf4j.Slf4j;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.springframework.core.annotation.Order;
//
// //@Component
// @Aspect
// @Slf4j
// @Order(1)
// /**
//  * 拆成2个切面是为让LybGeekCacheableExpireAspect比LybGeekCacheablePreLoadAspect先执行
//  */
// @Deprecated
// public class LybGeekCacheableExpireAspect {
//
//     @Before(value = "@annotation(lybGeekCacheable)")
//     public void before(LybGeekCacheable lybGeekCacheable){
//         CacheHelper.initExpireTime(lybGeekCacheable);
//         CacheHelper.initializeCaches();
//     }
//
//
//
//
// }
