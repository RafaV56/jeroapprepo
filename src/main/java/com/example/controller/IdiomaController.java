package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IdiomaController {

	@GetMapping("/idioma")
	public String idioma(HttpServletRequest request){
		String ultimaURL=request.getHeader("referer");
		return "redirect:".concat(ultimaURL);
		
	}
}
