package com.example.demokeycloakspring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ApplicationController {
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value = "/protected", method = RequestMethod.GET)
	public String handleProtected(Model model) {
        configCommonAttributes(model);
        return "protected";
    }
	
	@RequestMapping(value = "/protected/premium", method = RequestMethod.GET)
    public String handlePremium(Model model) {
        configCommonAttributes(model);
        return "premium";
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String handleLogoutt() throws ServletException {
        request.logout();
        return "redirect:/";
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleHome(Model model) throws ServletException {
        configCommonAttributes(model);
        return "home";
    }
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String handleAccessDenied() throws ServletException {
        return "access-denied";
    }
	
	private void configCommonAttributes(Model model) {
        model.addAttribute("identity", new Identity(getKeycloakSecurityContext()));
    }
	
	private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
    }

}
