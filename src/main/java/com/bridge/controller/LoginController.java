package com.bridge.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridge.model.Login;
import com.bridge.model.User;
import com.bridge.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	private IUserService userServices;

	/*
	 * @Autowired(required = true) public void setIUserService(IUserService
	 * userServices) { this.userServices = userServices; }
	 */
	@RequestMapping(value = "/")
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/login");
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public Object home(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {

		System.out.println("comes under login process");
		User user = userServices.login(login);
		System.out.println("verifies the email and password and comes again the login process");
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("User", user.getEmail());
			return "redirect:load-data";
		} else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("result", "No user Found");
			return mav;
		}
	}

	@RequestMapping(value = "/load-data", method = RequestMethod.GET)
	public ModelAndView load(HttpSession session) {

		Object userObj = session.getAttribute("User");

		if (userObj == null) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("result", "Please log in");
			return mav;
		}

		String email = (String) userObj;
		User user = userServices.getByEmail(email);
		ModelAndView mav = new ModelAndView("home");
		mav.addObject("username", user.getName());
		mav.addObject("city", user.getCity());
		mav.addObject("email", user.getEmail());
		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {

		HttpSession httpSession = request.getSession(false);
		httpSession.removeAttribute("User");
		httpSession.invalidate();
		return new ModelAndView("login");
	}
}
