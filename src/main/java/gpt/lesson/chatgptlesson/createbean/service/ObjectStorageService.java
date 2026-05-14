package gpt.lesson.chatgptlesson.createbean.service;

import gpt.lesson.chatgptlesson.createbean.client.ObjectStorageClient;
import gpt.lesson.chatgptlesson.createbean.client.ObjectStorageType;
import gpt.lesson.chatgptlesson.createbean.registry.ObjectStorageRegistry;
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
