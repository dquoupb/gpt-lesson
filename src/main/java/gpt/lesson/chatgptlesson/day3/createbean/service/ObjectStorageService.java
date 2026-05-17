package gpt.lesson.chatgptlesson.day3.createbean.service;

import gpt.lesson.chatgptlesson.day3.createbean.client.ObjectStorageClient;
import gpt.lesson.chatgptlesson.day3.createbean.client.ObjectStorageType;
import gpt.lesson.chatgptlesson.day3.createbean.registry.ObjectStorageRegistry;
import org.springframework.stereotype.Service;

@Service
public class ObjectStorageService {

    private final ObjectStorageRegistry objectStorageRegistry;

    public ObjectStorageService(ObjectStorageRegistry objectStorageRegistry) {
        this.objectStorageRegistry = objectStorageRegistry;
    }

    public void upload(ObjectStorageType type, String path, byte[] data) {
        ObjectStorageClient client = objectStorageRegistry.getObjectStorageClient(type);
        client.upload(path, data);
    }
}
