package gpt.lesson.chatgptlesson.day3.createbean.client;

/**
 * 데이터를 저장하는 방식에는 여러개가 있을 예정
 * S3, MINIO
 */
public interface ObjectStorageClient {

    ObjectStorageType getObjectStorageType();

    void upload(String path, byte[] data);
}
