package model.command;

import java.util.*;

public abstract class Command {
    protected String function;
    protected String parameter;

    public Command(String function, String parameter) {
        this.function = function;
        this.parameter = parameter;
    }

    public abstract void execute();

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
    public static final String IMPORT = "import";
    public static final String LOGIN = "login";
    public static final String REGISTER = "register";

    public static final String SEARCH_SHORTCUT = "s";
    public static final String LOOKUP_SHORTCUT = "l";
    public static final String ADD_SHORTCUT = "a";
    public static final String DELETE_SHORTCUT = "d";

    public static Set<String> validFunctions
            = new HashSet<>();

    static {
        Command.validFunctions.add(Command.QUIT);
        Command.validFunctions.add(Command.HELP);
        Command.validFunctions.add(Command.EDIT);
        Command.validFunctions.add(Command.SEARCH);
        Command.validFunctions.add(Command.LOOKUP);
        Command.validFunctions.add(Command.ADD);
        Command.validFunctions.add(Command.DELETE);
        Command.validFunctions.add(Command.SHOW);
        Command.validFunctions.add(Command.SAVE);
        Command.validFunctions.add(Command.IMPORT);
        Command.validFunctions.add(Command.LOGIN);
        Command.validFunctions.add(Command.REGISTER);

        Command.validFunctions.add(Command.SEARCH_SHORTCUT);
        Command.validFunctions.add(Command.LOOKUP_SHORTCUT);
        Command.validFunctions.add(Command.ADD_SHORTCUT);
        Command.validFunctions.add(Command.DELETE_SHORTCUT);

    }

    public static final String END_INPUT = "end input";
    // <--- end of static section





    public boolean isValid() {
        return Command.validFunctions.contains(this.function);
    }


    public String getFunction() {
        return function;
    }


    @Override
    public String toString() {
        return function + " " + parameter;
    }

    public String getParameter(){
        return this.parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
