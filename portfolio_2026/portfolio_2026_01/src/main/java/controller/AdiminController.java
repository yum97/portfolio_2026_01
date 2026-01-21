package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdiminController {

	@GetMapping("/portfolio_adminLogin")
	public String adminLogin() {
		return "admin/login";
	}
}
