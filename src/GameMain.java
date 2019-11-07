import java.util.Scanner;

import static java.lang.System.*;

/**
 * The GameMain class is responsible for communication with the command-line.
 */

public class GameMain {
    public static void main(String[] args) {
        GameMain game = new GameMain();
        game.program();
    }

    // Variables that can be used throughout the class
    private final Scanner sc = new Scanner(in);
    private String nameManager;

    // Main method communicating with GameLogic
    private void program() {
        String action;

        welcomeMessage();
        nameManager = getNameOfManager();

        // Infinite loop, or broken when action equals "exit game"
        do {
            createSpaceAndLine();
            action = getActionFromManager();
            switch (action) {
                case "m":
                    break;
                case "c":
                    break;
                case "t":
                    break;
                case "v":
                    break;
            }
        } while (!action.equals("e"));

        exitMessageAndExit();
    }

    // Displays Welcome Message
    private void welcomeMessage() {
        out.println("My Orienteering Squad");
        out.println("The game where you create your orienteering dream team!");
        out.println();
        out.print("Welcome manager! Please enter your name: ");
    }

    // Get name of Manager
    private String getNameOfManager() {
        return sc.nextLine();
    }

    public String getManagerName() {
        return nameManager;
    }

    // Wait until an action is initialized from the manager
    private String getActionFromManager() {
        String legalActions = "mctve";
        String s;

        out.println("Hello " + nameManager + "!");
        out.println("What is your next move?");
        out.println("('m' = manage team, 'c' = compete in relay, 't' = train players, 'v' = view accomplishments, 'e' = exit game)");

        // Infinite loop until input of legal action
        while (true) {
            out.print(">>> ");
            s = sc.nextLine();
            if (legalActions.contains(s)) {
                return s;
            } else {
                out.println("Please write one of the following letters to complete your action: s, c, t, v, e");
            }
        }
    }

    // Displayed when action exit is chosen
    private void exitMessageAndExit() {
        out.println();
        out.println("Thank you " + nameManager + " for playing 'My Orienteering Squad'!");
        exit(-1);
    }

    // Clears terminal-window
    private void createSpaceAndLine() {
        out.println();
        for (int i = 0 ; i < 120 ; i++) {
            out.print("=");
        }
        out.println();
        out.println();
    }

}

