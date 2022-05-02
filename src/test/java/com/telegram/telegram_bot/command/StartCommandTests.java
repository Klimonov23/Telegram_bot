package com.telegram.telegram_bot.command;

import org.junit.jupiter.api.DisplayName;

import static com.telegram.telegram_bot.command.CommandName.START;
import static com.telegram.telegram_bot.command.StartCommand.START_MESSAGE;
@DisplayName("Unit test for start")
public class StartCommandTests extends AbstractCommandTests{
    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(service);
    }
}
