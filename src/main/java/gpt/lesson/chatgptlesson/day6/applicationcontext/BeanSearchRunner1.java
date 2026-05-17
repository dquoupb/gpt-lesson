package gpt.lesson.chatgptlesson.day6.applicationcontext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ① ApplicationContext란? ApplicationContext를 직접 사용하는 방식
 *
 * 해당 예제는 applicationContext의 존재에 대해 알아보기 위한 예제이다.
 * 이렇게 직접 쓰지는 않는다.
 *
 * 전체 실행 순서를 더 자세히 쓰면
 * 1. Spring boot main 실행
 * 2. SpringApplication.run()실행
 * 3. ApplicationContext 생성
 *    → ★☆★☆요기서 자동 생성되어있음!!★☆★☆
 * 4. Component scan 수행
 * 5. @Service가 붙은 TestService를 Bean 대상으로 인식
 * 6. @Component가 붙은 BeanSearchRunner를 Bean 대상으로 인식
 * 7. TestService Bean 생성
 * 8. BeanSearchRunner Bean 생성시 생성자 파라미터로 ApplicationContext 자동 주입
 *    → 여기서 스프링의 판단 과정:
 *      BeanSearchRunner를 만들려면 ApplicationContext가 필요하다고 판단.
 *      근데 ApplicationContext는 내가(스프링) 이미 가지고 있는 컨테이너 객체이다.
 *      그럼 이걸 생성자에 넣으면 되겠군!
 * 9. Spring boot가 CommandLineRunner Bean을 찾아 run() 자동 실행
 * 10. run() 안에서 applicationcContext.getBean(TestService.class)실행
 * 11. 컨테이너에서 TestService Bean조회
 * 12. testService.print() 실행
 */
@Component
public class BeanSearchRunner1 implements CommandLineRunner {

    private final ApplicationContext applicationContext;

    public BeanSearchRunner1(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(String... args) {
        AppContextTestService appContextTestService = (AppContextTestService) applicationContext.getBean("appContextTestService");

        appContextTestService.print();
    }
}
