package hi.hi_spring.service;

import hi.hi_spring.domain.Member;
import hi.hi_spring.repository.MemberRepository;
import hi.hi_spring.repository.MemotyMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired  MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


//    @AfterEach
//    public void afterEach() {
//        // 검사후 초기화
//        memberRepository.clearStore();
//    }
    @Test
    void join() {
        // given: 테스트를 위한 초기 조건을 설정.
        Member member = new Member();
        member.setName("hello2");

        // when: 테스트하고자 하는 동작을 수행
        Long saveId = memberService.join(member);

        // then: 테스트 결과를 검증
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    public void duplicateMember() {
        // given: 테스트를 위한 초기 조건을 설정.
        Member member1 = new Member();
        member1.setName("hello");

        Member member2 = new Member();
        member2.setName("hello");

        // when: 테스트하고자 하는 동작을 수행
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}