package ar.com.ada.maven.view;

import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.utils.Ansi;
import ar.com.ada.maven.utils.ScannerSingleton;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ContinentView {

    public int continentMenuSelectOption() {

        System.out.println("** CONTINENTES **");

        System.out.println("Seleccione una opción: " +
                "\n|1|-Enlistar los continentes " +
                "\n|2|-Agregar continentes " +
                "\n|3|-Editar algun continente " +
                "\n|4|-Eliminar algun continente " +
                "\n|5|-Desea salir");

        Scanner keyboard = ScannerSingleton.getInstance();

        while (true) {
            try {

                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Error, debe seleccionar una opcion válida");
                keyboard.next();
            }
        }
    }

    public void printAllContinents(List<ContinenteDTO> continents) {
        System.out.println("*** LISTA DE CONTINENTES ***");

        System.out.println("\t|\tID \t|CONTINENTES|");
        System.out.println("\t|-------------------|");

        continents.forEach((continenteDTO) -> {
            System.out.println("\t|\t" + continenteDTO.getId() + "\t|\t" + continenteDTO.getNombre() + "\t|");
        });
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public String getNameNewContinent() {

        System.out.println("|**Formulario para crear un nuevo continente**|");

        System.out.println("Ingrese el nombre: \nSi deja el texto vacio, se cancela el proceso de guardado.");

        Scanner keyboard = ScannerSingleton.getInstance();
        keyboard.nextLine();

        while (true) {
            try {

                String name = keyboard.nextLine().trim();
                while (!name.matches("^[A-Za-záéíóúüÁÉÍÓÚÜ\\s]+$") && !name.isEmpty()) {
                    System.out.println("Error, debe ingresar un dato válido");
                    name = keyboard.nextLine();

                }
                return name;
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar un dato válido");
            }
        }
    }

    public void showNewContinent(String name) {
        System.out.println("El nuevo continente es: " + name);
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void newContinentCanceled() {
        System.out.println("Se ha cancelado el proceso de guardado del continente");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void continentAlreadyExists(String name) {
        System.out.println("El nombre elegido ya existe");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public String printContinentsPerPage(List<ContinenteDTO> continents, List<String> paginator, String optionEdithOrDelete, boolean showHeader) {
        if (showHeader)
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("\t Zoo World App :: Modulo Continente :: Lista Continente");
        System.out.println("+-----------------------------------------------------------+\n");

        System.out.println("\t|\tID\t| CONTINENTE|");
        continents.forEach((continente) -> {
            System.out.println("\t|" + continente.getId() + "\t|\t" + continente.getNombre() + "\t|");
        });
        if (optionEdithOrDelete != null && !optionEdithOrDelete.isEmpty())
        System.out.println("\n+-----------------------------------------------------------+");
        paginator.forEach((page) -> System.out.print(page + " "));
        System.out.println("\n+-----------------------------------------------------------+\n");

        Scanner keyboard = ScannerSingleton.getInstance();

        while (true) {
            try {
                System.out.println("? ");
                String name = keyboard.nextLine().trim();
                while (!name.matches("^[0-9IiAaSsUuEe]+$") && !name.isEmpty()) {
                    MainView.chooseValidOption();
                    System.out.println("? ");
                    name = keyboard.nextLine();
                }
                return name;
            } catch (InputMismatchException e) {
                MainView.chooseValidOption();
                keyboard.next();
            }
        }
    }

    public int continentIdSelected(String action) {

        switch (action) {
            case "[" + "E" + Ansi.RESET + "ditar]":
                action = "Editar";
                break;
            case "[" + "E" + Ansi.RESET + "liminar]":
                action = "Eliminar";
                break;
            case "[" + "E" + Ansi.RESET + "legir]":
                action = "Elegir";
                break;
        }

        System.out.println("Ingrese el numero de ID del Continente para " + action +
                " ó 0 para cancelar: \n");
        Scanner keyboard = ScannerSingleton.getInstance();

        while (true) {
            try {
                System.out.println("? ");
                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar un id valido");
                keyboard.next();
            }
        }
    }

    public static String getNameUpdate(ContinenteDTO continent) {
        System.out.println("Se actualizara el nombre del siguiente continente: ");
        System.out.println(Ansi.PURPLE + continent.getId() + "\t" + continent.getNombre() + Ansi.RESET);
        System.out.println("Ingrese el nombre del continente para actualizar ");
        System.out.println(" (para cancelar, no ingresar datos y presionar enter):\n");

        Scanner keyboard = ScannerSingleton.getInstance();
        keyboard.nextLine();

        while (true) {
            try {

                String name = keyboard.nextLine().trim();
                while (!name.matches("^[A-Za-záéíóúüÁÉÍÓÚÜ\\s]+$") && !name.isEmpty()) {
                    System.out.println("Error, debe ingresar un dato valido");
                    name = keyboard.nextLine();
                }
                return name;
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar un dato valido");
                keyboard.next();
            }
        }
    }

    public void continentNotExist(int id) {
        System.out.println("No existe un continente con el id " + id + " asociado");
        System.out.println("Seleccione un ID valido ó 0 para cancelar");
    }

    public void updateContinentCanceled() {
        System.out.println("Ha cancelado la actualizacion del continente\n");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void showUpdateContinent(String name) {
        System.out.println("El continente " + name + " se ha actualizado exitosamente");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public static Boolean getNameDelete(ContinenteDTO continent) {
        System.out.println("Se eliminará el nombre del siguiente continente: ");
        System.out.println(Ansi.PURPLE + continent.getId() + "\t" + continent.getNombre() + Ansi.RESET);

        System.out.println("¿Esta seguro que desea eliminar?");
        System.out.println("| 1 | Si");
        System.out.println("| 2 | No");

        Scanner keyboard = ScannerSingleton.getInstance();
        keyboard.nextLine();

        while (true) {
            try {
                System.out.println("? ");
                String name = keyboard.nextLine().trim();
                while (!name.matches("^[A-Za-záéíóúüÁÉÍÓÚÜ\\s]+$") && !name.isEmpty()) {
                    System.out.println("Error, debe ingresar un dato valido");
                    name = keyboard.nextLine();
                }
                return "1".equals(name);
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar un dato valido");
                keyboard.next();
            }
        }
    }

    public void deleteContinentCanceled(String nombre) {
        System.out.println("Se ha eliminado el continente\n");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void showDeleteContinent(String name) {
        System.out.println("El continente " + name + " se ha eliminado exitosamente");
        ScannerSingleton.pressEnterKeyToContinue();
    }
}

