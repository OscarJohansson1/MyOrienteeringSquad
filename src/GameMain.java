import java.util.Scanner;
import static java.lang.System.*;

/**
 * The GameMain class is responsible for communication with the command-line. Or calls different actions to let them
 * write directly to the terminal.
 */

public class GameMain {
    public static void main(String[] args) {
        GameMain game = new GameMain();
        game.program();
    }

    // Variables that can be used throughout the class
    private final Scanner sc = new Scanner(in);

    private String nameManager;
    private String nameClub;

    // Main method communicating with GameLogic
    private void program() {
        ManageTeam manageTeam = new ManageTeam();
        Compete competeInRelay = new Compete();
        Training trainPlayers = new Training();
        Accomplishment viewAccomplishment = new Accomplishment();
        String action;

        welcomeMessage();
        nameManager = initializeNameOfManager();
        nameClub = initializeNameOfClub();

        // Infinite loop, or broken when action equals "exit game"
        do {
            createSpaceAndLine();
            action = getActionFromManager();
            switch (action) {
                case "m":
                    manageTeam.displayText();
                    break;
                case "c":
                    competeInRelay.displayText();
                    break;
                case "t":
                    trainPlayers.displayText();
                    break;
                case "v":
                    viewAccomplishment.displayText();
                    break;
            }
        } while (!action.equals("e"));

        exitMessageAndExit();
    }

    // Getters
    public String getManagerName() {
        return nameManager;
    }

    public String getClubName() {
        return nameClub;
    }

    // Displays Welcome Message
    private void welcomeMessage() {
        out.println("My Orienteering Squad");
        out.println("The game where you create your orienteering dream team!");
        out.println();
        out.print("Welcome manager! Please enter your name: ");
    }

    // Initialize name of Manager
    private String initializeNameOfManager() {
        return sc.nextLine();
    }

    // Initialize name of Club
    private String initializeNameOfClub() {
        out.print("Please enter the name of your club: ");
        return sc.nextLine();
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
    public static void createSpaceAndLine() {
        out.println();
        for (int i = 0 ; i < 120 ; i++) {
            out.print("=");
        }
        out.println();
        out.println();
    }

}

