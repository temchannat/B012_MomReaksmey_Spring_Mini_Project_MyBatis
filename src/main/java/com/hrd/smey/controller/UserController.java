//package com.hrd.smey.controller;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//
//import com.hrd.smey.model.User;
//import com.hrd.smey.service.UserService;
//
//@Controller
//public class UserController {
//
//	private UserService userservice;
//	List<User> users;
//	@Autowired
//	public UserController(UserService userservice) {
//		this.userservice=userservice;
//	}
//	@RequestMapping(value = { "/user", "/" })
//	public String homepage(ModelMap model) {
//		users = userservice.listdata();
//		model.addAttribute("user", users);
//
//		return "/admin/dashboard";
//
//	}
//
//	@RequestMapping(value = "/user/aid")
//	public String detailpage(ModelMap model, @RequestParam("id") Integer id) {
//
//		User user = userservice.findOne(id);
//		model.addAttribute("user", user);
//
//		return "/admin/userdetail";
//	}
//	@RequestMapping(value = "/user/remove")
//	public String remove(@RequestParam("id") Integer id) {
//
//		if (userservice.remove(id)) {
//			System.out.println("success");
//		}
//		return "redirect:/user";
//	}
//	@RequestMapping(value = "/user/add")
//	public String add(ModelMap model) {
//
//		model.addAttribute("user", new User());
//		model.addAttribute("addStatus", true);
//		return "/admin/user-cu";
//	}
//	@RequestMapping(value = "/user/userrole")
//	public String roledata(ModelMap model) {
//		model.addAttribute("user", new User());
//		return "/admin/userrole";
//	}
//	@RequestMapping("/user/userroledata")
//	public String listrole(@ModelAttribute User user, ModelMap model){
//		users.add(user);
//		model.addAttribute("user", users);
//		return "/admin/userroledata";
//	}
//	
//	@RequestMapping(value = "/user/save", method=RequestMethod.POST)
//	public String save(@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model) {
//		if (result.hasErrors()) {
//			model.addAttribute("user", user);
//		
//			model.addAttribute("addStatus", true);
//			return "/admin/user-cu";
//		}
//		try {
//			byte[] bytes = file.getBytes();
//            Path path = Paths.get("./src/main/resources/static/myFile/" + file.getOriginalFilename());
//            Files.write(path, bytes);
//            user.setThumnail("/myFile/" + file.getOriginalFilename());
//			
//
//		}catch (IOException e) {
//	            e.printStackTrace();
//	    }
//		users.add(user);
//		System.out.println("hi");
//		System.out.println(user);
//		return "redirect:/user";
//	}
//
//	@PostMapping(value = "/user/update")
//	public String update(@ModelAttribute("user") User user, BindingResult result) {
//		if (result.hasErrors()) {
//			return "redirect:/user/add";
//		}
//		if (userservice.update(user)) {
//			System.out.println("success!");
//		}
//		return "redirect:/user";
//	}
//	@GetMapping(value = "/user/edit")
//	public String edit(ModelMap model, @RequestParam("id") Integer id) {
//		User user = userservice.findOne(id);
//		model.addAttribute("user", user);
//		model.addAttribute("addStatus", false);
//		return "/admin/user-cu";
//	}
//	@RequestMapping("/user/userlist")
//	public String list(ModelMap model){
//		users = userservice.listdata();
//		model.addAttribute("user", users);
//		return "/admin/user-list";
//	}
//
//
//}
