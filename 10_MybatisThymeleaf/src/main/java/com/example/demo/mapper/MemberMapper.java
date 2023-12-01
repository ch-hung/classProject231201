package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.Member;

@Mapper
public interface MemberMapper {
	
	@Insert("insert into member(username, password, name, address, phone, mobile) value(#{username}, #{password}, #{name}, #{address}, #{phone}, #{mobile})")
	void addMember(Member m);
	
	@Select("select * from member where username=#{username} and password=#{password}")
	Member queryMember(String username, String password);
	
	@Select("select * from member where username=#{username}")
	Member queryUsername(String username);
}