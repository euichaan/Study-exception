package com.aiforpet.core.error;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public void test() {
        throw new IllegalArgumentException("Account Does not Exists");
    }
}