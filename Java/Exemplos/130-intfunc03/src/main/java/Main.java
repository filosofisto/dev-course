import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        User u1 = new User("Eduardo", false, "bingo");
        User u2 = new User("Pietro", true, "&%RDGF");
        User u3 = new User("Francisco", true, "*&REFGUIHBM<");

        List<User> users = new ArrayList<>(Arrays.asList(u1, u2, u3)); // avoid => java.lang.UnsupportedOperationException: remove

        Predicate<User> predicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return !user.isAtivo();
            }
        };

        users.removeIf(predicate);
        users.forEach(user -> out.println(user.getName()));

        //users.removeIf(user -> !user.isAtivo());
        //users.forEach(user -> out.println(user.getName()));
    }
}
