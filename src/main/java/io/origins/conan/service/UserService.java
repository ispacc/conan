package io.origins.conan.service;


import io.origins.conan.entity.User;

public interface UserService {


    User login(String username, String password);
}
