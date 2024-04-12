package org.arun;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Arrays are covariant by default

        // Boy extends from Human is legal
        // Boy[] extends from Human[] is legal

        Boy[] boys = {new Boy(), new Boy()};

        Human[] humans = boys;



        // boys[] ---> Arrays of Boys <--- humans[]

        humans[0] = new Girl();

        System.out.println("The size of the humans is >> "+humans.length);

        // ArrayStoreException
        // Reification -- during the RunTime
    }

    public static void main2(String[] args) {
        //List<Human> pplInCountryA = List.of(new Boy(), new Girl());

        //List<Boy> boysInCountryA = List.of(new Boy(), new Boy());

        List<Girl> girlsInCountryA = List.of(new Girl(), new Girl());

        List<Human> pplInCountryB = new ArrayList<>();

        migratePeople(
                girlsInCountryA,pplInCountryB
        );

        System.out.println("Migrated successfully !!");
        System.out.println(pplInCountryB.size());
    }

    private static <T> void migratePeople (List<T> pplIncountryA,
                                       List<? super T> pplInCountryB) {

        for (T ppl: pplIncountryA) {
            pplInCountryB.add(ppl);
        }
    }

    public static void main1(String[] args) {
            /*

                    1. Covariance / Contravariance
                    2. extends / Super
                    3. Arrays / List

                    SuperClass
                        |
                        |
                        |       --> contravariant (? super Type T)
                        |
                        |
                    Type(T)
                        |
                        |       ----> covariant (? extends Type T)
                        |
                        |

                     SubClass


           */

        Human human = new Boy();

        List<Boy> boys = List.of(new Boy(), new Boy());

        // List<Human> humans = boys; // This means that it is Invariant

        // Boy extends from Human
        // List<Boy> extends from List<Human>

        List<? extends Human> humans = boys;

        // boys ----> List of Boys <---- humans

        //humans.add(new Girl()) // This is not allowed

        // ? extends Type --> you can only read


        System.out.println(humans.size());


    }
}

class Human{}

class Boy extends Human{}

class Girl extends Human{}