package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.impl.MemberDaoImpl;
import com.example.demo.vo.Member;

import jakarta.servlet.http.HttpSession;

@RestController
public class MemberController {
	@Autowired
	MemberDaoImpl mdi;
	@Autowired
	HttpSession session;

	@PostMapping("/login")
	public ModelAndView login(String username, String password) {
		ModelAndView mv = new ModelAndView();
		Member m = mdi.queryMember(username, password);
		if (m != null) {
			session.setAttribute("MEMBER", m);
			mv.setViewName("loginSuccess");
		} else {

			mv.setViewName("loginError");
		}
		return mv;
	}

	@GetMapping("/goAddMember")
	public ModelAndView goAddMember() {
		return new ModelAndView("addMember");
	}

	@PostMapping("/doAddMember")
	public ModelAndView doAddMember(@ModelAttribute("Member") Member m) {
		ModelAndView mv = new ModelAndView();
		if (mdi.queryUsername(m.getUsername())) {
			mv.setViewName("addMemberError");
		} else {
			mdi.addMember(m);
			mv.setViewName("addMemberSuccess");
		}
		return mv;
	}
}
