package org_khmeracademy.app.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org_khmeracademy.app.service.Userservice;

@Controller
public class MainController {
	@Autowired
	Userservice userservice;
	
	@RequestMapping("/")
	public String show(ModelMap map){
		map.put("URL", "/");
		return "/admin/dashboard";
	}
	
	@RequestMapping("/user")
	public String User(ModelMap map){
		map.put("URL", "/user");
		map.put("KEY",userservice.Showuser());
		return"/admin/userlist";
	}
	
	@RequestMapping("/usercu")
	public String showuser(Model model){
		model.addAttribute("KEY",userservice.Showuser());
		model.addAttribute("URL", "/usercu");
		return"/admin/usercu";
	
	}
	
	@RequestMapping(value="/add-user", method=RequestMethod.POST)
	public String Input(@RequestParam int id,@RequestParam String name,@RequestParam String email, Model model){
		userservice.addUser(new org_khmeracademy.app.model.User(id, name, email));
		model.addAttribute("KEY",userservice.Showuser());
		model.addAttribute("URL", "/add-user");
		return "redirect:/usercu";
		
	}
	
	@RequestMapping(value="/remove-student")
	public String Remove(@RequestParam int id,Model model){
		userservice.RemovUser(id);
		model.addAttribute("KEY",userservice.Showuser());
		return "redirect:usercu";
	}
	
	@RequestMapping("/role-list")
	public String view(Model model){
		model.addAttribute("URL", "/role-list");
		return "/admin/user-role";
	}
	
	@RequestMapping("/rolecu")
	public String rolecu(Model model){
		model.addAttribute("URL","/rolecu");
		return "/admin/rolecu";
	}
}
