package gpt.lesson.chatgptlesson.notification.runner;

import gpt.lesson.chatgptlesson.notification.sender.NotificationClient;
import gpt.lesson.chatgptlesson.notification.sender.NotificationSender;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 이전의 NotificationTestRunner는 빈으로 생성되어있지 않으면 바로 에러가 났음
 * 그래서 여러가지 상태(application에 설정 값이 아예 존재 하지 않아서 빈 생성이 되지 않는 경우)에서
 * 제대로 동작하는지 확인할 수 있느 Runner를 새로 만들었음
 *
 */
@Component
public class BeanCheckRunner implements ApplicationRunner {

    private final ApplicationContext applicationContext;

    public BeanCheckRunner(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) {
        Map<String, NotificationSender> senderBeans =
                applicationContext.getBeansOfType(NotificationSender.class);

        Map<String, NotificationClient> clientBeans =
                applicationContext.getBeansOfType(NotificationClient.class);

        System.out.println("====== NotificationSender Beans ======");
        senderBeans.forEach((name, bean) ->
                System.out.println("name = " + name + ", type = " + bean.getClass().getSimpleName())
        );

        System.out.println("====== NotificationClient Beans ======");
        clientBeans.forEach((name, bean) ->
                System.out.println("name = " + name + ", type = " + bean.getClass().getSimpleName())
        );
    }
}
