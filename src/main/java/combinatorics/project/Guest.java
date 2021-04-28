package combinatorics.project;

import java.util.ArrayList;
import java.util.List;

public class Guest {

    private Manager manager;
    private Integer id;
    private String name;

    private List<Guest> peers = new ArrayList<>();
    private List<Guest> donePeers = new ArrayList<>();
    private List<Guest> leftPeers = new ArrayList<>();

    public Guest(Manager manager, Integer id, String name) {
        this.manager = manager;
        this.id = id;
        this.name = name;
        manager.register(this);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Guest> getPeers() {
        return peers;
    }

    public void setPeers(List<Guest> allPossiblePeers) {
        this.peers = allPossiblePeers;
    }

    public List<Guest> getDonePeers() {
        return donePeers;
    }

    public void setDonePeers(List<Guest> donePeers) {
        this.donePeers = donePeers;
    }

    public List<Guest> getLeftPeers() {
        return leftPeers;
    }

    public void setLeftPeers(List<Guest> leftPeers) {
        this.leftPeers = leftPeers;
    }

    public void savePair(Guest partner) {
        donePeers.add(partner);
        leftPeers.remove(partner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;

        Guest guest = (Guest) o;

        if (!id.equals(guest.id)) return false;
        return name.equals(guest.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Guest{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
