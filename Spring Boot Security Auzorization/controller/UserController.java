package com.springboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    
	@RequestMapping("/")
	@ResponseBody
	public String welcome(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return "Welcome to Online Shopping "+auth.getName();
	}
}