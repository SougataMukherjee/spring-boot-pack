package service;

import org.springframework.stereotype.Service;
import models.HelloMessage;

@Service
public class HelloService {

    public HelloMessage getTotalMessage(int num1, int num2) {
        int total = num1 + num2;
        return new HelloMessage("Total " + total);
    }
}
