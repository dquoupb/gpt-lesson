package gpt.lesson.chatgptlesson.day6.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * BeanFactory의 흐름
 * 1. Spring Boot main 실행
 * 2. ApplicationContext 생성
 * 3. TestService Bean 생성
 * 4. BeanFactoryRunner Bean 생성
 * 5. BeanFactoryRunner 생성자에 BeanFactory 타입 객체 주입
 * 6. CommandLineRunner의 run() 자동 실행
 * 7. beanFactory.getBean(TestService.class) 실행
 * 8. TestService Bean 조회
 * 9. testService.print() 실행
 *
 * ApplicationContext를 직접 사용하는 예제랑 차이는 그냥 ApplicationContext냐 BeanFactory냐의 차이일뿐
 * ApplicationContext implements BeanFactory이기 때문에 BeanFactory로 받을 수 있다.
 * 근데 기능이 BeanFactory보다 ApplicationContext가 더 많다
 */
@Component
public class BeanFactoryRunner3 implements CommandLineRunner {

    private final BeanFactory beanFactory;

    public BeanFactoryRunner3(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void run(String... args) throws Exception {
        BeanFactoryTestService beanFactoryTestService = beanFactory.getBean(BeanFactoryTestService.class);

        beanFactoryTestService.print();
    }
}
