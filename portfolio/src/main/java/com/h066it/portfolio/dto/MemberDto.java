package com.h066it.portfolio.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberDto implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String pwd;
	private String nickName;
	private String authority;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return getPwd();
	}

	@Override
	public String getUsername() {
		return getId();
	}

	@Override
	public boolean isAccountNonExpired() {	// ����� �������� Ȯ�� ����. (��� ���� �������� true)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {	// ��� �������� Ȯ�� ����. (��� ���� �������� true)
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {	// ����� �н��������� Ȯ�� ����. (��� ���� �������� true)
		return true;
	}

	@Override
	public boolean isEnabled() {	// ��� ������ ���� ����. (��� ���� �������� true)
		return true;
	}

}
