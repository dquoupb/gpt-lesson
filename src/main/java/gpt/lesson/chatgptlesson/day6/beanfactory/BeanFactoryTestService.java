package gpt.lesson.chatgptlesson.day6.beanfactory;

import org.springframework.stereotype.Service;

@Service
public class BeanFactoryTestService {

    public void print() {
        System.out.println("BeanFactoryTestService 실행");
    }
}
