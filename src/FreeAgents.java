import java.util.ArrayList;
import java.util.List;


public class FreeAgents {
    private final List<Orienteer> freeAgents = new ArrayList<>();

    FreeAgents() {
        getFreeAgents();
    }

    private void getFreeAgents() {
        freeAgents.add(new Orienteer("Oscar Johansson", Gender.MAN, 20, 50, 70, 80, 60, 95, 90));
        freeAgents.add(new Orienteer("Hugo Lilleström", Gender.MAN,20, 60,75, 85, 80, 80, 80));
        freeAgents.add(new Orienteer("Filip Trofast", Gender.MAN, 20, 70, 85, 75, 70, 75, 85 ));
        freeAgents.add(new Orienteer("Emil Björnlinger", Gender.MAN, 20, 100, 100, 100, 100, 100, 100));
        freeAgents.add(new Orienteer("Axel Granqvist", Gender.MAN, 20, 80, 95, 75, 70, 90, 90));
        freeAgents.add(new Orienteer("Albin Andersson", Gender.MAN, 20, 40,70, 75, 95, 70, 70));
        freeAgents.add(new Orienteer("Isak Hertin", Gender.MAN, 20, 30, 60, 50, 60, 50, 50));
        freeAgents.add(new Orienteer("Felix Axelsson", Gender.MAN, 20, 70, 80, 90, 75, 80, 80));
    }
}
