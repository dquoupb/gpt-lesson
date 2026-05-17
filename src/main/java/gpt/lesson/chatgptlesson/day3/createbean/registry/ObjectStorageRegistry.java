package gpt.lesson.chatgptlesson.day3.createbean.registry;

import gpt.lesson.chatgptlesson.day3.createbean.client.ObjectStorageClient;
import gpt.lesson.chatgptlesson.day3.createbean.client.ObjectStorageType;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ObjectStorageRegistry {
    private final Map<ObjectStorageType, ObjectStorageClient> clientMap;

    /**
     * 빈으로 띄워진 client 구현체를 한 번에 list에 담아 둔다.
     * 골라쓸 수 있게
     * @param clients
     */
    public ObjectStorageRegistry(List<ObjectStorageClient> clients) {
        this.clientMap = clients.stream()
                .collect(Collectors.toMap(
                        ObjectStorageClient::getObjectStorageType,
                        Function.identity()
                ));

        log.info("등록된 client 목록: {}", this.clientMap.keySet());
    }

    /**
     * 이 메서드를 통해 client를 골라쓴다.
     * @param objectStorageType
     * @return
     */
    public ObjectStorageClient getObjectStorageClient(ObjectStorageType objectStorageType) {
        ObjectStorageClient client = clientMap.get(objectStorageType);

        if(client == null) {
            throw new IllegalArgumentException("지원하지 않는 client type입니다.");
        }

        return client;
    }
}
