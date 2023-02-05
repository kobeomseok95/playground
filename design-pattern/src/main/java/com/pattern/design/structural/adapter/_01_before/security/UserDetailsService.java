package com.pattern.design.structural.adapter._01_before.security;

public interface UserDetailsService {
    UserDetails loadUser(String username);
}
