package ar.com.ada.maven.contoller;

import ar.com.ada.maven.model.dao.ContinenteDAO;
import ar.com.ada.maven.model.dao.PaisDAO;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.PaisDTO;
import ar.com.ada.maven.utils.Paginator;
import ar.com.ada.maven.view.CountryView;
import ar.com.ada.maven.view.MainView;

import java.util.List;

public class CountryController {

    private static CountryView view = new CountryView();
    private static PaisDAO countryDAO = new PaisDAO(false);
    private static ContinenteDAO continentDAO = new ContinenteDAO(false);

    static void init() {
        boolean shouldGetOut = false;

        while (!shouldGetOut) {
            int option = view.continentMenuSelectOption();
            switch (option) {
                case 1:
                    listAllCountries();
                    break;
                case 2:
                    createNewCountry();
                    break;
                case 3:
                    edithCountry();
                    break;
                case 4:
                    deleteCountry();
                    break;
                case 5:
                    shouldGetOut = true;
                    break;
                default:
                    MainView.chooseValidOption();
            }
        }
    }

    private static void listAllCountries() {
        listCountriesPerPage(null, true);
    }

    private static void createNewCountry() {
        String nameNewCountry = view.getNameNewCountry();

        if (!nameNewCountry.isEmpty()) {
            view.choiceContinentIdInfo();

            int continentId = ContinentController.continentListPerPage(Paginator.SELECT, false);

            if (continentId != 0) {
                PaisDTO countryByName = countryDAO.findByName(nameNewCountry);
                ContinenteDTO continentById = continentDAO.findById(continentId);

                PaisDTO newCountry = new PaisDTO(nameNewCountry, continentById);

                if (countryByName != null && countryByName.equals(newCountry)) {
                    view.countryAlreadyExists(newCountry.getNombre());
                } else {
                    Boolean isSaved = countryDAO.save(newCountry);
                    if (isSaved)
                        view.showNewCountry(newCountry.getNombre());
                }
            } else {
                view.newCountryCanceled();
            }
        } else {
            view.newCountryCanceled();
        }
    }

    private static int listCountriesPerPage(String optionSelectEdithOrDelete, boolean showHeader) {
        int limit = 4, currentPage = 0, totalCountries, totalPages, continentIdSelected = 0;
        List<PaisDTO> countries;
        List<String> paginator;
        boolean shouldGetOut = false;

        while (!shouldGetOut) {
            totalCountries = countryDAO.getTotalCountries();
            totalPages = (int) Math.ceil((double) totalCountries / limit);
            paginator = Paginator.buildPaginator(currentPage, totalPages);

            countries = countryDAO.findAll(limit, currentPage * limit);
            String choice = view.printContinentsPerPage(countries, paginator, optionSelectEdithOrDelete, showHeader);

            switch (choice) {
                case "i":
                case "I":
                    currentPage = 0;
                    break;
                case "a":
                case "A":
                    if (currentPage > 0) currentPage--;
                    break;
                case "s":
                case "S":
                    if (currentPage + 1 < totalPages) currentPage++;
                    break;
                case "u":
                case "U":
                    currentPage = totalPages - 1;
                    break;
                case "e":
                case "E":
                    if (optionSelectEdithOrDelete != null) {
                        continentIdSelected = view.continentIdSelected(optionSelectEdithOrDelete);
                        shouldGetOut = true;
                    }
                    break;
                case "q":
                case "Q":
                    shouldGetOut = true;
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

    private static void edithCountry() {
        PaisDTO countryToEdith = getCountryToEdithOrDelete(Paginator.EDITH);

        if (countryToEdith != null) {
            String nameToUpdate = view.getNameToUpdate(countryToEdith);

            if (nameToUpdate.isEmpty()) {
                view.updateCountryCanceled();
            } else {
                ContinenteDTO continentToUpdate = getContinentToUpdate(countryToEdith);

                countryToEdith.setContinente(continentToUpdate);
                countryToEdith.setNombre(nameToUpdate);

                Boolean isUpdate = countryDAO.update(countryToEdith);

                if (isUpdate)
                    view.showUpdateCountry(countryToEdith);
            }

        } else {
            view.updateCountryCanceled();
        }
    }

    private static PaisDTO getCountryToEdithOrDelete(String optionEdithOrDelete) {
        boolean hasExitWhile = false;
        PaisDTO countryToEdithOrDelete = null;

        String actionInfo = Paginator.EDITH.equals(optionEdithOrDelete) ? "Editar" : "Eliminar";

        view.selectCountryIdToEdithOrDeleteInfo(actionInfo);

        int countryIdToEdith = listCountriesPerPage(optionEdithOrDelete, true);

        if (countryIdToEdith != 0) {
            while (!hasExitWhile) {
                countryToEdithOrDelete = countryDAO.findById(countryIdToEdith);
                if (countryToEdithOrDelete == null) {
                    view.countryNotExist(countryIdToEdith);
                    countryIdToEdith = view.continentIdSelected(optionEdithOrDelete);
                    hasExitWhile = (countryIdToEdith == 0);
                } else {
                    hasExitWhile = true;
                }
            }
        }

        return countryToEdithOrDelete;
    }

    private static ContinenteDTO getContinentToUpdate(PaisDTO countryToEdith) {
        boolean hasExitWhile = false;
        ContinenteDTO continentById = null;

        view.selectContinentIdToEdithInfo("Actualizar");

        int continentIdSelected = ContinentController.continentListPerPage(Paginator.SELECT, false);

        if (continentIdSelected != 0) {
            while (!hasExitWhile) {
                continentById = continentDAO.findById(continentIdSelected);
                if (continentById == null) {
                    view.countryNotExist(continentIdSelected);
                    continentIdSelected = view.continentIdSelected(Paginator.SELECT);
                    hasExitWhile = (continentIdSelected == 0);
                } else {
                    hasExitWhile = true;
                }
            }
        }

        return continentById != null && !countryToEdith.getContinente().equals(continentById) ?
                continentById :
                countryToEdith.getContinente();
    }

    private static void deleteCountry() {
        PaisDTO countryToDelete = getCountryToEdithOrDelete(Paginator.DELETE);

        if (countryToDelete != null) {
            Boolean toDelete = view.getResponseToDelete(countryToDelete);
            if (toDelete) {
                Boolean isDeleted = countryDAO.delete(countryToDelete.getId());

                if (isDeleted)
                    view.showDeleteCountry(countryToDelete.getNombre());
            }

        } else {
            view.deleteCountryCanceled();
        }
    }
}
