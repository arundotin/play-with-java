package org.arun;

import java.util.Comparator;
import java.util.List;

public class WhilePlay {

    private static int RED_COLOUR = 1;
    private static int GREY_COLOUR = 2;
    private static int GREEN_COLOUR = 3;

    public static void main(String[] args) {
        takeWhileDemo();

    }

    private static void takeWhileDemo() {
        record Apple(String importFrom, int colourCode){}

        List<Apple> yellowBowl = List.of(

                new Apple("United States", RED_COLOUR),
                new Apple("China", RED_COLOUR),
                new Apple("Chile", RED_COLOUR),
                new Apple("United States", GREY_COLOUR),
                new Apple("China", GREY_COLOUR),
                new Apple("Chile", GREEN_COLOUR)

        );

        List<Apple> greenBowl = yellowBowl
                .stream()
                // filter will process the entire data stream
                //.filter(apple -> apple.colourCode!=GREY_COLOUR)
                .sorted(Comparator.comparingInt(Apple::colourCode))
                .takeWhile(apple -> apple.colourCode!=GREY_COLOUR)
                .toList();


        greenBowl.forEach(System.out::println);
        System.out.println(greenBowl.size());


    }



}
