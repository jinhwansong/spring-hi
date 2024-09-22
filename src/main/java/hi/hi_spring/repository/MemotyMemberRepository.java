package hi.hi_spring.repository;

import hi.hi_spring.domain.Member;
import org.springframework.stereotype.Repository;

import javax.lang.model.type.ArrayType;
import java.util.*;

public class MemotyMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null값 허용
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // store에서 데이터를 찾고 있으면 반환 없으면 any반환
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    // 삭제 메소드
    public void clearStore(){
        store.clear();
    }
}
