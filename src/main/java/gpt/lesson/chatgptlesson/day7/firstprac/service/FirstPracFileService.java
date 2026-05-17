package gpt.lesson.chatgptlesson.day7.firstprac.service;

import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracObejctStorageType;
import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracObjectStoragClient;
import gpt.lesson.chatgptlesson.day7.firstprac.config.FirstPracObjectStorageRegistry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FirstPracFileService {

    FirstPracObjectStorageRegistry firstPracObjectStorageRegistry;

    public void upload(FirstPracObejctStorageType type, String path, byte[] str){
        FirstPracObjectStoragClient client = firstPracObjectStorageRegistry.getClient(type);
        client.upload(path, str);
    }
}
