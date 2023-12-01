package com.example.demo.service;

import com.example.demo.vo.Member;

public interface MemberDao {
	void addMember(Member m);
	Member queryMember(String username, String password);
	boolean queryUsername(String username);
}
