package com.telegram.telegram_bot.service;

import org.springframework.stereotype.Service;

public interface SendMessageService {
    void sendMessage(String chat_id,String message);
}
