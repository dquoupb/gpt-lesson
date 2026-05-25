package gpt.lesson.chatgptlesson.notification.config;

import gpt.lesson.chatgptlesson.notification.sender.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@AutoConfiguration
@ConditionalOnClass(NotificationSender.class)
@EnableConfigurationProperties(NotificationProperties.class)
//@ConditionalOnProperty( // notification.enabled: true 여야 자동설정이 동작한다. 근데 지금 다 주석했으니 무조건 자동설정.
//        prefix = "notification",
//        name = "enabled",
//        havingValue = "true"
//)
public class NotificationAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name="consoleNotificationSender")
    @ConditionalOnProperty( // console을 기본 활성화 하겠다. notification.console.enabled 설정이 없으면 기본적으로 true로 보겠다.
            prefix = "notification.console",
            name = "enabled",
            havingValue = "true",
            matchIfMissing = false // = 설정값이 없으면 조건 불만족으로 처리한다. 라는 의미
    )
    public NotificationSender consoleNotificationSender() {
        return new ConsoleNotificationSender();
    }

    @Bean
    @ConditionalOnMissingBean(name="emailNotificationSender")
    @ConditionalOnProperty( // notification.email.enabled: true 여야 등록된다.
            prefix = "notification.email",
            name = "host",
            matchIfMissing = false
    )
    public NotificationSender emailNotificationSender(NotificationProperties properties) {
        NotificationProperties.Email email = properties.getEmail();

        return new EmailNotificationSender(
                email.getHost(),
                email.getPort(),
                email.getFrom()
        );
    }

    @Bean
    @ConditionalOnMissingBean(name="slackNotificationSender")
    @ConditionalOnProperty( // notification.slack.enabled: true 여야 등록된다.
            prefix = "notification.slack",
            name = "webhook-url",
            matchIfMissing = false
    )
    public NotificationSender slackNotificationSender(NotificationProperties properties) {
        NotificationProperties.Slack slack = properties.getSlack();

        return new SlackNotificationSender(slack.getWebhookUrl());
    }

    @Bean
    @ConditionalOnMissingBean(NotificationClient.class)
    @ConditionalOnBean(NotificationSender.class)
    public NotificationClient notificationClient(List<NotificationSender> senders, NotificationProperties properties) {
        return new NotificationClient(senders, properties.getDefaultChannel());
    }
}
