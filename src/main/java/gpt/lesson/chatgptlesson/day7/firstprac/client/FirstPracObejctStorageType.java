package gpt.lesson.chatgptlesson.day7.firstprac.client;

public enum FirstPracObejctStorageType {
    S3,
    Minio;

    public static FirstPracObejctStorageType from(String value) {
        if(value == null || value.isBlank()){
            throw new IllegalArgumentException("ObjectStorage Type 값은 비어있을 수 없습니다.");
        }

        try {
            return FirstPracObejctStorageType.valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("지원하지 않는 ObjectStorageType입니다: " + value);
        }
    }
}
