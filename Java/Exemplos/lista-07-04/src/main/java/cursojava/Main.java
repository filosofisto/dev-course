package cursojava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*List<Veiculo> veiculos = Arrays.asList(
                new Veiculo("Bravo", "Fiat", 2015),
                new Veiculo("Tempra", "Fiat", 2000),
                new Veiculo("Edge", "Ford", 2018),
                new Veiculo("Ka", "Ford", 2016),
                new Veiculo("Senna", "McLaren", 2019)
        );*/

        // veiculos.forEach(v->System.out.println(v));
        // veiculos.forEach(System.out::println);
        /*veiculos.forEach(new Consumer<Veiculo>() {
            @Override
            public void accept(Veiculo veiculo) {
                if (veiculo.getFabricante().equals("Fiat")) {
                    System.out.println(veiculo);
                }
            }
        });*/
        //veiculos.forEach(v->{if (v.getFabricante().equals("Fiat")) System.out.println(v);});

        List<Veiculo> veiculos = new ArrayList<>(Arrays.asList(
                new Veiculo("Bravo", "Fiat", 2000),
                new Veiculo("Tempra", "Fiat", 2000),
                new Veiculo("Edge", "Ford", 2018),
                new Veiculo("Ka", "Ford", 2016),
                new Veiculo("Senna", "McLaren", 2019)
        ));
        /*veiculos.removeIf(new Predicate<Veiculo>() {
            @Override
            public boolean test(Veiculo veiculo) {
                return !veiculo.getFabricante().equals("Fiat");
            }
        });*/
        veiculos.removeIf(
                veiculo->
                        !veiculo.getFabricante().equals("Fiat")
                        || veiculo.getAnoFabricacao() != 2000
                        || !veiculo.getModelo().equals("Tempra")
        );
        veiculos.forEach(System.out::println);
    }
}
