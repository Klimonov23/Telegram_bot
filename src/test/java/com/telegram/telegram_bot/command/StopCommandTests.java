package com.telegram.telegram_bot.command;

import org.junit.jupiter.api.DisplayName;

import static com.telegram.telegram_bot.command.CommandName.STOP;
import static com.telegram.telegram_bot.command.StopCommand.STOP_MESSAGE;
@DisplayName("Unit test for stop")
public class StopCommandTests extends AbstractCommandTests{
    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(service);
    }
}
