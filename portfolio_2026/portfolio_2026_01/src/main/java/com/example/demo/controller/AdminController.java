package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@Controller
public class AdminController {

	private final UserService userService;

	public AdminController(UserService userService) {
		this.userService = userService;
	}

	// ログインページ
	@GetMapping("/portfolio_adminLogin")
	public String adminLogin() {
		return "admin/login";
	}

	// ログイン検証
	@PostMapping("/portfolio_adminLogin")
	public String loginRequest(@RequestParam("email") String email,
	        @RequestParam("password") String password,
	        Model model) {

		try {
			UserEntity admin = userService.findAdminByEmail(email);

			// パスワード比較
			if (!admin.getPassword().equals(password)) {
				model.addAttribute("error", "メール又はパスワードが間違いました。");
				return "admin/login";
			}

			// ログイン成功 → 最後のログイン時間アップデート
			userService.updateLastLogin(admin);

			return "redirect:/admin/dashboard";

		} catch (Exception e) {
			model.addAttribute("error", "メール又はパスワードが間違いました。");
			return "admin/login";
		}
	}
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
	    return "admin/dashboard";
	}

}
