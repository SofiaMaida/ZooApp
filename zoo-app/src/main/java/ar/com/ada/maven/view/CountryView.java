package ar.com.ada.maven.view;

import ar.com.ada.maven.model.dto.PaisDTO;
import ar.com.ada.maven.utils.Ansi;
import ar.com.ada.maven.utils.Paginator;
import ar.com.ada.maven.utils.ScannerSingleton;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CountryView {

    private Scanner keyboard = ScannerSingleton.getInstance();

    public int continentMenuSelectOption() {
        System.out.println("\n+--------------------------------------------------+");
        System.out.println("\t\t  Zoo Wolrd App :: Modulo de Países");
        System.out.println("+--------------------------------------------------+\n");

        System.out.println("Seleccione una accion del menu:\n");
        System.out.println("| 1 | Listar");
        System.out.println("| 2 | Agregar");
        System.out.println("| 3 | Editar");
        System.out.println("| 4 | Eliminar");
        System.out.println("| 5 | Regresar el menu principal");
        System.out.println("-------------------------\n");

        while (true) {
            try {
                System.out.print("? ");
                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                MainView.chooseValidOption();
                keyboard.next();
            }
        }
    }

    public String printContinentsPerPage(List<PaisDTO> countries, List<String> paginator, String optionEdithOrDelete, boolean showHeader) {
        if (showHeader) {
            System.out.println("\n+----------------------------------------------------------------+");
            System.out.println("\t  Zoo Wolrd App :: Modulo de Países :: Lista de Paises");
            System.out.println("+----------------------------------------------------------------+\n");
        }
        System.out.println("\t|\tID\t| CONTINENTE|");
        countries.forEach(paisDTO -> {
                    System.out.println(paisDTO.getId() + paisDTO.getNombre() + paisDTO.getIsoCod() +
                            paisDTO.getContinente().getNombre());
                }
        );

        if (optionEdithOrDelete != null && !optionEdithOrDelete.isEmpty())
            paginator.set(paginator.size() - 2, optionEdithOrDelete);

        System.out.println("\n+----------------------------------------------------------------+");
        paginator.forEach(page -> System.out.print(page + " "));
        System.out.println("\n+----------------------------------------------------------------+\n");

        while (true) {
            try {
                System.out.print("? ");
                String name = keyboard.nextLine().trim();
                while (!name.matches("^[0-9IiAaSsUuEeqQ]+$") && !name.isEmpty()) {
                    MainView.chooseValidOption();
                    System.out.print("? ");
                    name = keyboard.nextLine();
                }
                return name;
            } catch (InputMismatchException e) {
                MainView.chooseValidOption();
                keyboard.next();
            }
        }
    }

    public String getNameNewCountry() {
        System.out.println("\n+----------------------------------------------------------------+");
        System.out.println("\t  Zoo Wolrd App :: Modulo de Países :: Nuevo Pais");
        System.out.println("+----------------------------------------------------------------+\n");

        System.out.print("Ingrese el nombre del nuevo Pais ");
        System.out.println("(para cancelar, no ingresar datos y presionar enter):");
        System.out.println("-------------------------\n");

        keyboard.nextLine();

        while (true) {
            try {
                System.out.print("? ");
                String name = keyboard.nextLine().trim();
                while (!name.matches("^[A-Za-záéíóúüÁÉÍÓÚÜ\\s]+$") && !name.isEmpty()) {
                    MainView.invalidData();
                    name = keyboard.nextLine();
                }
                return name;
            } catch (InputMismatchException e) {
                MainView.invalidData();
                keyboard.next();
            }
        }
    }

    public void choiceContinentIdInfo() {
        System.out.println("Seleccione de la siguiente lista, el continente al que pertenece el pais:");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void newCountryCanceled() {
        System.out.println("Ha cancelado el ingreso de un nuevo Pais\n");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void countryAlreadyExists(String name) {
        System.out.println("Error al guardar, ya existe un pais con el nombre " + name);
        System.out.println(Ansi.RESET);
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void showNewCountry(String name) {
        System.out.println("El pais " + name + " se ha creado exitosamente");
        System.out.println(Ansi.RESET);
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void updateCountryCanceled() {
        System.out.println("Ha cancelado la actualizacion del Pais\n");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void countryNotExist(int id) {
        System.out.println("No existe un pais con el id " + id + " asociado");
        System.out.println("Selecciones un ID valido ó 0 para cancelar");
    }

    public void continentNotExist(int id) {
        System.out.println("No existe un continente con el id " + id + " asociado");
        System.out.println("Selecciones un ID valido o 0 para cancelar");
    }

    public String getNameToUpdate(PaisDTO country) {
        System.out.print("Se actualizará el nombre del siguiente continente: ");
        System.out.println(Ansi.PURPLE + country.getId() + " " + country.getContinente().getNombre() + " " +
                country.getNombre() + Ansi.RESET);

        System.out.print("Ingrese el nuevo nombre del pais para actualizar ");
        System.out.println("(para cancelar, no ingresar datos y presionar enter):\n");

        keyboard.nextLine();

        while (true) {
            try {
                System.out.print("? ");
                String name = keyboard.nextLine().trim();
                while (!name.matches("^[A-Za-záéíóúüÁÉÍÓÚÜ\\s]+$") && !name.isEmpty()) {
                    MainView.invalidData();
                    name = keyboard.nextLine();
                }
                return name;
            } catch (InputMismatchException e) {
                MainView.invalidData();
                keyboard.next();
            }
        }
    }

    public static void selectCountryIdToEdithOrDeleteInfo(String actions) {
        System.out.println("De la siguiente lista de paises, seleccione el id para  " + actions);
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public static void selectContinentIdToEdithInfo(String actions) {
        System.out.println("De la siguiente lista de contienetes, seleccione el id para  " + actions);
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void showUpdateCountry(PaisDTO country) {
        System.out.println("El pais " + country.getNombre() + " (" + country.getContinente().getNombre() + ") se ha actualizado exitosamente");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public int continentIdSelected(String actionOption) {
        switch (actionOption) {
            case Paginator.EDITH:
                actionOption = "editar";
                break;
            case Paginator.DELETE:
                actionOption = "eliminar";
                break;
            case Paginator.SELECT:
                actionOption = "elegir";
                break;
        }
        System.out.println("Ingrese el numero de ID del continente para " + actionOption + " ó 0 para cancelar: \n");

        while (true) {
            try {
                System.out.print("? ");
                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar un id valido");
                keyboard.next();
            }
        }
    }

    public Boolean getResponseToDelete(PaisDTO country) {
        System.out.print("Se Eliminará el siguiente pais: ");
        System.out.println(Ansi.PURPLE + country.getId() + " " + country.getNombre() + " " + country.getContinente().getNombre() + Ansi.RESET);


        System.out.println("Esta seguro que desea eliminarlo? ");
        System.out.println("| 1 | Si");
        System.out.println("| 2 | No");

        keyboard.nextLine();

        while (true) {
            try {
                System.out.print("? ");
                String name = keyboard.nextLine().trim();
                while (!name.matches("^[1-2]+$") && !name.isEmpty()) {
                    System.out.println("Error, debe ingresar una opcion valida");
                    name = keyboard.nextLine();
                }
                return "1".equals(name);
            } catch (InputMismatchException e) {
                System.out.println("Error, debe ingresar una opcion valida");
                keyboard.next();
            }
        }
    }

    public void showDeleteCountry(String name) {
        System.out.println("El Pais " + name + " se ha eliminado exitosamente");
        ScannerSingleton.pressEnterKeyToContinue();
    }

    public void deleteCountryCanceled() {
        System.out.println("Ha cancelado la eliminacion del Pais");
        ScannerSingleton.pressEnterKeyToContinue();

    }
}
