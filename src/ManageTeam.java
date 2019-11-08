import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;


/**
 * Communicates with the player while performing the action Manage Team.
 */

public class ManageTeam implements IDisplayText{
    private final FreeAgents freeAgents = new FreeAgents();
    private final MySquad mySquad = new MySquad();
    private final Scanner sc = new Scanner(in);

    public void displayText() {
        GameMain.createSpaceAndLine();
        welcomeMessage();

        update();
    }

    private void welcomeMessage() {
        out.println("Welcome to Manage Team!");
        out.println("Here you can watch your current squad, or add new players to your squad from the free agents.");
        out.println();
    }

    private void update(){
        String action1;
        String action2;
        String action3;

        do {
            displayActionText();
            action1 = getActionFromPlayer();
            switch (action1) {
                case "m":
                    GameMain.createSpaceAndLine();
                    displayMySquad();
                    break;
                case "f":
                    GameMain.createSpaceAndLine();
                    displayFreeAgents();
                    displayPlayerText();
                    action2 = getActionFromPlayer();
                    if (action2.equals("p")) {
                        do {
                            int id = getIdFromManager();
                            sc.nextLine(); // Fix bug, don't ask....
                            Orienteer tmp = freeAgents.getPlayerById(id);
                            if (tmp != null) {
                                displayPlayer(tmp);
                                displayAddPlayerText();
                                action3 = getActionFromPlayer();
                                if (action3.equals("a")) {
                                    addPlayerToMySquad(tmp.getId());
                                    break;
                                }
                                out.println();
                                break;
                            } else {
                                out.println("Invalid id, please try again");

                            }
                        } while (true);
                    }
                    break;
            }
        } while (!action1.equals("r"));
    }

    private String getActionFromPlayer() {
        String legalActions = "mfrap";
        while (true) {
            out.print(">>> ");
            String s = sc.nextLine();
            if (legalActions.contains(s)) {
                return s;
            }
        }
    }

    private void displayActionText() {
        out.println("press 'm' to see My Squad, 'f' to see Free Agents, 'r' to return to main menu");
    }

    private void displayPlayerText() {
        out.println("press 'p' if you wish to see more player stats, 'r' to return");
    }

    private void displayAddPlayerText() {
        out.println("press 'a' if you wish to add player to your squad, 'r' to return");
    }

    private int getIdFromManager() {
        out.println("Please enter the id of the player you want to see");
        out.print(">>> ");
        return sc.nextInt();
    }

    private void displayMySquad() {
        out.println("This is your current squad:");
        out.println();
        displayList(mySquad.getSquad());
    }

    private void displayFreeAgents() {
        out.println("This is all free agents:");
        out.println();
        displayList(freeAgents.getFreeAgentsList());
    }

    private void displayList(List<Orienteer> orienteers) {
        for (Orienteer o : orienteers) {
            out.println(o.getId() + ". " + o.getName() + ", " + o.getSpecialist() + ", Score: " + o.getScore() + ", Cost: " + o.getCost());
        }
        out.println();
    }

    private void displayPlayer(Orienteer o) {
        out.println("Name:               " + o.getName());
        out.println("Cost:               " + o.getCost());
        out.println("Favorite Distance:  " + o.getSpecialist());
        out.println("Score:              " + o.getScore());
        out.println();
        out.println("Detailed stats:");
        out.println("Speed:              " + o.getSpeed());
        out.println("Stamina:            " + o.getStamina());
        out.println("Strength:           " + o.getStrength());
        out.println("Technical Skills:   " + o.getTechnicalSkills());
        out.println("Routechoise Skills: " + o.getRoutechoiceSkills());
        out.println();
    }

    private void addPlayerToMySquad(int id) {
        Orienteer o = freeAgents.getPlayerById(id);
        mySquad.addPlayerToSquad(freeAgents.removePlayer(id));
        out.println(o.getName() + " is now added to your squad!");
        out.println();
    }
}
