package com.example.demo.controller;

import com.example.demo.model.UserForm;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/input")
	public String index(UserForm userForm, Model model) {
		model.addAttribute("userForm", userForm);
		return "input";
	}

	@PostMapping("/submit")
	public String submit(UserForm userForm, Model model) {
		this.userService.registerUser(userForm);
		model.addAttribute("userForm", userForm);
		return "result";
	}
}
