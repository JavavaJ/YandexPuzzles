package some_playground.reflection_playground;

public class ClassWithInnerClasses {

    public static class InnerClass {
        public static void printMe() {
            System.out.println("Inside the InnerClass");
        }
    }

    public static class SecondInnerClass {
        public static void printMeToo() {
            System.out.println("Inside the SecondInnerClass");
        }
    }

}
