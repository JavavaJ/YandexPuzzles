package reflections_playground;

public class OverloadingTest {

    public void print(Professional prof) {
        System.out.println(prof);
    }

    public void print(Pilot pilot) {
        System.out.println(pilot);
    }

}
