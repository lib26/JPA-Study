package study.homework.week1.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.homework.week1.application.dto.RegisterMemberRequestDto;
import study.homework.week1.application.dto.RegisterMemberResponseDto;
import study.homework.week1.domain.Member;
import study.homework.week1.domain.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //@Transactional
    public RegisterMemberResponseDto registerMember(RegisterMemberRequestDto dto) {

        //Member member = dto.toEntity(); 이렇게도 가능
        Member member = new Member(dto.getNickName(), dto.getAge());
        memberRepository.save(member); //JPA에서는 이렇게 저장해야 ID가 생성된다.
        Member saveMember = memberRepository.findMemberById(member.getId());
        return new RegisterMemberResponseDto(saveMember.getId());
    }
}
