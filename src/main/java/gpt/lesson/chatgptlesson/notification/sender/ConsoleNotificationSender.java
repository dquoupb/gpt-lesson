package gpt.lesson.chatgptlesson.notification.sender;

import gpt.lesson.chatgptlesson.notification.NotificationChannel;
import gpt.lesson.chatgptlesson.notification.NotificationMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleNotificationSender implements NotificationSender {

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.CONSOLE;
    }

    @Override
    public void send(NotificationMessage message) {
        log.info("[CONSOLE NOTIFICATION]");
        log.info("title     = {}", message.getTitle());
        log.info("content   = {}", message.getContent());
        log.info("receiver  = {}", message.getReceiver());
    }
}
