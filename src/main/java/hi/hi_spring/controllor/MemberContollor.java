package hi.hi_spring.controllor;

import hi.hi_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberContollor {

    private final MemberService memberService;

    @Autowired
    public MemberContollor(final MemberService memberService) {
        this.memberService = memberService;
    }
}
