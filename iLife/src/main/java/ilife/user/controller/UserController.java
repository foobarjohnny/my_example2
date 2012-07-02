package ilife.user.controller;

import ilife.user.model.User;
import ilife.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/account")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = { GET, POST })
	public String registerUser(User user) {
		if (user == null) {
			return "user/signup";
		}
		boolean succeed = userService.registerNewUser(user);
		return succeed ? "/user/signup" : "";
	}

	@RequestMapping("/user/activate/{activationCode}")
	public String activateUser(
			@PathVariable("activationCode") String activationCode) {

		return "";
	}
	
	
	
	
}
