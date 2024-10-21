package io.origins.conanadmin.controller;

import io.origins.conanadmin.config.WxConfigProperties;
import io.origins.conanadmin.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TestController {
    private final WxConfigProperties wxConfigProperties;
    private final RedisTemplate<String, Object> redisTemplate;
    private transient final String test = "nif";

    private final Map<String, SseEmitter> sseCache = new ConcurrentHashMap<>();

    @GetMapping("/test")
    public String test1() {
        // 暂停 5 秒
        return "test";
    }

    @PostMapping("/search")
    public String test2() {
        return "search";
    }

    @PostMapping("/setRedis")
    public void setRedis() {
        User build = User.builder().id(1L).username("test").password("test").build();
        redisTemplate.opsForValue().set("test", build);
    }

    @RequestMapping("/sse")
    public SseEmitter sse() throws IOException, InterruptedException {
        SseEmitter sseEmitter = new SseEmitter();
        sseCache.put("test", sseEmitter);
        return sseEmitter;
    }

    @RequestMapping("/send")
    public void send() {
        SseEmitter sseEmitter = sseCache.get("test");
        try {
            sseEmitter.send("test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
