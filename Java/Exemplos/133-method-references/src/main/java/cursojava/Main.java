package cursojava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User u1 = new User("Eduardo", 10);
        User u2 = new User("Renan", 16);
        User u3 = null;
        User u4 = new User("Lenilson", 16);
        User u5 = null;
        User u6 = new User("Bruno", 18);

        List<User> userList = Arrays.asList(u1, u2, u3, u4, u5, u6);

        // Ordenando
        userList.sort(
                Comparator.nullsLast(
                        Comparator.comparingInt(User::getPoints)
                                .reversed()
                                .thenComparing(User::getName)
                )
        );

        /*userList.sort(
                Comparator.nullsFirst(
                        Comparator.comparingInt(User::getPoints)
                                //.reversed()
                                .thenComparing(User::getName)
                )
        );*/

        // Imprime os usuarios
        userList.forEach(System.out::println);
    }
}
