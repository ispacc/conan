package io.origins.conanadmin.controller;

import io.origins.conanadmin.config.WxConfigProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TestController {
    private final WxConfigProperties wxConfigProperties;

    @GetMapping("/test")
    public String test1() {
        // 暂停 5 秒
        return "test";
    }

    @PostMapping("/search")
    public String test2() {
        return "search";
    }
}
