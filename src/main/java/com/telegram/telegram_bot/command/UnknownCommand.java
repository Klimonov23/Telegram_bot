package com.telegram.telegram_bot.command;

import com.telegram.telegram_bot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command {
        public static final String UNKNOWN_MESSAGE = "Не понимаю вас \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

        private final SendMessageService sendMessageService;

        public UnknownCommand(SendMessageService sendMessageService) {
            this.sendMessageService = sendMessageService;
        }

        @Override
        public void execute(Update update) {
            sendMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
        }
    }

