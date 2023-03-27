package com.study.kakaobean.member.application;

import com.study.kakaobean.member.application.dto.RegisterMemberRequestDto;
import com.study.kakaobean.member.application.dto.RegisterMemberResponseDto;
import com.study.kakaobean.member.domain.BaseStatus;
import com.study.kakaobean.member.domain.Member;
import com.study.kakaobean.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public RegisterMemberResponseDto registerMember(RegisterMemberRequestDto dto) {

        //Member member = dto.toEntity(); 이렇게도 가능
        Member member = new Member(BaseStatus.ACTIVE, dto.getUsername(), dto.getPassword());
        memberRepository.save(member); //JPA에서는 이렇게 저장해야 ID가 생성된다.
        return new RegisterMemberResponseDto(member.getId());
    }
}
