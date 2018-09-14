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

        printClassic(users);
        printForEach(users);
        printLambda(users);
    }

    private static void printClassic(List<User> users) {
        out.println("------------------------- Forma classica --------------------------");

        for (User user: users) {
            out.println(user.getName());
        }
    }

    /**
     * Usa forEach de Collections e um Consumer
     *
     * @param users
     */
    private static void printForEach(List<User> users) {
        out.println("---------------- Collections.forEach e Consumer  -----------------");

        users.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                out.println(user.getName());
            }
        });
    }

    private static void printLambda(List<User> users) {
        out.println("--------------------- Consumer  e Lambda ----------------------");

        Consumer<User> consumer = (User user) -> { out.println(user.getName()); };
        users.forEach(consumer);

        /*Consumer<User> consumer = user -> { out.println(user.getName()); };
        users.forEach(consumer);*/

        /*Consumer<User> consumer = user -> out.println(user.getName());
        users.forEach(consumer);*/

        //users.forEach(user -> out.println(user.getName()));
    }
}
