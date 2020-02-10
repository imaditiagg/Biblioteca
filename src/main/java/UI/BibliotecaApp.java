package UI;

import com.twu.biblioteca.Biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String args[]) {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.welcomeMessage());
        System.out.println("----------MENU-----------");

        Scanner scanner = new Scanner(System.in);
        char wantToContinue;
        do {
            System.out.println(biblioteca.displayMenu());
            System.out.println("Enter your choice :  ");
            int choice = scanner.nextInt();
            biblioteca.execute(choice - 1);
            System.out.println("Do you want to continue? (Y/N) ");
            wantToContinue = scanner.next().charAt(0);
        }
        while (wantToContinue == 'Y' || wantToContinue == 'y');
    }
}

