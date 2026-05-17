package gpt.lesson.chatgptlesson.day7.firstprac.client;

public interface FirstPracObjectStoragClient {
    FirstPracObejctStorageType getType();

    void upload(String path, byte[] str);
}
