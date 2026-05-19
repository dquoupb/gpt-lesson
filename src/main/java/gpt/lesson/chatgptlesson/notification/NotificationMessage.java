package gpt.lesson.chatgptlesson.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 채널을 사용자가 선택할 수 있게,
 * 없으면(null) 기본 채널을 사용
 */
@AllArgsConstructor
@Getter
public class NotificationMessage {
    private final NotificationChannel channel;
    private final String title;
    private final String content;
    private final String receiver;
}
