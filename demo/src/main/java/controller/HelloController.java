package controller;
import service.HelloService;
import models.HelloMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping("/process-form")
    public HelloMessage getData(@RequestParam int num1, @RequestParam int num2) {
        return helloService.getTotalMessage(num1, num2);
    }
}
