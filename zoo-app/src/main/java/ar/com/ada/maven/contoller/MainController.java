package ar.com.ada.maven.contoller;

import ar.com.ada.maven.view.MainView;

public class MainController {
    private static MainView view = new MainView();

    public static void run() {
        boolean shouldGetOut = false;
        //boolean runn = false;
        while (!shouldGetOut) {
            //Integer select = view.selectOption();
            int option = view.mainMenuSelectOption();
            switch (option) {
                case 1:
                    ContinentController.init();
                    break;
                case 2:
                    CountryController.init();
                    break;
                case 4:
                    shouldGetOut = true;
                    break;
                default:
                    System.out.println("Opcion no valida, vuelva a seleccionar");
            }


        }
    }
}

