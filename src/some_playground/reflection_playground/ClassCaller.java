package some_playground.reflection_playground;

public class ClassCaller {

    public static void main(String[] args) {
        ClassWithInnerClasses.InnerClass  innerClass1 = new ClassWithInnerClasses.InnerClass();
        innerClass1.printMe();

        ClassWithInnerClasses.SecondInnerClass innerClass2 = new ClassWithInnerClasses.SecondInnerClass();
        innerClass2.printMeToo();
    }

}
