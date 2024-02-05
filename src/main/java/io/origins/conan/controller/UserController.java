package io.origins.conan.controller;

import io.origins.conan.common.rest.R;
import io.origins.conan.entity.User;
import io.origins.conan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /**
     * 登录
     */
    @GetMapping("/login")
    public R login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        if (user != null) {
            return R.success(user);
        }
        return R.fail("用户名或密码错误");
    }

    /**
     * 注册
     */
    @GetMapping("/register")
    public R register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User register = userService.register(user);
        if (register == null) {
            return R.fail("注册失败");
        }
        return R.success("注册成功");
    }
}
