import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        User u1 = new User("Eduardo", false, "bingo");
        User u2 = new User("Pietro", true, "&%RDGF");
        User u3 = new User("Francisco", true, "*&REFGUIHBM<");

        List<User> users = Arrays.asList(u1, u2, u3);

        Comparator<User> c = (user1, user2) -> -user1.getName().compareTo(user2.getName());
        Collections.sort(users, c);
        users.forEach(user -> out.println(user.getName()));

        /*Collections.sort(users, (user1, user2) -> -user1.getName().compareTo(user2.getName()));
        users.forEach(user -> out.println(user.getName()));*/

        /*users.sort((user1, user2) -> -user1.getName().compareTo(user2.getName()));
        users.forEach(user -> out.println(user.getName()));*/

        /*users.sort(Comparator.comparing(user -> user.getName()));
        users.forEach(user -> out.println(user.getName()));*/

        /*users.sort(Comparator.naturalOrder());
        users.forEach(user -> out.println(user.getName()));*/
    }
}
