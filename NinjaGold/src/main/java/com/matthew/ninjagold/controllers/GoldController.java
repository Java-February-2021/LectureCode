package com.matthew.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
//	@RequestMapping(value="/", method=RequestMethod.GET)
	
	@GetMapping("/")
	public String index(HttpSession session, Model viewModel) {
		ArrayList<String> activity = new ArrayList<String>();
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activity);
		}
		
		viewModel.addAttribute("gold", session.getAttribute("gold"));
		viewModel.addAttribute("activity", session.getAttribute("activity"));
		return "index.jsp";
	}
	
//	@RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/processGold")
	public String process(@RequestParam("building") String building, HttpSession session) {
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		int gold = (int)session.getAttribute("gold");
		ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
		int goldThisTurn = 0;
		//((max - min) + 1 ) + min;
	    try {
	        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy h:mm");
	        Date past = format.parse("02/24/2021 12:30");
	        Date noww = new Date();
	        System.out.println(noww.getTime());

	        System.out.println(TimeUnit.MILLISECONDS.toMillis(noww.getTime() - past.getTime()) + " milliseconds ago");
	        System.out.println(TimeUnit.MILLISECONDS.toMinutes(noww.getTime() - past.getTime()) + " minutes ago");
	        System.out.println(TimeUnit.MILLISECONDS.toHours(noww.getTime() - past.getTime()) + " hours ago");
	        System.out.println(TimeUnit.MILLISECONDS.toDays(noww.getTime() - past.getTime()) + " days ago");
	    }
	    catch (Exception j){
	        j.printStackTrace();
	    }
		if(building.equals("farm")) {
			goldThisTurn = r.nextInt((20-10) + 1) + 10;
			activity.add(String.format("You entered a farm and earned %d gold %s \n", goldThisTurn, formatter.format(now)));
		} else if(building.equals("cave")) {
			goldThisTurn = r.nextInt((10-5) + 1) + 5;
			activity.add(String.format("You entered a cave and earned %d gold %s \n", goldThisTurn, formatter.format(now)));
		} else if(building.equals("house")) {
			goldThisTurn = r.nextInt((5-2) + 1) + 2;
			activity.add(String.format("You entered a house and earned %d gold %s \n", goldThisTurn, formatter.format(now)));
		} else {
			goldThisTurn = r.nextInt((50 + 50) + 1) - 50;
			if(goldThisTurn > 0) {
			activity.add(String.format("You entered a casino and won %d gold %s \n", goldThisTurn, formatter.format(now)));
			} else {
			activity.add(String.format("You entered a casino and lost %d gold. Ouch %s  \n", goldThisTurn, formatter.format(now)));
			}
			
			// If (condition) ? do Something : (else) do something else
}
		
		int totalGold = gold + goldThisTurn;
		session.setAttribute("gold", totalGold);
		session.setAttribute("activity", activity);
		return "redirect:/";
	}
}
