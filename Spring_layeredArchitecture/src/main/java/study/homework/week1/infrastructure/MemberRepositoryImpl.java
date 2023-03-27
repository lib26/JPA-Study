package study.homework.week1.infrastructure;

import org.springframework.stereotype.Repository;
import study.homework.week1.domain.Member;
import study.homework.week1.domain.MemberRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private Map<String, Member> map = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        map.put(member.getId(), member);
    }

    @Override
    public Member findMemberById(String memberId) {
        return map.get(memberId);
    }
}
