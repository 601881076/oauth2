package com.spring.boot.oauth2.oauth2.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
* @Description:    自定义用户类
* @Author:         tan_yi
* @CreateDate:     2021/12/2 22:31
* @UpdateUser:     tan_yi
* @UpdateDate:     2021/12/2 22:31
* @UpdateRemark:   修改内容
* @Version:        1.0
* @company:        newLand
*/
public class UserInfo implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> grantedAuthorities;

    public UserInfo(String username, String password, List<GrantedAuthority> grantedAuthorities) {

        this.username = username;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }

    public UserInfo() { }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
