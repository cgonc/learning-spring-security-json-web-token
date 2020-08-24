package com.portal.support.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import static java.util.Arrays.stream;

@AllArgsConstructor
public class UserPrincipal implements UserDetails {

	private final DbUser dbUser;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return stream(this.dbUser.getAuthorities()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.dbUser.getPassword();
	}

	@Override
	public String getUsername() {
		return this.dbUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.dbUser.isNotLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.dbUser.isActive();
	}
}
