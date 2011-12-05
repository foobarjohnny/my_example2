package ilife.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	@RequestMapping(value = "/access_denied")
	public String accessDenied() {
		return "error/403";
	}

}
