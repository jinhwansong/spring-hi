package hi.hi_spring;

import hi.hi_spring.repository.JdbcTemplateUserRepository;
import hi.hi_spring.repository.MemberRepository;
import hi.hi_spring.repository.UserRepository;
import hi.hi_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new UserRepository(dataSource);
        return new JdbcTemplateUserRepository(dataSource);
    }
}
