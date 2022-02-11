package model;

/*
    ..
 */

import java.util.*;

public class Command {

    // static section -->
    public static final String QUIT = "quit";
    public static final String HELP = "help";
    public static final String EDIT = "edit";
    public static final String SEARCH = "search";
    public static final String LOOKUP = "lookup";
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String SHOW = "show";
    public static final String SAVE = "save";
    public static final String LOAD = "load";
    public static final String IMPORT = "import";

    public static Set<String> validFunctions
            = new HashSet<>();

    static {
        Command.validFunctions.add(Command.QUIT);
        Command.validFunctions.add(Command.HELP);
        Command.validFunctions.add(Command.EDIT);
        Command.validFunctions.add(Command.SEARCH);x
        Command.validFunctions.add(Command.LOOKUP);
        Command.validFunctions.add(Command.ADD);
        Command.validFunctions.add(Command.DELETE);
        Command.validFunctions.add(Command.SHOW);
        Command.validFunctions.add(Command.SAVE);
        Command.validFunctions.add(Command.LOAD);
        Command.validFunctions.add(Command.IMPORT);
    }

    public static final String END_INPUT = "end input";
    // <--- end of static section

    private String commandString;  // = <function> <parameter>
    private String function;
    private String parameter;

    public Command(String commandString) {
        commandString = commandString.trim();
        this.commandString = commandString;

        int firstSpaceIndex = this.commandString.indexOf(" ");

        if (firstSpaceIndex == -1){
            this.function = commandString;
            this.parameter = "";
        } else {
            this.function = this.commandString.substring(0, firstSpaceIndex);
            this.parameter = this.commandString.substring(firstSpaceIndex);
            this.parameter = this.parameter.trim();
        }
    }

    public boolean isValid() {
        return Command.validFunctions.contains(this.function);
    }

    public String getCommandString() {
        return commandString;
    }

    public String getFunction() {
        return function;
    }

    public String getParameter() {
        return parameter;
    }

    @Override
    public String toString() {
        return this.commandString;
    }
}
