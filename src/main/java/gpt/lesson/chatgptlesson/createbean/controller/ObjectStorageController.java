package gpt.lesson.chatgptlesson.createbean.controller;

import gpt.lesson.chatgptlesson.createbean.client.ObjectStorageType;
import gpt.lesson.chatgptlesson.createbean.service.ObjectStorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 코드의 흐름
 * 1. S3ObjectStorageClient Bean 생성
 * 2. MinioObjectStorageClient Bean 생성
 * 3. ObjectStorageClientRegistry Bean 생성
 *    - 이때 List<ObjectStorageClient>로 S3, MinIO Bean들이 주입됨
 * 4. ObjectStorageService Bean 생성
 *    - 이때 ObjectStorageClientRegistry Bean이 생성자에 주입됨
 * 5. Controller에서 Service 호출
 * 6. Service가 Registry를 통해 type에 맞는 Client 선택
 */
@RestController
public class ObjectStorageController {

    ObjectStorageService objectStorageService;

    public ObjectStorageController(ObjectStorageService objectStorageService) {
        this.objectStorageService = objectStorageService;
    }

    @GetMapping("/upload")
    public String storageUpload(@RequestParam String type, @RequestParam String path) {
        ObjectStorageType objectStorageType = ObjectStorageType.from(type);

        byte[] data = "sample data".getBytes();
        objectStorageService.upload(objectStorageType, path, data);

        return "upload success. type=" + objectStorageType + ", path=" + path;
    }
}
