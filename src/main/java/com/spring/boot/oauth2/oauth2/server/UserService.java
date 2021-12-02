package com.spring.boot.oauth2.oauth2.server;

import com.spring.boot.oauth2.oauth2.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
* @Description:    自定义用户登录逻辑
* @Author:         tan_yi
* @CreateDate:     2021/12/2 22:33
* @UpdateUser:     tan_yi
* @UpdateDate:     2021/12/2 22:33
* @UpdateRemark:   修改内容
* @Version:        1.0
* @company:        newLand
*/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserInfo("admin",passwordEncoder.encode("123"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
