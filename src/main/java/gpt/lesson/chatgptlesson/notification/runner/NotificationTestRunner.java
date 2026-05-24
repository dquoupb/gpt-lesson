package gpt.lesson.chatgptlesson.notification.runner;

import gpt.lesson.chatgptlesson.notification.domain.NotificationChannel;
import gpt.lesson.chatgptlesson.notification.domain.NotificationMessage;
import gpt.lesson.chatgptlesson.notification.sender.NotificationClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 이 샘플을 실제로 수행하는 곳
 */
@Component
public class NotificationTestRunner implements CommandLineRunner {
    private final NotificationClient notificationClient;

    public NotificationTestRunner(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    @Override
    public void run(String... args) throws Exception {
        NotificationMessage message = new NotificationMessage(
                NotificationChannel.CONSOLE,
                "테스트 알림",
                "AutoConfiguration으로 등록된 NotificationClient 테스트입니다.",
                "tester"
        );
        notificationClient.send(message);
    }
}
