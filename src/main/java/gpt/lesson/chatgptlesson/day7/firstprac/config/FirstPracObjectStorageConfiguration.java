package gpt.lesson.chatgptlesson.day7.firstprac.config;

import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracMinioClient;
import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracObjectStoragClient;
import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracS3Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FirstPracObjectStorageConfiguration {

    @Bean
    public FirstPracS3Client firstPracS3Client() {
        return new FirstPracS3Client();
    }

    @Bean
    public FirstPracMinioClient firstPracMinio() {
        return new FirstPracMinioClient();
    }

    /**
     * 위에서 빈으로 띄워준 것들이 List<>안에 들어가있을 것이야
     * registry를 호출?하면 알아서 리스트들을 맵으로 저장해줄 것이야...
     * @param firstPracObjectStoragClientList
     * @return
     */
    @Bean
    public FirstPracObjectStorageRegistry firstPracObjectStoragClient(List<FirstPracObjectStoragClient> firstPracObjectStoragClientList) {
        return new FirstPracObjectStorageRegistry(firstPracObjectStoragClientList);
    }
}
