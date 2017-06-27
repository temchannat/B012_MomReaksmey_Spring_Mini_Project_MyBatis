package com.hrd.smey.controller.myBatis;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.hrd.smey.model.User;
import com.hrd.smey.service.UserService;

@Controller
public class myBatisController {
	List<User> ul=new ArrayList<>();
	private UserService userserivce;
	@Autowired
	public myBatisController(UserService userservice) {
		this.userserivce=userservice;
	}
	@RequestMapping("/user/select")
	public String findAll(ModelMap model, User user){
		
		model.addAttribute("user", userserivce.listdata());
		model.addAttribute("total", userserivce.listdata().size());
		model.addAttribute("male", userserivce.countmale());
		model.addAttribute("female", userserivce.countfemale());
		
		
		return "/admin/dashboard";
		
		
	}
	@RequestMapping("/user/userlist")
	public String list(ModelMap model){
		
		model.addAttribute("user", userserivce.listdata());
		return "/admin/user-list";
		
		
	}
	/**
	 * 
	 * map to form input
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/add")
	public String user_cu(ModelMap model){
		
		model.addAttribute("user", new User());
		model.addAttribute("addStatus", true);
		return "/admin/user-cu";
		
		
	}
	@RequestMapping("/user/userrole")
	public String userrole(ModelMap model){
		
		model.addAttribute("user", new User());
		model.addAttribute("addStatus", true);
		return "/admin/userrole";
		
		
	}
	/**
	 * save data from form to database
	 * @param user
	 * @param model
	 * @return
	 */
	@PostMapping("/user/save")
	public String userlist(@ModelAttribute User user, ModelMap model){
		
		model.addAttribute("user", userserivce.save(user));
		return "redirect:/user/select";
	
	}
	@GetMapping(value = "/user/edit")
	public String edit(ModelMap model, @RequestParam("user_hash") String user_hash) {
		User user=userserivce.findOne(user_hash);
		System.out.println("findOne User Hash" + user.getUser_hash());
		model.addAttribute("user", user);
		model.addAttribute("addStatus", false);
		return "/admin/user-cu";
	}
	@PostMapping(value = "/user/update")
	public String update(@ModelAttribute("user") User user) {
		System.out.println("user_hash "+ user.getUser_hash()  );
		if(userserivce.update(user)){
			System.out.println("updated!!");
		}
		return "redirect:/user/select";
	}
	@RequestMapping(value = "/user/remove")
	public String remove(@RequestParam String user_hash) {
//		int confirm=JOptionPane.showConfirmDialog(null, "Are You Sure", "Delete", JOptionPane.YES_NO_OPTION);
//		if(confirm==JOptionPane.YES_OPTION){
//			
//			userserivce.delete(user_hash);
//		}
		if(userserivce.delete(user_hash)){
			System.out.println("Success");
		}
		return "redirect:/user/select";
	}
	@RequestMapping(value = "/user/aid")
	public String detailpage(ModelMap model, @RequestParam("user_hash") String user_hash) {

		User user = userserivce.findOne(user_hash);
		model.addAttribute("user", user);

		return "/admin/userdetail";
	}
	

}
