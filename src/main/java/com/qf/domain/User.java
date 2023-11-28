package com.qf.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author : sin
 * @date : 2023/11/28 8:52
 * @Description :
 */
@ToString
@Data
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    @TableField(exist = false)
    private List<GrantedAuthority> authorities;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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