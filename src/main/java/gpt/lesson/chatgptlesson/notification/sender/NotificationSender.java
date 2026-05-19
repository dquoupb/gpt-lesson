package gpt.lesson.chatgptlesson.notification.sender;

import gpt.lesson.chatgptlesson.notification.NotificationChannel;
import gpt.lesson.chatgptlesson.notification.NotificationMessage;

/**
 * getChannel()을 통해 각 구현체가 자신이 어떤 채널을 담당하는지 알려줌...!
 */
public interface NotificationSender {

    NotificationChannel getChannel();

    void send(NotificationMessage message);
}
