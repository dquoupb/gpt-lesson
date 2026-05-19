package gpt.lesson.chatgptlesson.notification.sender;

import gpt.lesson.chatgptlesson.notification.NotificationChannel;
import gpt.lesson.chatgptlesson.notification.NotificationMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class EmailNotificationSender implements NotificationSender {

    private final String host;
    private final int port;
    private final String from;

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.EMAIL;
    }

    @Override
    public void send(NotificationMessage message) {
        log.info("[EMAIL NOTIFICATION]");
        log.info("host      = {}", host);
        log.info("port      = {}", port);
        log.info("from      = {}", from);
        log.info("to  = {}", message.getReceiver());
        log.info("title     = {}", message.getTitle());
        log.info("content   = {}", message.getContent());
    }
}
