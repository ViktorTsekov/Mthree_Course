package org.Viktor.assesment;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    static void getDogMakeup(String name) {
        Random random = new Random();
        List<Integer> genetics = new ArrayList<>();

        int percentage = 100;
        int percentageLeft = 0;

        for(int i = 0; i < 4; i++) {
            int rand = random.nextInt(percentage - percentageLeft) + 0;

            genetics.add(rand);
            percentageLeft += rand;
        }

        genetics.add(percentage - percentageLeft);

        System.out.println(name + " is:\n");
        System.out.println(genetics.get(0) + "% St. Bernard");
        System.out.println(genetics.get(1) + "% Chihuahua");
        System.out.println(genetics.get(2) + "% Dramatic RedNosed Asian Pug");
        System.out.println(genetics.get(3) + "% Common Cur");
        System.out.println(genetics.get(4) + "% King Doberman\n");
        System.out.println("Wow, that's QUITE the dog!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;

        System.out.print("What is your dog's name? ");
        name = scanner.next();

        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.\n");
        getDogMakeup(name);
    }
}
