package com.springboot101.config.cacheable.extend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CacheMetaData {

    private Object key;
    private String[] cacheNames;
    private long expiredTimeSecond;
    private long preLoadTimeSecond;
}
