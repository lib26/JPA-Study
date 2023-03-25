package jpabook.jpashop.service;

import static org.junit.Assert.*;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

// junit4

@RunWith(SpringRunner.class) // 스프링과 같이 테스트 하겠다는 것을 junit에게 명시
@SpringBootTest // spring 컨테이너 안에서 test를 돌리겠다는 뜻. 이 에노테이션이 없으면 밑에 Autowired가 실행되지 않는다.
@Transactional // 테스트에 @Transactional가 있으면 DB 트랜잭션 롤백.
public class MemberServiceTest {

    @Autowired // 필드주입
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    //@Rollback(value = false) // 실제로 DB에 insert 쿼리가 나가서 데이터가 저장된다.
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("kim");
        //When
        Long saveId = memberService.join(member);
        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    // 예외가 던져지면 받아서 catch한다. catch 되여야 test가 정상임을 뜻한다.
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");
        //When
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다.
        //Then
        fail("예외가 발생해야 한다."); // 만약 예외가 발생하지 않고 이 라인까지 오게되면 test가 실패되었다고 알린다.
    }
}