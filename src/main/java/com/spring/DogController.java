package com.spring;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DogController {
	
	@Autowired
	private DataSource dataSource;
	
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
		
		//Save data inside database
		JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
		Object[] data=new Object[] {name,color,breed,new Timestamp(new Date().getTime()),url};
		jdbcTemplate.update("insert into dogs_tbl values(?,?,?,?,?)",data);
		
		Dog dog=new Dog(name , color , breed , url);
		//dog object adding into request scope
		req.setAttribute("tictick", dog);
		return "showDog";
	}

}
