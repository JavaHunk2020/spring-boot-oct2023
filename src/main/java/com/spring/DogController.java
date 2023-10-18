package com.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DogController {
	
	@GetMapping({"/faa","/","/foo"})
	public String showPage() {
		///dog.jsp
		return "dog"; ///Here spring will add prefix and suffix    /dog.jsp
	}
	
	
	//	<form action="addDog" method="post">
	@PostMapping("/addDog")
	public String postData(HttpServletRequest req) {
		String name=req.getParameter("name");
		String color=req.getParameter("color");
		String breed=req.getParameter("breed");
		String url=req.getParameter("url");
		Dog dog=new Dog(name , color , breed , url);
		//dog object adding into request scope
		req.setAttribute("tictick", dog);
		return "showDog";
	}

}
