/*
 * package com.example.demo.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.validation.BindingResult; import
 * org.springframework.web.bind.annotation.ModelAttribute; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * com.example.demo.autservice.SecurityService; import
 * com.example.demo.autservice.UserService; import com.example.demo.modal.User;
 * import com.example.demo.userValidator.UserValidator;
 * 
 * @Controller public class UserController {
 * 
 * @Autowired private UserService userService;
 * 
 * @Autowired private SecurityService securityService;
 * 
 * @Autowired private UserValidator userValidator;
 * 
 * @RequestMapping(value = "/registration", method = RequestMethod.GET) public
 * String registration(Model model) { model.addAttribute("userForm", new
 * User());
 * 
 * return "User/registration"; }
 * 
 * @RequestMapping(value = "/registration", method = RequestMethod.POST) public
 * String registration(@ModelAttribute("userForm") User userForm, BindingResult
 * bindingResult, Model model) { userValidator.validate(userForm,
 * bindingResult);
 * 
 * if (bindingResult.hasErrors()) { return "User/registration"; }
 * 
 * userService.save(userForm);
 * 
 * securityService.autologin(userForm.getUsername(),
 * userForm.getPasswordConfirm());
 * 
 * return "redirect:/User/welcome"; }
 * 
 * @RequestMapping(value = "/login", method = RequestMethod.GET) public String
 * login(Model model, String error, String logout) { if (error != null)
 * model.addAttribute("error", "Your username and password are invalid.");
 * 
 * if (logout != null) model.addAttribute("message",
 * "You have logged out successfully.");
 * 
 * return "User/login"; }
 * 
 * @RequestMapping(value = { "/","/welcome"}, method = RequestMethod.GET) public
 * String welcome(Model model) { return "User/welcome"; }
 * 
 * }
 */