package com.telegram.telegram_bot.command;
import org.junit.jupiter.api.DisplayName;

import static com.telegram.telegram_bot.command.CommandName.*;
import static com.telegram.telegram_bot.command.HelpCommand.*;
@DisplayName("Unit test for help")
public class HelpCommandTest extends AbstractCommandTests {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(service);
    }
}
