package com.bridge.interceptor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RegisterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String city = request.getParameter("city");

		String emailExpression = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern emailPattern = Pattern.compile(emailExpression);
		Matcher emailMatching = emailPattern.matcher(email);

		if ((name.equals("")) || (password.equals("")) || (email.equals("")) || (city.equals(""))) {

			ModelAndView mav = new ModelAndView("register");
			mav.addObject("message", "Please enter all the field");
			throw new ModelAndViewDefiningException(mav);

		}

		else if (!(emailMatching.matches() && (password.length() <= 8))) {

			ModelAndView mav = new ModelAndView("register");
			mav.addObject("message", "Please enter proper email & password");
			throw new ModelAndViewDefiningException(mav);

		} else
			return true;
	}
}
