import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        User u1 = new User("Eduardo", "bingo");
        User u2 = new User("Pietro", "&%RDGF");
        User u3 = new User("Francisco", "*&REFGUIHBM<");

        List<User> users = Arrays.asList(u1, u2, u3);

        Consumer<User> c1 = new Consumer<User>() {
            @Override
            public void accept(User user) {
                out.println(user.getName());
            }
        };

        Consumer<User> c2 = new Consumer<User>() {
            @Override
            public void accept(User user) {
                out.println(user.getPassword());
            }
        };

        users.forEach(c1.andThen(c2));
    }
}
