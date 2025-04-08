package com.kobi.sseumpay.user.service;

import org.springframework.stereotype.Service;

import com.kobi.sseumpay.common.MD5HashingEncoder;
import com.kobi.sseumpay.user.domain.User;
import com.kobi.sseumpay.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 등록 (회원가입)
    public boolean addUser(String loginId, String password, String name, String email, String birthDate) {
        String encyptPassword = MD5HashingEncoder.encode(password);
        int count = userRepository.insertUser(loginId, encyptPassword, name, email, birthDate);
        return count == 1;
    }

    // 아이디 중복 여부 확인
    public boolean isDuplicateId(String loginId) {
        return userRepository.selectCountByLoginId(loginId) > 0;
    }

    // 로그인 시 사용자 조회
    public User getUser(String loginId, String password) {
        String encryptPassword = MD5HashingEncoder.encode(password);
        return userRepository.selectUser(loginId, encryptPassword);
    }

    // ID로 사용자 정보 조회
    public User getUserById(int id) {
        return userRepository.selectUserById(id);
    }
}