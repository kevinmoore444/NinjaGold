package com.codingdojo.gold.ninja.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ninja")
public class MainController {
    ArrayList<String> activities = new ArrayList<String>();
    SimpleDateFormat simpleFormat = new SimpleDateFormat("MMMM d y h:mm a");
	
	//View Home Page
    @GetMapping("")
    public String viewHome(HttpSession session) {

    	if(session.getAttribute("gold") == null) {
    		session.setAttribute("gold", 0);
	    	session.setAttribute("activities", activities);
	    	}
  
        return "index.jsp";
    }
    
	//Debtors Prison
    @GetMapping("/prison")
    public String viewHome() {
        return "prison.jsp";
    }
    
    //View activities
    @RequestMapping("/activities")
    public String activities() {
    	return "activities.jsp";
    }
    
    

    
    
    
    //Process Farm action
    @PostMapping("/action")
    public String processChoice(
    	HttpSession session, 
		@RequestParam(value="choice") String choice)
		
    	{
	    	Integer goldCount = (Integer) session.getAttribute("gold");
			//If Farm is Chosen (Using Max - min +1 for range)
			if (choice.equals("farm")) {
		        int min = 10;
		        int range = 11;
		        int randomGold = (int)(Math.random() * range) + min;
		        goldCount += randomGold;
		        session.setAttribute("gold", goldCount);
				activities.add("You entered a farm and earned " + randomGold + " gold " + (simpleFormat.format(new Date())));
				session.setAttribute("activities", activities);   
			}
			
			//If Cave is Chosen
			if (choice.equals("cave")) {

		        int randomGold = new Random().nextInt(6)+5;
		        goldCount += randomGold;
		        session.setAttribute("gold", goldCount);
				activities.add("You entered a cave and earned " + randomGold + " gold " + (simpleFormat.format(new Date())));
				session.setAttribute("activities", activities);   
			}
			
			
			//If House is Chosen
			if (choice.equals("house")) {
		        int randomGold = new Random().nextInt(4)+2;
		        goldCount += randomGold;
		        session.setAttribute("gold", goldCount);
				activities.add("You entered a house and earned " + randomGold + " gold " + (simpleFormat.format(new Date())));
				session.setAttribute("activities", activities);   
			}
			
			//If Quest is Chosen
			if (choice.equals("quest")) {
		        int randomGold = new Random().nextInt(101)-50;
		        goldCount += randomGold;
		        session.setAttribute("gold", goldCount);
		        
		        if(randomGold >= 0) {
		        	activities.add("You completed a quest and earned " + randomGold + " gold " + (simpleFormat.format(new Date())));
		        }
		        else {
		        	activities.add("You failed a quest and lost " + randomGold + " gold " + (simpleFormat.format(new Date())));
		        }
				session.setAttribute("activities", activities);   
			}
			
			//If Spa is Chosen
			if (choice.equals("spa")) {
		        int randomGold = new Random().nextInt(16)-20;
		        goldCount += randomGold;
		        session.setAttribute("gold", goldCount);
				activities.add("You visited a spa and lost " + randomGold + "gold " + (simpleFormat.format(new Date())));
				session.setAttribute("activities", activities); 
			}
			
			//If Reset is Chosen
			if (choice.equals("reset")) {
		        session.setAttribute("gold", 0);
		        activities = new ArrayList<String>();
		        session.setAttribute("activities", activities);
			}
			
			
			//Send player to prison if gold count goes below Zero, otherwise refresh the main page to keep playing. 			
			if(goldCount < 0 ) {
				return "redirect:/ninja/prison";
			}
			else {
			//Redirect back to the home page
	    	return "redirect:/ninja";
			}
			
			//Closes this method
			}
    
    	


    	
    }
 
    
    
    
    
    
    
    
    

