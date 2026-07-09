import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Superheroe> listaSuperheroe = new ArrayList<>();
        listaSuperheroe.add(new Superheroe("hulk","superheroe verde poderoso",false,100 ));
        listaSuperheroe.add(new Superheroe("superman","superheroe de la tierra poderoso",true,92 ));
        listaSuperheroe.add(new Superheroe("spiderman","superheroe aracnido",false,85 ));
        listaSuperheroe.add(new Superheroe("batman","superheroe millonario",true,75 ));



        List<Superheroe> heroesConCapa = listaSuperheroe.stream()
                .filter(h -> h.isTieneCapa())
                .collect(Collectors.toList());


        List<String> heroesMayusculas = listaSuperheroe.stream()
                .map(h -> h.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        Superheroe heroeMasPoderoso = listaSuperheroe.stream()
                  .max(Comparator.comparingInt(h -> h.getPoder()))
                  .orElse(null);

        OptionalDouble maximoPoderLiga = listaSuperheroe.stream()
                        .mapToInt(h -> h.getPoder())
                                .average();

        Map<Boolean, List<Superheroe>> heroesPorCapa = listaSuperheroe.stream()
                .collect(Collectors.partitioningBy(h -> h.isTieneCapa()));

        List<Superheroe> heroesConCapaLiga = heroesPorCapa.get(true);
        List<Superheroe> heroesSinCapaLiga = heroesPorCapa.get(false);


        heroesConCapa.forEach(System.out::println);
        heroesMayusculas.forEach(System.out::println);
        System.out.println("el super heroe mas poderoso es " + heroeMasPoderoso.getNombre() + "con un poder de " + heroeMasPoderoso.getPoder());
        System.out.println("el promedio del poder de los superheroes de la liga es " + maximoPoderLiga);
        heroesConCapaLiga.forEach(System.out::println);
        heroesSinCapaLiga.forEach(System.out::println);

    }


}


