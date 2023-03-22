package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id") // 이렇게 테이블 컬럼 값 설정을 안해주면, 관례상 id라고 자동으로 컬럼이름이 매핑된다.
    private Long id;

    private String name;

    @Embedded // 내장 타입이 내장되었다는 의미
    private Address address;

    @OneToMany(mappedBy = "member") // Member 테이블 입장에서 Orders 테이블은 일대다 관계이다.
    private List<Order> orders = new ArrayList<>();
}