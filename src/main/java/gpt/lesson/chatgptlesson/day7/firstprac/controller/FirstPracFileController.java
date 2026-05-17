package gpt.lesson.chatgptlesson.day7.firstprac.controller;

import gpt.lesson.chatgptlesson.day7.firstprac.client.FirstPracObejctStorageType;
import gpt.lesson.chatgptlesson.day7.firstprac.service.FirstPracFileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FirstPracFileController {
    FirstPracFileService firstPracFileService;

    @GetMapping("/first-prac/upload")
    public void upload(@RequestParam String typeStr, @RequestParam String path) {
        FirstPracObejctStorageType type = FirstPracObejctStorageType.from(typeStr);
        byte[]  str = "hello".getBytes();

        firstPracFileService.upload(type, path, str);
    }
}
