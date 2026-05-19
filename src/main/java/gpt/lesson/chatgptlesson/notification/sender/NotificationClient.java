package gpt.lesson.chatgptlesson.notification.sender;

import gpt.lesson.chatgptlesson.notification.NotificationChannel;
import gpt.lesson.chatgptlesson.notification.NotificationMessage;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 서비스가 직접 사용할 객체임
 */
public class NotificationClient {
    private final Map<NotificationChannel, NotificationSender> senderMap;
    private final NotificationChannel defaultChannel;

    public NotificationClient(List<NotificationSender> senders,
                              NotificationChannel defaultChannel) {
        if(senders == null || senders.isEmpty()) {
            throw new IllegalStateException("등록된 NotificationSender가 없습니다.");
        }

        this.senderMap = senders.stream()
                .collect(Collectors.toMap(
                        NotificationSender::getChannel,
                        Function.identity(),
                        (existing, replacement) -> {
                            throw new IllegalStateException("중복된 NotificationSender 채널이 있습니다. channel = " + existing.getChannel());
                        }, () -> new EnumMap<>(NotificationChannel.class)
                ));
        this.defaultChannel = defaultChannel;
    }

    public void send(NotificationMessage message) {
        NotificationChannel targetChannel = resolveChannel(message);

        NotificationSender sender = senderMap.get(targetChannel);

        if(sender == null) {
            throw new IllegalArgumentException(
                    "사용가능한 NotificationSender가 없습니다. channel = "+targetChannel
            );
        }
        sender.send(message);
    }

    private NotificationChannel resolveChannel(NotificationMessage message) {
        if(message.getChannel() != null){
            return message.getChannel();
        }
        return defaultChannel;
    }
}
