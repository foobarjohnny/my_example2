package ilife.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	@RequestMapping(value = "/access_denied")
	public String accessDenied() {
		return "error/403";
	}

	@RequestMapping(value = "/resource_not_found")
	public String resourceNotFound() {
		return "error/404";
	}

	@RequestMapping("/service_not_available")
	public String serverError() {
		return "error/500";
	}

}
