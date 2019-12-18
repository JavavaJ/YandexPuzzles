package some_playground.reflection_playground;

import java.util.Arrays;

public class ClassReflectionCaller {

    public static void main(String[] args) {
        Class<?>[] classes = ClassWithInnerClasses.class.getClasses();
        Arrays.stream(classes).forEach(System.out::println);

    }

}
