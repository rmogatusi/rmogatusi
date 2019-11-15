package com.mogatusi.online.registration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mogatusi.online.registration.model.Person;
import com.mogatusi.online.registration.service.PersonService;


@Controller
public class HomeController {

	private PersonService personService;
	private final String HOMEVIEW = "home";
	private final String REPORTVIEW = "report";
	
	public HomeController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/")
	public String registrationPortal() {
		return HOMEVIEW;
	}
	
	@PostMapping("/register")
	public ModelAndView register(Person person, Model model) throws Exception{
		personService.savePerson(person);
		model.addAttribute("msg", "Person saved successfully.");
		return new ModelAndView(HOMEVIEW);
	}
	
	@GetMapping("/report")
	public String report(ModelMap modelMap){
		List<Person> people = personService.getAllPeople();
        modelMap.addAttribute("people", people);
        return REPORTVIEW;
	}
	
	@ExceptionHandler(Exception.class)
	public String handlerException(HttpServletRequest req, Exception exception, Model model) {
		model.addAttribute("errorMessage", exception.getMessage());
		return "postError";
	}
}
