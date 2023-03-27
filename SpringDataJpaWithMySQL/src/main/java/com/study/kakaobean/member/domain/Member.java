package com.study.kakaobean.member.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 상속받은 객체에서만 쓸 수 있다. JPA 특성상 엔티티는
@Entity
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private BaseStatus status;

    private String username;
    private String password;

    public Member(BaseStatus status, String username, String password) {
        this.status = status;
        this.username = username;
        this.password = password;
    }
}
