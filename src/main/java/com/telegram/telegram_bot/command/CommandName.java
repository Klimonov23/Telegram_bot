package com.telegram.telegram_bot.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("nocommand");


    private final String command_Name;

    CommandName(String commandName) {
        this.command_Name = commandName;
    }

    public String getCommandName() {
        return command_Name;
    }
}
