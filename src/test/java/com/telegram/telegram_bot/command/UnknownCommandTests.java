package com.telegram.telegram_bot.command;

import org.junit.jupiter.api.DisplayName;

import static com.telegram.telegram_bot.command.UnknownCommand.UNKNOWN_MESSAGE;
@DisplayName("Unit test for smf shit")
public class UnknownCommandTests extends AbstractCommandTests{
    @Override
    String getCommandName() {
        return "/sdfg";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(service);
    }
}
