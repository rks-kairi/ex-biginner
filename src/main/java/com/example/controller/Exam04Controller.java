package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
import com.example.form.UserReceiveForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	@ModelAttribute
	public UserReceiveForm setUpForm() {
		return new UserReceiveForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	
	@RequestMapping("/registration")
	public String Registration(
			@Validated UserReceiveForm receiveForm
			,BindingResult result
			,RedirectAttributes redirectAttributes
			) {
		
		if(result.hasErrors()) {
			return "exam04";
		}
		
		User user = new User();
		user.setName(receiveForm.getName());
		user.setAge(receiveForm.getIntAge());
		user.setComment(receiveForm.getComment());
		redirectAttributes.addFlashAttribute("user", user);
		return "exam04-result";
	}
}
