package combinatorics.project;

import java.util.List;

public class Starter {

    public static void main(String[] args) {
        Manager manager = new Manager();

        Guest anna = createGuests(manager);

        manager.initPeers();
        manager.initLeftPeers();
        manager.initMap();

        System.out.println("=== Before round ===");
        System.out.println("Anna done peers: " + anna.getDonePeers());

        manager.doRound();

        System.out.println("=== After round ===");
        System.out.println("Anna done peers: " + anna.getDonePeers());

    }

    private static Guest createGuests(Manager manager) {
        Guest anna = new Guest(manager, 1, "Anna");
        Guest igor = new Guest(manager, 2, "Igor");
        Guest alexander = new Guest(manager, 3, "Alexander");
        Guest victoria = new Guest(manager, 4, "Victoria");
        Guest chris = new Guest(manager, 5, "Chris");
        Guest maxim = new Guest(manager, 6, "Maxim");
        return anna;
    }
}
