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

    // Member 테이블 입장에서 Orders 테이블은 일대다 관계이다.
    // Order 테이블에 있는 member 필드 값에 의해서 매핑 된다는 의미
    // 즉, 맴버와 주문 사이의 연관 관계 주인은 주문 테이블이 된다.
    // 근데 이런식으로 Member에 굳이 orders list가 있는건 약간 잘못된 설계임. 예제니까 넣는거임.
    // 이럴때는 관심사를 끊어내기 위해 order 테이블에서 단방향 매핑만 해주면 됨
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}