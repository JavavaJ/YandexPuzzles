package design_patterns.proxy.native_java_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class NativeJavaProxy {

    public static void main(String[] args) {

        User user = new User(1, "John");

        InvocationHandler handler = (proxy, method, methodParams) -> {
            // making the name uppercase
            if (method.getName().equals("getName")) {
                return ((String) method.invoke(user, methodParams)).toUpperCase();
            }
            // just add 1000 to an id
            if (method.getName().equals("getId")) {
                return ((Integer)method.invoke(user, methodParams)) + 1000;
            }
            // the rest of the methods
            return method.invoke(user, methodParams);
        };

        IUser userProxy = (IUser) Proxy.newProxyInstance(user.getClass().getClassLoader(),
            User.class.getInterfaces(),
            handler);

        System.out.println("Name: " + userProxy.getName()); // Name: JOHN
        System.out.println("Id: " + userProxy.getId()); // Id: 1001

    }

}
