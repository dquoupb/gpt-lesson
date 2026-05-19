package gpt.lesson.chatgptlesson.notification.sender;

import gpt.lesson.chatgptlesson.notification.NotificationChannel;
import gpt.lesson.chatgptlesson.notification.NotificationMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SlackNotificationSender implements NotificationSender {

    private final String webhookUrl;

    public SlackNotificationSender(String webhookUrl) {
        this.webhookUrl = webhookUrl;
    }

    @Override
    public NotificationChannel getChannel() {
        return NotificationChannel.SLACK;
    }

    @Override
    public void send(NotificationMessage message) {
        log.info("[SLACK NOTIFICATION]");
        log.info("webhookUrl  = {}", webhookUrl);
        log.info("title       = {}", message.getTitle());
        log.info("content     = {}", message.getContent());

    }
}
