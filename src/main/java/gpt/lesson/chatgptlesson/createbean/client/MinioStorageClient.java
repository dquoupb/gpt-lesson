package gpt.lesson.chatgptlesson.createbean.client;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinioStorageClient implements ObjectStorageClient{
    @Override
    public ObjectStorageType getObjectStorageType() {
        return ObjectStorageType.MINIO;
    }

    @Override
    public void upload(String path, byte[] data) {
        log.info("[MINIO] Minio 저장소 client 호출");
        System.out.println(new String(data) + "는" + path + "에 저장되었습니다.");
    }
}
