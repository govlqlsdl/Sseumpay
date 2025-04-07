package com.kobi.sseumpay.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/login-view")
    public String loginView() {
        return "user/login";  // templates/user/login.html
    }
	
	 // 회원가입 화면
    @GetMapping("/user/join-view")
    public String joinView() {
        return "user/join";
    }
}
