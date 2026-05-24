package gpt.lesson.chatgptlesson.notification.config;

import gpt.lesson.chatgptlesson.notification.domain.NotificationChannel;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "notification")
public class NotificationProperties {
    private boolean enabled = false;

    private NotificationChannel defaultChannel = NotificationChannel.CONSOLE;

    /*
     * new를 해주는 이유: 미리 객체를 만들면 spring boot가 application.yaml 값을 바인딩할 때 그 객체 안에 값을 넣을 수 있기 때문이다.
     */
    private final Console console = new Console();
    private final Email email = new Email();
    private final Slack slack = new Slack();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public NotificationChannel getDefaultChannel() {
        return defaultChannel;
    }

    public void setDefaultChannel(NotificationChannel defaultChannel) {
        this.defaultChannel = defaultChannel;
    }

    public Console getConsole() {
        return console;
    }

    public Email getEmail() {
        return email;
    }

    public Slack getSlack() {
        return slack;
    }

    public static class Console {

        private boolean enabled = true;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }

    public static class Email {

        private boolean enabled = false;

        private String host = "localhost";

        private int port = 25;

        private String from = "noreply@example.com";

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }

    public static class Slack {

        private boolean enabled = false;

        private String webhookUrl;

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getWebhookUrl() {
            return webhookUrl;
        }

        public void setWebhookUrl(String webhookUrl) {
            this.webhookUrl = webhookUrl;
        }
    }
}
