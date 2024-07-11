package io.origins.conan.controller;

import cn.hutool.core.util.IdUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlController {

    public static void main(String[] args) {
        long id = IdUtil.getSnowflakeNextId();
        System.out.println(id);
    }
}
