package io.origins.conan.controller;

import io.origins.conan.common.rest.R;
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
    public R send(@RequestParam String message) {
        return R.success(messageService.send(message));
    }

    /**
     * 接收消息
     */
    @GetMapping("/receive")
    public R receive() {
        return R.success(messageService.receive());
    }
}
