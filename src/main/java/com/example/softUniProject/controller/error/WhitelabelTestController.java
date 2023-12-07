package com.example.softUniProject.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WhitelabelTestController {
    @GetMapping("/test-whitelabel")
    public String testWhiteLabel() {
        throw new NullPointerException("Test Whitelabel Error");
    }
}
