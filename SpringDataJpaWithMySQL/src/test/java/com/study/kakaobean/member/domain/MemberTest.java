package com.study.kakaobean.member.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import static com.study.kakaobean.member.domain.BaseStatus.ACTIVE;

@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    EntityManager em;

    @Test
    @Rollback(value = false)
    void test(){
        // given
        Member member = new Member(ACTIVE, "dladlsqja", "password");
        em.persist(member);

        // when
        // em.flush();
        // em.clear();
        Member findMember = em.find(Member.class, member.getId());

        // then
        Assertions.assertThat(member).isSameAs(findMember);
    
    }


}