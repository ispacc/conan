package io.origins.conan.controller;

import io.origins.conan.common.rest.RestResp;
import io.origins.conan.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    /**
     * 发送消息
     */
    @GetMapping("/send")
    public RestResp send(@RequestParam String message) {
        return RestResp.success(messageService.send(message));
    }

    /**
     * 接收消息
     */
    @GetMapping("/receive")
    public RestResp receive() {
        return RestResp.success(messageService.receive());
    }
}
