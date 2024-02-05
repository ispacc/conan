package io.origins.conan.service.impl;

import io.origins.conan.entity.Message;
import io.origins.conan.repository.MessageRepository;
import io.origins.conan.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message send(String message) {
        Message build = Message.builder().content(message).build();
        Message save = messageRepository.save(build);
        return save;
    }

    @Override
    public List<Message> receive() {
        return messageRepository.findAll();
    }
}
