package com.everyplan.apps.login;


import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * login을 위한 페이지 로드
	 */
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(Locale locale) {
		logger.info("This is loginPage! The client locale is {}.", locale);
		
	    return new ModelAndView("login/userCreate");
	}
	
}