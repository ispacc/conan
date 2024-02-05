package io.origins.conan.service.impl;

import io.origins.conan.entity.User;
import io.origins.conan.repository.UserRepository;
import io.origins.conan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }
}
