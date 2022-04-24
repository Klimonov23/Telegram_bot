package com.telegram.telegram_bot.command;

import com.google.common.collect.ImmutableMap;
import com.telegram.telegram_bot.service.SendMessageService;
import static com.telegram.telegram_bot.command.CommandName.*;

public class CommandConteiner {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandConteiner(SendMessageService sendMessageService) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageService))
                .put(NO.getCommandName(), new NoCommand(sendMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageService);
    }
    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
