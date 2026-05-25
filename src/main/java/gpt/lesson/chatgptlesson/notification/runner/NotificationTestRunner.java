package gpt.lesson.chatgptlesson.notification.runner;

import gpt.lesson.chatgptlesson.notification.domain.NotificationChannel;
import gpt.lesson.chatgptlesson.notification.domain.NotificationMessage;
import gpt.lesson.chatgptlesson.notification.sender.NotificationClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 이 샘플을 실제로 수행하는 곳
 *
 * ObjectProvider: 필요할 때 꺼내쓰기 위한 지연 조회 도구
 * 그래서 빈이 없어도 바로 죽지 않는다
 * 따라서 아래 예시대로면 NotificationAutoConfiguration의 notificationClient를 주석처리하고 돌리면 빈이 만들어지지 않았기 때문에
 * Notification client not found 가 출력된다. 하지만 애플리케이션이 꺼지지는 않는다!!!!
 */
@Component
public class NotificationTestRunner implements CommandLineRunner {
    private final NotificationClient notificationClient;

    public NotificationTestRunner(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    @Override
    public void run(String... args) throws Exception {
        if(notificationClient == null) {
            System.out.println("Notification client not found");
            return;
        }

        NotificationMessage message = new NotificationMessage(
                NotificationChannel.CONSOLE,
                "테스트 알림",
                "AutoConfiguration으로 등록된 NotificationClient 테스트입니다.",
                "tester"
        );
        notificationClient.send(message);
    }
}
