package hi.hi_spring.repository;

import hi.hi_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // 맴버를 저장
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
