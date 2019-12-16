package some_playground;

public class ObjectPlayground {

    public static void main(String[] args) {
        String str = "home";
        Object obj = (Object) str;
        System.out.println(obj instanceof String);
        System.out.println(obj instanceof Object);
        System.out.println(obj instanceof Integer);

        System.out.println("===============");

        Object strAsObj = "dog";
        System.out.println(strAsObj instanceof String);
        System.out.println(strAsObj instanceof Object);
    }

}
