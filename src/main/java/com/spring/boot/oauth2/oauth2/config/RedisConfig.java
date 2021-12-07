package com.spring.boot.oauth2.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
* @Description:    redis配置类
 * 功能：
 *  1. 使用redis存储token
* @Author:         tan_yi
* @CreateDate:     2021/12/7 21:08
* @UpdateUser:     tan_yi
* @UpdateDate:     2021/12/7 21:08
* @UpdateRemark:   修改内容
* @Version:        1.0
* @company:        newLand
*/
@Configuration
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Qualifier("redisTokenStore")
    @Bean
    public RedisTokenStore getReidTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
}
