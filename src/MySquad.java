import java.util.ArrayList;
import java.util.List;

public class MySquad {
    private final List<Orienteer> orienteers = new ArrayList<>();

    public void addPlayerToSquad(Orienteer o) {
        orienteers.add(o);
    }

    public List<Orienteer> getSquad() {
        return orienteers;
    }

    public int getSquadSize() {
        return orienteers.size();
    }
}
