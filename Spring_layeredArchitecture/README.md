# Week1. Homework 

## 요구사항 정리

* 계층형 아키텍처, 롬복을 활용한다.
* 도메인 객체를 API에 노출하지 않는다. 요청 DTO, 응답 DTO 클래스를 모두 작성해야 한다.
* DTO란 data transfer object의 약어다.
* 트랜잭션을 사용하지는 않지만 트랜잭션 애노테이션을 적당한 위치에 붙이자.
* 애플리케이션 패키지는 __도메인 패키지__ 만 의존해야한다.
* 프레젠테이션 패키지는 __애플리케이션 패키지__ 만 의존해야한다.
* URL:/members, METHOD: POST 형식으로 요청하도록 구현하자.
* @Validated를 자유롭게 실습해볼 것.
* 요청 바디(JSON) 스펙은 다음과 같다.
* MemberRepository의 save 메서드를 1번, findMemberById 메서드를 1번 사용해야함.

```json
{
  "nickName" : "subin",
  "age" : 25
}
```

* 응답 바디(JSON) 스펙은 다음과 같다.

```json
{
  "id" : "f9220813-6253-4247-b5e2-57c5c270ed5b",
  "nickName" : "subin",
  "age" : 25
}
```

__week1 코드와 해당 프로젝트 테스트 코드를 참고하면 매우 쉬울 것 같습니다.__ 

