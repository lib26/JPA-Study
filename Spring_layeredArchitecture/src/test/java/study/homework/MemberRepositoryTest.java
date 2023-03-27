package study.homework;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.homework.week1.domain.Member;
import study.homework.week1.domain.MemberRepository;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void registerMemberTest(){

        //given
        Member member = new Member("nickName", 25);
        memberRepository.save(member);

        //when
        Member findMember = memberRepository.findMemberById(member.getId());

        //then
        Assertions.assertThat(member.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member.getNickName()).isEqualTo(findMember.getNickName());
    }
}
