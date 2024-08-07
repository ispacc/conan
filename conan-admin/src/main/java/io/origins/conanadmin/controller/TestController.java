package io.origins.conanadmin.controller;

import io.origins.conanadmin.mapper.UserMapper;
import io.origins.conanadmin.model.NacosConfigInfo;
import io.origins.conanadmin.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
@RequiredArgsConstructor
public class TestController {
    private final NacosConfigInfo nacosConfigInfo;

    private final UserMapper userMapper;

    @GetMapping("/test")
    public int test1() {
        User user = new User();
        user.setPassword("123456");
        user.setUsername("test111");
        int insert = userMapper.insert(user);
        return insert;
    }
}
