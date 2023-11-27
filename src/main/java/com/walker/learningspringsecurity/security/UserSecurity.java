package com.walker.learningspringsecurity.security;

import com.walker.learningspringsecurity.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserSecurity {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private UserSecurity(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();

        this.authorities = user.getRoles().stream().map(role -> {
            return new SimpleGrantedAuthority("ROLE_".concat(role.getName()));
        }).collect(Collectors.toList());
    }
    public static UserSecurity create(User user){
        return new UserSecurity(user);
    }
}
