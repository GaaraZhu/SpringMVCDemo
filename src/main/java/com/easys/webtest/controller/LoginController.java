package com.easys.webtest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.easys.webtest.controller.dto.LoginInfo;
import com.easys.webtest.domain.entity.User;
import com.easys.webtest.service.UserService;

@Controller
@RequestMapping("/login.do")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login2(HttpServletRequest request,
			HttpServletResponse response, LoginInfo loginInfo) {
		User user = getUserService().login(loginInfo.getUsername(),
				loginInfo.getPassword());

		String viewName = "";
		if (null == user) {
			viewName = "login";
		} else {
			viewName = "homepage";
		}

		ModelAndView mav = new ModelAndView(viewName);

		return mav;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
