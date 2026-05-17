package gpt.lesson.chatgptlesson.day7.firstprac.config;

import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracMinioClient;
import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracObejctStorageType;
import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracObjectStoragClient;
import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracS3Client;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 등록된 빈 목록을 맵에 저장해서 거기서 선택해서 쓰는 기능이니,
 * getClient가 있어야겠지
 */
@Slf4j
public class FirstPracObjectStorageRegistry {
    private Map<FirstPracObejctStorageType, FirstPracObjectStoragClient> clientMap;

    public FirstPracObjectStorageRegistry(List<FirstPracObjectStoragClient> clients) {
        this.clientMap = clients.stream()
                .collect(Collectors.toMap(
                        FirstPracObjectStoragClient::getType,
                        Function.identity()
                ));

        log.info("첫번째 실습, 등록된 client 목록: {}", this.clientMap.keySet());
    }

    public FirstPracObjectStoragClient getClient(FirstPracObejctStorageType type) {
        FirstPracObjectStoragClient client = clientMap.get(type);

        if(client == null) {
            throw new IllegalArgumentException("지원하지 않는 client type입니다.");
        }

        return client;
    }
}
