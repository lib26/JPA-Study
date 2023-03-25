package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // 스프링 빈 자동 등록
@RequiredArgsConstructor // 생성자 DI. 그중에서도 final이 붙은 필드 값을 주입해준다
public class MemberRepository {

    // @PersistenceContext는 필드에서 엔티티 매니저 Injection을 해준다.
    // 하지만 Spring Data JPA에서 엔티티 매니저까지 @RequiredArgsConstructor로 생성자 주입을 할 수있게 기능을 제공해준다
    private final EntityManager em;

    public void save(Member member) {
        // 엔티티 매니저를 사용해 회원 엔티티 객체를 영속성 컨텍스트에 저장한다.
        // 나중에 transaction commit이 되는 순간 DB에 반영. 즉, DB에 insert query가 날라감
        em.persist(member);
        // persist가 실행되면 역속성 컨텍스트에는 Key Value 형태로 저장되는 것 같다.
        // Key에는 @id @GeneratedValue로 생성된 PK값이 들어간다.
        // 동시에 member 엔티티 객체 변수 id 필드값에도 생성된 PK값을 할당한다
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id); // find -> 단건 조회. 타입, PK를 순서대로 넣어주면 된다
    }

    public List<Member> findAll() {
        // jpql은 SQL과 기능적으로는 같지만 문법적으로 약간 다르다.
        // SQL은 테이블 대상이지만 jpql은 엔티티 객체 대상이다.
        return em.createQuery("select m from Member m", Member.class) // jpql, 반환타입
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name) // 파라미터 바인딩
                .getResultList();
    }
}
