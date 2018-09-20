package com.cursojava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        User u1 = new User("Eduardo", false);
        User u2 = new User("Renan", false);
        User u3 = new User("Lenilson", false);
        User u4 = new User("Bruno", false);

        List<User> userList = Arrays.asList(u1, u2, u3, u4);

        // Objetivo: Tornar todos os usuarios, moderadores
        userList.forEach(user -> user.becameModerator());

        // Ordenando
        //userList.sort(Comparator.comparing(user -> user.getName()));

        // Imprime os usuarios
        //userList.forEach(user -> System.out.println(user));

        // Usando Method Reference
        userList.forEach(User::becameModerator);
        userList.sort(Comparator.comparing(User::getName));
        userList.forEach(System.out::println);
        //Function<User, String> byName = User::getName;
        //userList.sort(Comparator.comparing(byName));
    }
}
