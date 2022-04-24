package com.telegram.telegram_bot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    void execute(Update update);
}
