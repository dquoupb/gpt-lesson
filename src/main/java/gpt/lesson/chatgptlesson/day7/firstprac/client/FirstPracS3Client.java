package gpt.lesson.chatgptlesson.day7.firstprac.client;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FirstPracS3Client implements FirstPracObjectStoragClient{

    @Override
    public FirstPracObejctStorageType getType() {
        return FirstPracObejctStorageType.S3;
    }

    @Override
    public void upload(String path, byte[] str) {
        log.info("{}위치에 S3 업로드 완료, 내용: {}", path, new String(str));
    }
}
