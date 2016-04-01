package com.rvr.lecture.security;

import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.rvr.lecture.persistence.model.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;
import java.util.Set;

public final class SecurityUtil {

    private SecurityUtil() {
        throw new AssertionError();
    }

    // API

    public static final List<GrantedAuthority> convertAuthorityEntieiesIntoSpringAuthorities(final Set<Authority> authorities) {
        final Iterable<String> authorityNames = Iterables.transform(authorities, Functions.toStringFunction());
        final String[] arrayOfAuthorityNames = Iterables.toArray(authorityNames, String.class);
        final List<GrantedAuthority> authoritiesForSpring = AuthorityUtils.createAuthorityList(arrayOfAuthorityNames);
        return authoritiesForSpring;
    }

}
