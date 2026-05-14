package gpt.lesson.chatgptlesson.createbean.config;

import gpt.lesson.chatgptlesson.createbean.client.MinioStorageClient;
import gpt.lesson.chatgptlesson.createbean.client.ObjectStorageClient;
import gpt.lesson.chatgptlesson.createbean.client.S3StorageClient;
import gpt.lesson.chatgptlesson.createbean.registry.ObjectStorageRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class ObjectStorageAutoConfiguration {

    /**
     * s3StorageClient라는 이름의 빈을 직접 등록하지 않았다면 아래 빈을 생성해라
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "s3StorageClient")
    public ObjectStorageClient s3StorageClient() {
        return new S3StorageClient();
    }

    /**
     * minioStorageClient라는 이름의 빈을 직접 등록하지 않았다면 아래 빈을 생성해라
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "minioStorageClient")
    public ObjectStorageClient minioStorageClient() {
        return new MinioStorageClient();
    }

    /**
     * ObjectStorageRegistry를 빈으로 등록한다.
     * 파라미터의 [List<ObjectStorageClient> clients] 는 개발자가 넣는 것이 아닌, 스프링이 직접 넣어준다.😅
     * 위에서 두개 만들어 줬잖앙 s3StorageClient, minioStorageClient
     *
     * 따라서 아래 내용은 위에서 만들어진 (client)빈을 모아서 registry를 만들고, registry도 빈으로 만든다.
     *
     * ConditionalOnMissingBean의 의미: ObjectStorageRegistry타입의 빈이 없으면 아래 내용대로 빈을 만들어라
     *
     * 스프링에서 자동으로 넣어준다고 하는 [List<ObjectStorageClient> clients]에서 이 list에 들어가는 기준은 포함기준...?
     * 빈으로 생성할 때 타입이 인터페이스 형식(ObjectStorageClient)이 아니고 구현체려도 한 list안으로 들어간다.
     * 그리고 하나의 configuration 클래스 안에 있지 않아도 됨 그냥 하나의 스프링안에 있으면 알아서 인식됨. 즉 다른 클래스에서 빈을 생성해도 하나의 list안으로 들어간다는 소리.
     * List뿐만아니라 Map도 지원한다. ↓ objectStorageRegistry2
     * @param clients
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public ObjectStorageRegistry objectStorageRegistry(List<ObjectStorageClient> clients) {
        return new ObjectStorageRegistry(clients);
    }

    /**
     * 이때 키 값은 빈 이름이다.
     * @param clientMap
     * @return
     */
    @Bean
    public ObjectStorageRegistry objectStorageRegistry2(Map<String, ObjectStorageClient> clientMap) {
        // return new ObjectStorageRegistry(clientMap);
        return null;
    }
}
