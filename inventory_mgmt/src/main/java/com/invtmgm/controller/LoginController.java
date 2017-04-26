package com.invtmgm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.invtmgm.beans.LoginBean;
import com.invtmgm.service.LoginService;
import com.invtmgm.utils.Utils;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String displayLogin(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(Model model,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		if (loginBean != null
				&& Utils.trimString(loginBean.getUsername()) != null
				&& Utils.trimString(loginBean.getPassword()) != null) {
			if (loginService.validateUser(loginBean.getUsername(),
					loginBean.getPassword())) {
				model.addAttribute("msg", loginBean.getUsername());
				return "agentMainPage";
			} else {
				model.addAttribute("error", "Invalid Details!");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter login credentials.");
			return "login";
		}
	}
}
