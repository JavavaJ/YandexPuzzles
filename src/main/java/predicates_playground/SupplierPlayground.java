package predicates_playground;

import java.util.function.Supplier;

public class SupplierPlayground {

    public static void main(String[] args) {

        Supplier<Integer> randIntGeneratorWithin100 = () ->
                (int) (Math.random() * 100);
        System.out.println(randIntGeneratorWithin100.get());

    }

}
