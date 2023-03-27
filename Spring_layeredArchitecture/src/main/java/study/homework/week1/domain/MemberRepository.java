package study.homework.week1.domain;


public interface MemberRepository {
    void save(Member member);
    Member findMemberById(String memberId);
}
