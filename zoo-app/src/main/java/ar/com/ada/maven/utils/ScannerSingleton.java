package ar.com.ada.maven.utils;


import java.util.Scanner;

public class ScannerSingleton {

    //SINGLETON
    //Atributo privado estatico del objeto a retornar
    //Constructor privado para no crear instancias desde otro sitio
    //Metodo publico y estatico que retorna la instancia unica de esa clase

    private static Scanner scannerUnic;

    private ScannerSingleton() {
    }

    public static Scanner getInstance() {
        if (scannerUnic == null)
            scannerUnic = new Scanner(System.in);

        return scannerUnic;
    }

    public static void pressEnterKeyToContinue(){
        System.out.println("Presione enter para continuar");
        ScannerSingleton.getInstance().nextLine();
    }
}

