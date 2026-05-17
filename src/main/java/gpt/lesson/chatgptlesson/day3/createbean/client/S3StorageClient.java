package gpt.lesson.chatgptlesson.day3.createbean.client;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class S3StorageClient implements ObjectStorageClient{
    @Override
    public ObjectStorageType getObjectStorageType() {
        return ObjectStorageType.S3;
    }

    @Override
    public void upload(String path, byte[] data) {
        log.info("[S3] s3 저장소 client 호출");
        System.out.println(new String(data) + "는" + path + "에 저장되었습니다.");
    }
}
