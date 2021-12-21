package com.spring.boot.oauth2.oauth2.config;

import com.spring.boot.oauth2.oauth2.enhancer.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @ClassName JwtTokenStoreConfig
 * @Description Jwt整合springOauth2
 * 使用Jwt存储token的配置
 * @Auther tanyi
 * @Date 2021/12/21 11:18 PM
 * @ProjectName oauth2
 * @Version 1.0
 */
@Configuration
public class JwtTokenStoreConfig {

    /*
     * @Description: 创建一个JwtToken对象
     * @param:
     * @return
     * @author tanyi
     * @date 2021/12/21 11:22 PM
    */
    @Bean
    public JwtTokenStore getJwtTokenStore() {
        return new JwtTokenStore(getJwtAccessTokenConverter());
    }

    /*
     * @Description: 创建一个AccessToken 转 JwtToken 转换器
     * 用于构建JwtTokenStore对象
     * @param:
     * @return
     * @author tanyi
     * @date 2021/12/21 11:23 PM
    */
    @Bean
    public JwtAccessTokenConverter getJwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        // 配置Jwt的密钥
        jwtAccessTokenConverter.setSigningKey("secret");

        return jwtAccessTokenConverter;
    }

    /*
     * @Description: 配置Jwt内容增强器
     * @param:
     * @return
     * @author tanyi
     * @date 2021/12/21 11:56 PM
    */
    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer() {
        return new JwtTokenEnhancer();
    }

}
