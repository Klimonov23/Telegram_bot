package com.telegram.telegram_bot.command;

import com.telegram.telegram_bot.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.telegram.telegram_bot.command.CommandName.*;
public class HelpCommand implements Command{
    private final SendMessageService sendMessageService;
    public static final String HELP_MESSAGE = String.format("✨<b>Доступные команды</b>✨\n\n"

                    + "<b>Начать\\закончить работу с ботом</b>\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());
    public HelpCommand(SendMessageService sendBotMessageService) {
        this.sendMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
