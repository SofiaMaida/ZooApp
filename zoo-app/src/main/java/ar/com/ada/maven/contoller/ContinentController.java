package ar.com.ada.maven.contoller;

import ar.com.ada.maven.model.dao.ContinenteDAO;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.utils.Ansi;
import ar.com.ada.maven.utils.Paginator;
import ar.com.ada.maven.view.ContinentView;
import ar.com.ada.maven.view.MainView;

import java.util.List;

public class ContinentController {

    private static ContinentView view = new ContinentView();
    private static ContinenteDAO continenteDAO = new ContinenteDAO();

    public static void init() {
        //boolean initial = false;
        boolean shouldGetOut = false;

        while (!shouldGetOut) {
            int option = view.continentMenuSelectOption();
            switch (option) {
                case 1:
                    continentList();
                    break;
                case 2:
                    createNewContinent();
                    //initial = true;
                    break;
                case 3:
                    edithContinent();
                    break;
                case 4:
                    deleteContinent();
                    break;
                case 5:
                    shouldGetOut = true;
                    break;
                default:
                    System.out.println("Opcion no valida, vuelva a seleccionar");
            }
        }

    }

    private static void continentList() {
        continentListPerPage(null, true);
        List<ContinenteDTO> continents = continenteDAO.findAll();
        view.printAllContinents(continents);

    }

    public static void createNewContinent() {
        //continentName: "lala" almacena el dato ingresado
        String continentName = view.getNameNewContinent();
        if (!continentName.isEmpty()) {
            //se convierte en objeto lo que ingreso el usuario, para aparecer en "lista" despues
            //ContinenteDTO {id = 0, nombre = "lolo"}
            ContinenteDTO newContinent = new ContinenteDTO(continentName);
            //byName = null continentName = "lolo"
            ContinenteDTO byName = continenteDAO.findByName(continentName);
            //byName = null
            if (byName != null && byName.getNombre().equals(newContinent.getNombre())) {
                view.continentAlreadyExists(newContinent.getNombre());
            //ya se guardo
            } else {
                Boolean isSaved = continenteDAO.save(newContinent);
                if (isSaved)
                    view.showNewContinent(newContinent.getNombre());
            }
        } else {
            view.newContinentCanceled();
        }

    }

    private static void edithContinent() {
        int continentIdToEdith = continentListPerPage(Paginator.EDITH, true);
        if (continentIdToEdith != 0)
            editSelectedContinent(continentIdToEdith);
        else
            view.updateContinentCanceled();
    }

    private static void deleteContinent() {
        String optionDelete = "[" + "E" + Ansi.RESET + "liminar]";
        int continentIdToDelete = continentListPerPage(optionDelete, true);
        if (continentIdToDelete != 0)
            deleteSelectedContinent(continentIdToDelete);
        else
            view.updateContinentCanceled();
    }

    public static int continentListPerPage(String optionSelectedEdithOrDelete, boolean showHeader) {
        int limit = 3, currentPage = 0, totalPages, totalCountries, continentIdSelected = 0;
        //int numberContinents;
        List<ContinenteDTO> continents = null;
        Boolean shouldtGetOut = false;
        List<String> paginator;

        while (!shouldtGetOut) {
            totalCountries = continenteDAO.getTotalContinents();
            //continents = continenteDAO.findAll(limit, currentPage * limit);
            //numberContinents = continenteDAO.getTotalContinents();
            //totalPages = (int) Math.ceil((double) numberContinents / limit);
            totalPages = (int) Math.ceil((double) totalCountries / limit);
            paginator = Paginator.buildPaginator(currentPage, totalPages);

            String choice = view.printContinentsPerPage(continents, paginator, optionSelectedEdithOrDelete, showHeader);

            switch (choice) {
                case "i":
                case "I":
                    currentPage = 0;
                    break;
                case "a":
                case "A":
                    if (currentPage > 0)
                        currentPage--;
                    break;
                case "s":
                case "S":
                    if (currentPage + 1 < totalPages)
                        currentPage++;
                    break;
                case "u":
                case "U":
                    currentPage = totalPages - 1;
                    break;
                case "e":
                case "E":
                    if (optionSelectedEdithOrDelete != null) {
                        continentIdSelected = view.continentIdSelected(optionSelectedEdithOrDelete);
                        shouldtGetOut = true;
                    }
                    //String action = (hasEdith) ? "Editar" : "Eliminar";
                    //return view.continentIdSelected(action);
                //return view.continentIdSelected("Editar");
                //currentPage = totalPages - 1;
                case "q":
                case "Q":
                    shouldtGetOut = true;
                    break;
                default:
                    if (choice.matches("^-?\\d+$")) {
                        int page = Integer.parseInt(choice);
                        if (page > 0 && page <= totalPages) currentPage = page - 1;
                    } else MainView.chooseValidOption();
            }
        }
        return continentIdSelected;
    }

    private static void editSelectedContinent(int id) {
        ContinenteDTO continent = continenteDAO.findById(id);
        if (continent != null) {
            String nameToUpdate = view.getNameUpdate(continent);
            if (!nameToUpdate.isEmpty()) {
                continenteDAO.findByName(nameToUpdate);
                continent.setNombre(nameToUpdate);

                Boolean isSaved = continenteDAO.update(continent);

                if (isSaved)
                    view.showUpdateContinent(continent.getNombre());
            } else
                view.updateContinentCanceled();
        } else {
            view.continentNotExist(id);
            int continentIdSelected = view.continentIdSelected("Editar");
            if (continentIdSelected != 0) {
                editSelectedContinent(continentIdSelected);
            } else {
                view.updateContinentCanceled();
            }
        }
    }

    private static void deleteSelectedContinent(int id) {
        ContinenteDTO continent = continenteDAO.findById(id);
        if (continent != null) {
            Boolean nameToDelete = view.getNameDelete(continent);
            if (nameToDelete != null) {

                Boolean isDelete = continenteDAO.delete(id);

                if (isDelete)
                    view.deleteContinentCanceled(continent.getNombre());

            } else {
                view.continentNotExist(id);
            }
        } else {
            view.continentNotExist(id);
            int continentIdSelected = view.continentIdSelected("Eliminar");
            if (continentIdSelected != 0) {
                editSelectedContinent(continentIdSelected);
            } else {
                view.updateContinentCanceled();
            }
        }

    }


}
