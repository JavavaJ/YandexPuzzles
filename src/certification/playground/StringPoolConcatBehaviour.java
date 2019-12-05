package certification.playground;

import java.util.Collection;

public class StringPoolConcatBehaviour {

    public static void main(String[] args) {
        String helloworld = "hello world";
        String hello = "hello ";
        String world = "world";
        System.out.println(helloworld == (hello + world));
        System.out.println(helloworld.equals(hello + world));

    }

}
