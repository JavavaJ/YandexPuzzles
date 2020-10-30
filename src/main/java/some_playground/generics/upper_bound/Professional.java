package some_playground.generics.upper_bound;

public class Professional {

    private Duty duty;

    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    public void fulfilDuty() {
        System.out.println("Doing " + duty.getName());
    }

}
