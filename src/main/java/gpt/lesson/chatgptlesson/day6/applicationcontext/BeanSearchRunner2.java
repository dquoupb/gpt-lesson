package gpt.lesson.chatgptlesson.day6.applicationcontext;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * ② ApplicationContext 직접사용 대신 ApplicationContext가 알아서 생성자 주입
 *
 * 이 방식이 더 좋은 이유는 의존 관게가 코드에 명확하게 드러나기 때문이다.
 * 생성자만 봐도 알 수 있다.
 *
 * 이게 DI 방식이다!
 *
 * ---------------------------------
 * 장점:
 * 의존관계가 명확하다
 * 테스트하기가 쉽다
 * 객체지향 설계에 가깝다
 * 코드가 단순하다
 *
 */
@Component
public class BeanSearchRunner2 implements CommandLineRunner {

    private final AppContextTestService appContextTestService;

    public BeanSearchRunner2(AppContextTestService appContextTestService) {
        this.appContextTestService = appContextTestService;
    }

    @Override
    public void run(String... args) {
        appContextTestService.print();
    }
}
