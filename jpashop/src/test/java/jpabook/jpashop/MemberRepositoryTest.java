package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
// ㄴ@SpringBootTest를 하려면 javax가 아닌 springframework가 제공하는 @Transactional import하기

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) // junit한테 스프링과 관련된 테스트를 할 것이라고 알려주는 역할
@SpringBootTest // 스프링 테스트
public class MemberRepositoryTest {

    @Autowired // DI
    MemberRepository memberRepository;

    @Test
    @Transactional // test 코드에 @Transactional가 있으면 테스트가 끝나고 롤백 시킨다. 즉, 테스트 성공후 h2에서 확인해도 데이터가 보이지 않음
    @Rollback(false) // 위의 사항을 무시
    public void testMember() {

        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        assertThat(findMember.getId()).isEqualTo(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        assertThat(findMember).isEqualTo(member); //JPA 엔티티 동일성 보장
        System.out.println("findMember==member"+(findMember==member));
        // ㄴtrue 왜?  같은 @Transactional 안에서는 영속성 컨텍스트가 같기 때문에 식별자가 같으면 같은 엔티티로 판단한다
        // 1차 캐시에 있어서? select문도 안나오고 바로 insert 나온것이다? 좀 더 알아보자
    }
}