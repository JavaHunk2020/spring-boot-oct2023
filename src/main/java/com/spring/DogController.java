package com.spring;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
class SortByName implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

class SortByNameDesc implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		return o2.getName().compareTo(o1.getName());
	}
	
}

@Controller
public class DogController {
	
	@Autowired
	private DogRepository dogRepository;
	@GetMapping({"/faa","/","/foo"})
	public String showPage() {
		///dog.jsp
		return "dog"; ///Here spring will add prefix and suffix    /dog.jsp
	}
	
	//deleteDog? cpname = testes
	@GetMapping("deleteDog")
	public String deleteDogAction(@RequestParam String cpname) {
		//ONE LINE CODE DELETING RECORD FROM DATABASE
		//jdbcTemplate.update("delete from dogs_tbl where name = ?",new Object[] {cpname});
		dogRepository.deleteById(cpname);
		return "redirect:/showDogs";
	}
	
	
	@GetMapping("/sortByName")
	public String sortByName(@RequestParam String sortname,Model model) {
		List<Dog> dogList=dogRepository.findAll();
		if(sortname.equalsIgnoreCase("asc")) {
			model.addAttribute("sortname","desc");
			Collections.sort(dogList, new SortByNameDesc());
		}else {
			model.addAttribute("sortname","asc");
		   Collections.sort(dogList, new SortByName());
		}
		model.addAttribute("nisha", dogList);
		return "showDog"; ///Here spring will add prefix and suffix    /showDog.jsp
	}
	
	@GetMapping("/showDogs")
	public String showMyDogs(Model model) {
		List<Dog> dogList=dogRepository.findAll();
		Collections.sort(dogList, new SortByName());
		model.addAttribute("sortname","asc");
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
		Dog dog=new Dog(name , color , breed , url);
		//dog object adding into request scope
		dogRepository.save(dog);
		req.setAttribute("tictick", dog);
		return "redirect:/showDogs";
	}

}
