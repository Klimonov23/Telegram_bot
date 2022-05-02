package com.telegram.telegram_bot.command;
import org.junit.jupiter.api.DisplayName;

import static com.telegram.telegram_bot.command.CommandName.*;
import static com.telegram.telegram_bot.command.NoCommand.NO_MESSAGE;
@DisplayName("Unit test for no_command")
public class NoCommandTests extends AbstractCommandTests {

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(service);
    }
}
