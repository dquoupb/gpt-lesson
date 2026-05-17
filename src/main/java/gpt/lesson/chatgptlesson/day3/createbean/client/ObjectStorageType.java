package gpt.lesson.chatgptlesson.day3.createbean.client;

public enum ObjectStorageType {
    S3,
    MINIO;

    public static ObjectStorageType from(String value) {
        if(value == null || value.isBlank()){
            throw new IllegalArgumentException("ObjectStorage Type 값은 비어있을 수 없습니다.");
        }

        try {
            return ObjectStorageType.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("지원하지 않는 ObjectStorageType입니다: " + value);
        }
    }
}
