package org.Viktor.assesment;

import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age;

        System.out.print("What is your age? ");
        age = scanner.nextInt();

        System.out.println("Your maximum heart rate should be " + (220 - age) + " beats per minute");
        System.out.printf("Your target HR Zone is %.0f - %.0f beats per minute", Math.ceil((0.5 * (220 - age))), Math.ceil((0.85 * (220 - age))));
    }
}
