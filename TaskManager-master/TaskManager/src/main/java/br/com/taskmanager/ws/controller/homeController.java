package br.com.taskmanager.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	
	@RequestMapping("/home")
	public String goHome() {
		return "index";
	}
	
}
