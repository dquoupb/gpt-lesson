package gpt.lesson.chatgptlesson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 프로젝트 초기화시 테스트 코드
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }
}
