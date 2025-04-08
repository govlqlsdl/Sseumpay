package com.kobi.sseumpay.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.kobi.sseumpay.user.domain.User;
import com.kobi.sseumpay.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 처리
    @PostMapping("/join")
    public Map<String, String> join(@RequestParam String loginId,
                                    @RequestParam String password,
                                    @RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam String birthDate) {
        Map<String, String> resultMap = new HashMap<>();
        if (userService.addUser(loginId, password, name, email, birthDate)) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }
        return resultMap;
    }

    // 아이디 중복 체크
    @GetMapping("/duplicate-id")
    public Map<String, Boolean> isDuplicateId(@RequestParam String loginId) {
        Map<String, Boolean> resultMap = new HashMap<>();
        resultMap.put("isDuplicate", userService.isDuplicateId(loginId));
        return resultMap;
    }

    // 로그인 처리
    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String loginId,
                                     @RequestParam String password,
                                     HttpSession session) {
        Map<String, String> resultMap = new HashMap<>();
        User user = userService.getUser(loginId, password);

        if (user != null) {
            // 세션 저장
            session.setAttribute("userId", user.getId());
            session.setAttribute("userLoginId", user.getLoginId());
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }
        return resultMap;
    }
}
