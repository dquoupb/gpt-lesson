package gpt.lesson.chatgptlesson.notification.service;


import gpt.lesson.chatgptlesson.notification.domain.NotificationChannel;
import gpt.lesson.chatgptlesson.notification.domain.NotificationMessage;
import gpt.lesson.chatgptlesson.notification.sender.NotificationClient;
import org.springframework.stereotype.Service;

/**
 * 이 샘플을 실제로 수행하는 곳
 */
@Service
public class OrderService {

//    private final NotificationClient notificationClient;
//
//    public OrderService(NotificationClient notificationClient) {
//        this.notificationClient = notificationClient;
//    }
//
//    public void completeOrder(String orderNo) {
//        // 주문 완료 처리 로직
//        System.out.println("주문 완료 처리: " + orderNo);
//
//        NotificationMessage message = new NotificationMessage(
//                NotificationChannel.EMAIL,
//                "주문 완료",
//                "주문이 정상적으로 완료되었습니다. orderNo=" + orderNo,
//                "user@example.com"
//        );
//
//        notificationClient.send(message);
//    }
}