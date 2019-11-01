package com.jt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.pojo.User;
import com.jt.service.UserService;

@Controller
public class UserController {
@Autowired
	private UserService userService;
@RequestMapping("/findAll")
public String UserTest(Model model) {
	List<User>userList = userService.findAll();
	model.addAttribute("userList", userList);
	return "userList";
}


@RequestMapping("/ajaxUser")
public String ajaxUsers() {
	return "ajax";
}
@RequestMapping("/ajaxFindUser")
@ResponseBody
public List<User> ajaxUser(Integer id) {
	List<User>user = userService.findAll();
	System.out.println("user:"+user);
	return user;
}
}
