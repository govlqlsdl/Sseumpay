package com.kobi.sseumpay.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kobi.sseumpay.user.domain.User;

@Mapper
public interface UserRepository {

    // 회원가입 시 사용자 정보 DB에 삽입
    int insertUser(@Param("loginId") String loginId,
                   @Param("password") String password,
                   @Param("name") String name,
                   @Param("email") String email,
                   @Param("birthDate") String birthDate);

    // 아이디 중복 확인 (개수 조회)
    int selectCountByLoginId(@Param("loginId") String loginId);

    // 로그인 시 사용자 정보 조회
    User selectUser(@Param("loginId") String loginId,
                    @Param("password") String password);

    // 사용자 ID로 사용자 정보 조회 (세션 저장 등)
    User selectUserById(@Param("id") int id);
}