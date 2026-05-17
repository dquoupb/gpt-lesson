package gpt.lesson.chatgptlesson.day6.practice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 1. ApplicationContext 생성
 * 2. 설정 클래스 탐색
 * 3. Component Scan 실행
 * 4. @Configuration, @Bean 처리
 * 5. @Component, @Service, @Repository, @Controller 등록
 * 6. BeanDefinition 생성
 * 7. Bean 인스턴스 생성
 * 8. 의존관계 주입
 * 9. 초기화 콜백 실행
 * 10. 애플리케이션 실행 준비 완료
 */
@Slf4j
@Component
@AllArgsConstructor
public class BeanSearchRunner4 implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    @Override
    public void run(String... args) throws Exception {
        TestType a = applicationContext.getBean("aTestType", TestType.class);
        TestType b = applicationContext.getBean("bTestType", TestType.class);

        log.info(a.name()); // A
        log.info(b.name()); // B

        Map<String, TestType> beans = applicationContext.getBeansOfType(TestType.class);
//        TestType bean = applicationContext.getBean(TestType.class);  // 하면 오류남. Bean이 두개 있는데 primary안 정해줬으니까

        beans.forEach((beanName, bean)->{
            log.info(beanName+"="+bean.name()); // aTestType=A, bTestType=B
        });
    }
}
