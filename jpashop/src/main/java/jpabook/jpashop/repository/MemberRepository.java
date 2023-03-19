package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository // 스프링 빈 자동 등록
public class MemberRepository {

    @PersistenceContext // 매니저 자동주입
    EntityManager em;

    public Long save(Member member) {
        em.persist(member); // 엔티티 매니저를 사용해 회원 엔티티를 영속성 컨텍스트에 저장한다는 의미
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}