package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.beans.Friend;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView WelcomeSpringMessage() {
		String message = "Welcome to Spring MVC Basics...";
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		mv.addObject("msg", message);
		return mv;
	}
	
	@RequestMapping(value = "/addRecord", method = RequestMethod.GET)
	public ModelAndView addRecord() {
		String message = "Record Added...";
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addRecord");
		mv.addObject("msg", message);
		return mv;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addMethod() {
		String message = "Add New Record !!!";
		return new ModelAndView("addPage", "msg", message);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listMethod() {
		String message = "List All Record !!!";
		return new ModelAndView("listPage", "msg", message);
	}
	
	@RequestMapping(value = "/saveFriend", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Friend friend) {
		System.out.println("WelcomeController.save() Friend name = "+friend.getFriendName());
		System.out.println("WelcomeController.save() Friend location = "+friend.getLocation());
		String message = "Save successful !!!";
		return new ModelAndView("savePage", "msg", message);
	}

}
