package reflections_playground;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.util.Set;

public class Scanner {

    private Reflections reflections;

    public static void main(String[] args) {
        Scanner obj = new Scanner();
        obj.initReflections();

        Set<Class<? extends Professional>> profs = obj.getProfessionalSubtypes();
        System.out.println("Subtypes of Professional ==== ");
        profs.stream().forEach(System.out::println);
        System.out.println();

        System.out.println("Outdoors Jobs ==== ");
        Set<Class<?>> outdoorJobs = obj.getOutdoorJobs();
        outdoorJobs.stream().forEach(System.out::println);

        System.out.println("Indoors Jobs ==== ");
        Set<Class<?>> indoorJobs = obj.getIndoorJobs();
        indoorJobs.stream().forEach(System.out::println);
        System.out.println();

        indoorJobs.stream().forEach(job -> {
            if (job.equals(Clerk.class)) {
                try {
                    Clerk clerk = (Clerk) job.newInstance();
                    System.out.println(clerk.toString());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        });


        Pilot pilotSub= new Pilot();
        System.out.println(pilotSub.getClass());

        Professional pilotSuper = new Pilot();
        System.out.println(pilotSuper.getClass());

        OverloadingTest overloadingTest = new OverloadingTest();
        overloadingTest.print(pilotSub);
        overloadingTest.print(pilotSuper);

        Professional justProf = new Professional();
        overloadingTest.print(justProf);
        System.out.println(justProf.getClass());

    }

    public void initReflections() {
        reflections = new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forPackage(""))
            .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner()));
    }

    public Set<Class<? extends Professional>> getProfessionalSubtypes() {
        Set<Class<? extends Professional>> professionals =
            reflections.getSubTypesOf(Professional.class);
        return professionals;
    }

    public Set<Class<?>> getOutdoorJobs() {
        Set<Class<?>> outdoorJobs = reflections.getTypesAnnotatedWith(Outdoor.class);
        return outdoorJobs;
    }

    public Set<Class<?>> getIndoorJobs() {
        Set<Class<?>> indoorJobs = reflections.getTypesAnnotatedWith(Indoor.class);
        return indoorJobs;
    }

}
