package org.Viktor.dvd_library.view;

import org.Viktor.dvd_library.dependency_injector.Injector;
import org.Viktor.dvd_library.controller.Controller;

import java.util.Scanner;

public class Interface {
    Controller controller;
    Scanner scanner;
    public Interface(Injector inj) {
        controller = inj.makeController();
        scanner = inj.makeScanner();
    }

    public void startApplication() throws Exception {
        int input;

        System.out.println("Hi, welcome to my dvd library!");

        while(true) {
            System.out.println("\nChoose an option:\n 1. List all dvds\n 2. Get a particular dvd\n 3. Add a new dvd\n 4. Update an existing dvd\n 5. Delete a dvd\n 6. Exit\n");
            System.out.print("Input: "); input = Integer.parseInt(scanner.nextLine());

            System.out.println();
            switch (input) {
                case 1:
                    System.out.println("Dvd list:");
                    System.out.println(controller.listAllDvds());
                    break;
                case 2:
                    System.out.print("Enter index or a dvd title: ");
                    String output = controller.getSingleDvd(scanner.nextLine());
                    System.out.println("\nRetrieved dvd:\n" + output);
                    break;
                case 3:
                    controller.addNewDvd(getUserInput());
                    System.out.println("\nDvd added successfully!");
                    break;
                case 4:
                    System.out.print("Enter dvd index: ");
                    controller.editDvd(Integer.parseInt(scanner.nextLine()), getUserInput());
                    System.out.println("\nDvd edited successfully!");
                    break;
                case 5:
                    System.out.print("Enter dvd index: ");
                    controller.deleteDvd(Integer.parseInt(scanner.nextLine()));
                    System.out.println("\nDvd deleted successfully!");
                    break;
                case 6:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }
    }

    private String getUserInput() {
        StringBuilder str = new StringBuilder();

        String title;
        String releaseDate;
        String mpaaRating;
        String directorsName;
        String studio;
        String userNote;

        System.out.print("Movie Title: "); title = scanner.nextLine(); str.append(title + ", ");
        System.out.print("Release Date: "); releaseDate = scanner.nextLine(); str.append(releaseDate + ", ");
        System.out.print("MPAA Rating: "); mpaaRating = scanner.nextLine(); str.append(mpaaRating + ", ");
        System.out.print("Director's Name: "); directorsName = scanner.nextLine(); str.append(directorsName + ", ");
        System.out.print("Studio: "); studio = scanner.nextLine(); str.append(studio + ", ");
        System.out.print("Additional Note: "); userNote = scanner.nextLine(); str.append(userNote + "\n");

        return str.toString();
    }
}
