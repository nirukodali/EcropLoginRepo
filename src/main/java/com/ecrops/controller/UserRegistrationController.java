//package com.pesticides.controller;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.pesticides.dto.UserRegistrationDto;
//import com.pesticides.service.UserService;
//
//
//@Controller
//@RequestMapping("/registration")
//public class UserRegistrationController {
//
//	private UserService userService;
//
//	public UserRegistrationController(UserService userService) {
//		
//		super();
//		this.userService = userService;
//	}
//	
//	@ModelAttribute("user")
//	public UserRegistrationDto userRegistrationDto() {
//		return new UserRegistrationDto();
//	}
//	
//	@GetMapping
//	public String showRegForm(Model model) {
//		model.addAttribute("user", new UserRegistrationDto());
//		return "registration";
//	}
//	
//	@PostMapping
//	public String registerUser(
//			@ModelAttribute("user") UserRegistrationDto userRegistrationDto
//			) {
//		userService.save(userRegistrationDto);
//		return "redirect:/registration?success";
//	}
//}
//



