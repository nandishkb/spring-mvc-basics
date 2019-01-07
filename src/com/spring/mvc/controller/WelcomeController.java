package com.spring.mvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.beans.Friend;
import com.spring.mvc.service.FriendService;

@Controller
public class WelcomeController {
	
	private static final Logger LOG = Logger.getLogger(WelcomeController.class);
	
	@Autowired
	private FriendService friendService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView WelcomeSpringMessage() {
		LOG.info("WelcomeController.WelcomeSpringMessage() Enterring --- >");
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
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", new Friend());
		mv.addObject("msg", message);
		mv.setViewName("addPage");
		return mv;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listMethod() {
		String message = "Listing All Record !!!";
		List<Friend> listOfFriends = friendService.listFriends();
		ModelAndView mv = new ModelAndView();
		mv.addObject("friends", listOfFriends);
		mv.addObject("msg", message);
		mv.setViewName("listPage");
		return mv;
	}
	
	@RequestMapping(value = "/saveFriend", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Friend friend) {
		System.out.println("WelcomeController.save() Friend name = "+friend.getFriendName());
		System.out.println("WelcomeController.save() Friend location = "+friend.getLocation());
		friendService.saveFriend(friend);
		String message = "Save successful !!!";
		return new ModelAndView("savePage", "msg", message);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id) {
		friendService.deleteFriend(id);
		return listMethod();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("id") int id) {
		System.out.println("WelcomeController.update() id = "+id);
		Friend friend = friendService.getFriendById(id);
		String message = "Update Record !!!";
		ModelAndView mv = new ModelAndView();
		mv.addObject("command", friend);
		mv.addObject("msg", message);
		mv.setViewName("addPage");
		return mv;
	}

}
