package gpt.lesson.chatgptlesson.notification.config;

import gpt.lesson.chatgptlesson.notification.sender.NotificationClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ConditionalOnMissingBean 설정 때문에 해당 클래스를 등록하면 여기서 만들어진 bean이 등록된다!
 */
//@Configuration
//public class MyNotificationConfig {
//
//    @Bean
//    public NotificationClient notificationClient() {
//        return new MyCustomNotificationClient();
//    }
//}
