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
class springdatajpa {

    @Autowired
    MemberRepository memberRepository;

    @Test
    // @Transactional
    @Rollback(value = false)
    void test(){

        // given
        Member member = new Member(ACTIVE, "dladlsqja@naver.com", "password");
        memberRepository.save(member);

        // when
        Member findMember = memberRepository.findById(member.getId())
                .orElseThrow(()->new RuntimeException("예외 발생"));

        // then
        Assertions.assertThat(member).isSameAs(findMember);

    }

}