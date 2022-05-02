package com.telegram.telegram_bot.command;

import com.telegram.telegram_bot.service.SendMessageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

@DisplayName("Unit test for conteiner")
public class CommandContenierTests {
    private CommandConteiner commandConteiner;

    @BeforeEach
    public void init() {
        SendMessageService service = Mockito.mock(SendMessageService.class);
        commandConteiner = new CommandConteiner(service);
    }

    @Test
    public void shouldGetAllTheExistingCommands() {
        Arrays.stream(CommandName.values()).forEach(commandName -> {
            Command command = commandConteiner.retrieveCommand(commandName.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        });
    }

    @Test
    public void shouldReturnUnknownCommand() {

        String unknownCommand = "/fgjhdfgdfg";

        Command command = commandConteiner.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
