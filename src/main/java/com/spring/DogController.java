package com.spring;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DogController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping({"/faa","/","/foo"})
	public String showPage() {
		///dog.jsp
		return "dog"; ///Here spring will add prefix and suffix    /dog.jsp
	}
	
	//deleteDog? cpname = testes
	@GetMapping("deleteDog")
	public String deleteDogAction(@RequestParam String cpname) {
		//ONE LINE CODE DELETING RECORD FROM DATABASE
		jdbcTemplate.update("delete from dogs_tbl where name = ?",new Object[] {cpname});
		return "redirect:/showDogs";
	}
	
	
	
	@GetMapping("/showDogs")
	public String showMyDogs(Model model) {
		///dog.jsp
		//WRITE CODE TO FETCH DATA
		List<Dog> dogList=jdbcTemplate.query("select name,color, breed, photo as url,cdate from dogs_tbl", new BeanPropertyRowMapper(Dog.class));
		//request.setAttribute("nisha",dogList);
		model.addAttribute("nisha", dogList);
		return "showDog"; ///Here spring will add prefix and suffix    /showDog.jsp
	}
	
	//	<form action="addDog" method="post">
	@PostMapping("/addDog")
	public String postData(HttpServletRequest req) {
		String name=req.getParameter("name");
		String color=req.getParameter("color");
		String breed=req.getParameter("breed");
		String url=req.getParameter("url");
		
		//Save data inside database
		Object[] data=new Object[] {name,color,breed,new Timestamp(new Date().getTime()),url};
		jdbcTemplate.update("insert into dogs_tbl values(?,?,?,?,?)",data);
		Dog dog=new Dog(name , color , breed , url);
		//dog object adding into request scope
		req.setAttribute("tictick", dog);
		return "redirect:/showDogs";
	}

}
