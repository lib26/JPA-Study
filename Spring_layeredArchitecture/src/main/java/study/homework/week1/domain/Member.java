package study.homework.week1.domain;

import lombok.Getter;

import java.util.UUID;


@Getter
public class Member {

    private String id;
    private String nickName;
    private Integer age;

    public Member(String nickName, Integer age) {
        this.id = UUID.randomUUID().toString();
        this.nickName = nickName;
        this.age = age;
    }
}
