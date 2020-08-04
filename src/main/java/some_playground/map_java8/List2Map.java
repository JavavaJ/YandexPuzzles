package some_playground.map_java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class List2Map {

    public static void main(String[] args) {

        User realJesus = new User(1, "Jesus", 33);
        User impostorJesus = new User(6, "Jesus", 133);


        List<User> users = Arrays.asList(realJesus, impostorJesus);
        Map<String, User> name2user = users.stream()
            .collect(Collectors.toMap(
                User::getName,
                user -> user,
                // pass mergeFunction - compiles fine
                (firstJesus, secondJesus) -> firstJesus));

    }

}
