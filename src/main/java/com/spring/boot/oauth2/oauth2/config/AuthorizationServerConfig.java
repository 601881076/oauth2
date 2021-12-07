package com.spring.boot.oauth2.oauth2.config;

import com.spring.boot.oauth2.oauth2.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
* @Description:    授权服务器配置
* @Author:         tan_yi
* @CreateDate:     2021/12/2 22:43
* @UpdateUser:     tan_yi
* @UpdateDate:     2021/12/2 22:43
* @UpdateRemark:   修改内容
* @Version:        1.0
* @company:        newLand
*/
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    // 因为TokenStore的实现类很多，这里需要指定使用哪一个实现类
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    /**
     * 使用密码模式时需要配置
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService)
                .tokenStore(tokenStore)
        ;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 选择存储方式，这里为了测试选择了内存存储，实际使用jdbc
        clients.inMemory()
                // 客户端ID
                .withClient("admin")
                // 客户端密码
                .secret(passwordEncoder.encode("112233"))
                // 配置重定向url，用于授权成功后跳转并接收令牌
                .redirectUris("http://www.baidu.com")
                // 设置作用域
                .scopes("all")
                /*
                配置grant_type，
                authorization_code: 授权码模式
                password: 密码模式
                */
                .authorizedGrantTypes("authorization_code", "password")
        ;
    }
}
