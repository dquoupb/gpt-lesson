package gpt.lesson.chatgptlesson.day6.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public TestType aTestType() {
        return new ATestType();
    }

    @Bean
    public TestType bTestType() {
        return new BTestType();
    }
}
