package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Transactional : 스프링이 제공하는 Transactional을 이용하자.
 * readOny를 써서 조회할 때 성능 최적화를 하자
 * JPA의 모든 데이터 변경이나 로직은 가급적 트렉젝션 안에서 실행되어야한다.
 * 클레스 레벨에 에노테이션을 달면 모든 메서드에 다 트렌젝션이 적용된다.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // 생성자 DI. 그중에서도 final이 붙은 필드 값을 주입해준다
public class MemberService {

     private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    @Transactional //변경
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    // 같은 회원 이름이 있는지 검증
    // 하지만 어떠한 두명의 유저가 동시에 호출하게되면 둘 다 통과하는 경우가 발생할 수 있다.
    // 따라서 DB에 name 컬럼을 unique key로 등록하는 최후의 검증 절차를 추가할 필요가 있다.
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
