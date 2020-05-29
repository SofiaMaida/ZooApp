package ar.com.ada.maven.view;

import ar.com.ada.maven.utils.Ansi;
import ar.com.ada.maven.utils.ScannerSingleton;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    public Integer mainMenuSelectOption() {

        System.out.println("**Zoologico App**");
        System.out.println("Seleccione una opcion: " +
                "\n| 1 |- Continentes " +
                "\n| 2 |- Paises " +
                "\n| 5 |- Salir");

        Scanner keyboard = ScannerSingleton.getInstance();

        while (true) {
            try {

                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar un dato valido");
                keyboard.next();
            }
        }

    }

    public static void chooseValidOption() {
        System.out.println("Error, debe ingresar un dato válido");
        System.out.println(Ansi.RESET);
    }

    public static void invalidData() {
        System.out.println("Error, debe ingresar un dato válido");
        System.out.println(Ansi.RESET);
    }
}
