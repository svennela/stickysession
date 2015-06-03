package com.pivotal.application;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private static final String COUNTER_SESSION_ID = "COUNTER";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session, HttpServletRequest request) {
		Integer count = (Integer) session.getAttribute(COUNTER_SESSION_ID);
		logger.debug("Count found is " + count);
		
		count = (count != null) ? count + 1 : 0;
		session.setAttribute(COUNTER_SESSION_ID, count);
		logger.info("Count increased, it is now " + count);
		
		model.addAttribute("count", count);
		model.addAttribute("id", session.getId());
		
		return "home";
	}
	
	@RequestMapping(value="/reset", method=RequestMethod.GET)
	public String reset(HttpSession session) {
		logger.debug("Count was [" + session.getAttribute(COUNTER_SESSION_ID) + "], resetting...");
		session.removeAttribute(COUNTER_SESSION_ID);
		logger.debug("Count is now [" + session.getAttribute(COUNTER_SESSION_ID) + "]");
		return "redirect:/";
	}
	
	@RequestMapping(value="/session-store-test", method=RequestMethod.GET)
	public String session_store_test(HttpSession session) {
		TestObject to = new TestObject("George Washington", new Random().nextInt(105));
		session.setAttribute("session_store_test", to);
		logger.info("Set an object into the session");
		return "redirect:/session-store-load";
	}
	
	@RequestMapping(value="/session-store-load", method=RequestMethod.GET)
	public TestObject session_store_load(HttpSession session) {
		logger.info("Loading object from session");
		Object test = session.getAttribute("session_store_test");
		logger.info("Trying to cast...");
		TestObject myObj = (TestObject) test;
		logger.info("Cast OK!");
		return myObj;
	}
}
