package com.spring.boot.oauth2.oauth2.enhancer;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtTokenEnhancer
 * @Description JwtToken 内容增强器
 * @Auther tanyi
 * @Date 2021/12/21 11:48 PM
 * @ProjectName oauth2
 * @Version 1.0
 */
public class JwtTokenEnhancer implements TokenEnhancer {


    /*
     * @Description: JwtToken内容增强器
     * @param: oAuth2AccessToken
     * @param: oAuth2Authentication
     * @return
     * @author tanyi
     * @date 2021/12/21 11:54 PM
    */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();
        info.put("enhance", "enhancer info");
        // 给JwtToken设置附加信息
        ((DefaultOAuth2AccessToken)oAuth2AccessToken).setAdditionalInformation(info);
        return oAuth2AccessToken;
    }
}
