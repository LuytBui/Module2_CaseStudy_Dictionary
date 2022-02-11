package utilities;

public class Printer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static String coloredText(String string, String color) {
        String ansiColor;
        switch (color) {
            case Colors.RESET:
                ansiColor = ANSI_YELLOW;
                break;
            case Colors.BLACK:
                ansiColor = ANSI_BLACK;
                break;
            case Colors.RED:
                ansiColor = ANSI_RED;
                break;
            case Colors.GREEN:
                ansiColor = ANSI_GREEN;
                break;
            case Colors.YELLOW:
                ansiColor = ANSI_YELLOW;
                break;
            case Colors.BLUE:
                ansiColor = ANSI_BLUE;
                break;
            case Colors.PURPLE:
                ansiColor = ANSI_PURPLE;
                break;
            case Colors.CYAN:
                ansiColor = ANSI_CYAN;
                break;
            case Colors.WHITE:
                ansiColor = ANSI_WHITE;
                break;
            default:
                ansiColor = ANSI_YELLOW;
                break;
        }
        return ansiColor + string + ANSI_RESET;
    }

    public static void print(String string) {
        System.out.print(string);
    }

    public static void print(String string, String color) {
        string = coloredText(string, color);
        print(string);
    }

    public static void printIndent(String string) {
        string = string.replaceAll("\n", "\n\t");
        string = "\t" + string;
        print(string);
    }

    public static void printIndentLine(String string) {
        string = "\t" + string;
        println(string);
    }

    public static void printIndent(String string, String color) {
        string = coloredText(string, color);
        printIndent(string);
    }

    public static void printIndentLine(String string, String color) {
        string = "\t" + string;
        string = coloredText(string, color);
        println(string);
    }

    public static void println(String string) {
        print(string + "\n");
    }

    public static void println(String string, String color) {
        string = coloredText(string, color);
        println(string);
    }

    public static void println() {
        print("\n");
    }

}
