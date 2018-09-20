package cursojava;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Supplier<User> userFactory = User::new;

        User user = userFactory.get();

        Function<String, User> userFunctionByName = User::new;
        User edu = userFunctionByName.apply("Eduardo");
        User djo = userFunctionByName.apply("Djovana");

        BiFunction<String, Boolean, User> userFunctionByNameAndModerator = User::new;
        User joao = userFunctionByNameAndModerator.apply("Joao", false);
        User francisco = userFunctionByNameAndModerator.apply("Francisco", true);
    }
}
