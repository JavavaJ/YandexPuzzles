package combinatorics.project;

public class Pair {

    private Guest guest1;
    private Guest guest2;

    public Pair(Guest guest1, Guest guest2) {
        this.guest1 = guest1;
        this.guest2 = guest2;
    }

    public Guest getGuest1() {
        return guest1;
    }

    public Guest getGuest2() {
        return guest2;
    }
}
