package com.rvr.lecture.security;

import com.rvr.lecture.persistence.dao.IUserJpaDAO;
import com.rvr.lecture.persistence.model.Authority;
import com.rvr.lecture.persistence.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    //private IUserService userService;
    private IUserJpaDAO userService;

    // API

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Users foundByUsername = userService.findByName(username);
        final Set<Authority> authorities = foundByUsername.getAuthorities();
        final List<GrantedAuthority> authoritiesForSpring = SecurityUtil.convertAuthorityEntieiesIntoSpringAuthorities(authorities);

        return new org.springframework.security.core.userdetails.User(username, foundByUsername.getPassword(), authoritiesForSpring);
    }



}
