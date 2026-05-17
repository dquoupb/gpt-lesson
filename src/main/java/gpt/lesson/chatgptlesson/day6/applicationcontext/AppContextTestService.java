package gpt.lesson.chatgptlesson.day6.applicationcontext;

import org.springframework.stereotype.Service;

@Service
public class AppContextTestService {

    public void print() {
        System.out.println("AppContextTestService 실행");
    }
}
