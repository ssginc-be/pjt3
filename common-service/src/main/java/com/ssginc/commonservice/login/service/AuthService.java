package com.ssginc.commonservice.login.service;

import com.ssginc.commonservice.login.dto.LoginRequestDto;
import com.ssginc.commonservice.login.entity.Member;
import com.ssginc.commonservice.login.repository.MemberRepository;
import com.ssginc.commonservice.util.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public String login(LoginRequestDto request) {
        Optional<Member> memberOpt = memberRepository.findByEmail(request.getEmail());

        if (memberOpt.isEmpty()) {
            throw new RuntimeException("사용자를 찾을 수 없습니다.");
        }

        Member member = memberOpt.get();
        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return jwtProvider.createToken(member.getEmail(), member.getName(), member.getRole().name());
    }

}
