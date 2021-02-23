package com.matthew.springSampleProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String processJoke(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("joke") String joke, Model viewModel) {
		viewModel.addAttribute("viewModelName", name);
		viewModel.addAttribute("viewModelEmail", email);
		viewModel.addAttribute("viewModelJoke", joke);
		return "result.jsp";
	}
	
	//Path Variable
	@RequestMapping(value="/{iceCreamFlavor}", method=RequestMethod.GET)
	public String iceCream(@PathVariable("iceCreamFlavor") String iceCream, Model viewModel) {
		viewModel.addAttribute("favoriteFlavor", iceCream);
		return "icecream.jsp";
	}
}
