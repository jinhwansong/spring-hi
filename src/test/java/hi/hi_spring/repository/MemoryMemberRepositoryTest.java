package hi.hi_spring.repository;

import hi.hi_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemotyMemberRepository repository = new MemotyMemberRepository();

    // 테스트 끝날때마다 초기화
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        Member memberName = new Member();
        memberName.setName("spring11");
        repository.save(memberName);

        Member memberName2 = new Member();
        memberName2.setName("spring12");
        repository.save(memberName2);

        Member res = repository.findByName("spring11").get();
        assertThat(res).isEqualTo(memberName);
    }


}
