package combinatorics.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Manager {

    private List<Guest> guests = new ArrayList<>();
    private List<Round> rounds = new ArrayList<>();
    private Map<Integer, Guest> id2guest = new HashMap<>(); // ids are nonzero based

    public Manager() {
    }

    public void register(Guest guest) {
        guests.add(guest);
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void initPeers() {
        guests.forEach(guest -> {
            guest.setPeers(
                guests.stream()
                    .filter(innerGuest -> !guest.equals(innerGuest))
                    .collect(Collectors.toList())
            );
        });
    }

    public void initLeftPeers() {
        guests.forEach(guest -> {
            ArrayList<Guest> peers = (ArrayList<Guest>) guest.getPeers();
            ArrayList<Guest> peersClone = (ArrayList<Guest>) peers.clone();
            guest.setLeftPeers(peersClone);
        });
    }

    public void initMap() {
        id2guest = guests.stream()
            .collect(Collectors.toMap(Guest::getId, Function.identity()));
    }

    public void doRound() {
        Round round = new Round();
        if (rounds.size() == 0) {
            doFirstRound(round);
        }

        if (id2guest.size() % 2 == 0) {
            List<Guest> pairedGuests = new ArrayList<>();
            for (int i = 1; i <= id2guest.size() / 2; i++) {

                if (i == 1) {
                    Guest firstGuest = id2guest.get(1);
                    Guest next4first = firstGuest.getLeftPeers()
                        .get(0); // it is just a start of a tree of possibilities
                    Pair pair1 = new Pair(firstGuest, next4first);

                    // maybe you will need to remove this pair if rollback happens
                    round.addPair(pair1);

                    pairedGuests.add(firstGuest);
                    pairedGuests.add(next4first);
                }

                List<Guest> singleGuests = guests.stream()
                    .filter(guest -> !pairedGuests.contains(guest))
                    .collect(Collectors.toList());

                Guest guest = singleGuests.get(0);
                Guest partner = null;

                List<Guest> availableGuests = guest.getLeftPeers()
                    .stream()
                    .filter(person -> !pairedGuests.contains(person))
                    .collect(Collectors.toList());

                for (Guest peer : availableGuests) {
                    if (singleGuests.contains(peer)) {
                        partner = peer;
                        break;
                    } // if singleGuests is empty - rollback to previous combination
                }
                if (partner == null) {
                    // discard the previous Pair and build another one

                }

                Pair pair = new Pair(guest, partner);

                // maybe you will need to remove this pair if rollback happens
                round.addPair(pair);
            }
        }

        rounds.add(round);

        // update data - donePeers and leftPeers
        round.getPairs().forEach(this::updateGuests);
    }

    private void doFirstRound(Round round) {

        // if there is even number of guests split guests to 1-2, 3-4, 5-6 round
        if (id2guest.size() % 2 == 0) {
            for (int i = 1; i <= id2guest.size() / 2; i++) {
                Guest guest1 = id2guest.get((i * 2) - 1);
                Guest guest2 = id2guest.get((i * 2));

                Pair pair = new Pair(guest1, guest2);
                round.addPair(pair);
            }
        }
    }

    private void updateGuests(Pair pair) {
        Guest guest1 = pair.getGuest1();
        Guest guest2 = pair.getGuest2();

        guest1.savePair(guest2);
        guest2.savePair(guest1);
    }
}
