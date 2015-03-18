package frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import frontend.service.UserService;

@Controller
@RequestMapping(value = "User")
public class UserController {
	@Autowired
	UserService userService;
	
}
