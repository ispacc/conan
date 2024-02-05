package io.origins.conan.service;


import io.origins.conan.entity.Message;

import java.util.List;

public interface MessageService {

    /**
     * 发送消息
     */
    Message send(String message);

    List<Message> receive();
}
