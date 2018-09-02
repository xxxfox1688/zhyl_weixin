package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/")
@Controller
public class IndexController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("msg","Hello World 1112");
		return "index";
	}
}
