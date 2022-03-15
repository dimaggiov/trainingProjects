package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.dao.DVDLibraryDao;
import com.mthree.dvdlibrary.dao.DVDLibraryDaoException;
import com.mthree.dvdlibrary.dao.DVDLibraryDaoLambdaImpl;
import com.mthree.dvdlibrary.dto.DVD;
import com.mthree.dvdlibrary.ui.DVDLibraryView;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
public class DVDLibraryController {

    private DVDLibraryView view;
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibraryDao dao;

    @Autowired
    public DVDLibraryController(DVDLibraryView view, DVDLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVDs();
                        break;
                    case 5:
                        showSingleDVD();
                        break;
                    case 6:
                        searchMultipleDVDs();
                        break;
                    case 7:
                        showMoviesReleasedInYear();
                        break;
                    case 8:
                        showMoviesWithRating();
                        break;
                    case 9:
                        showMoviesByDirector();
                        break;
                    case 0:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                        break;
                }

            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void showMoviesByDirector() throws DVDLibraryDaoException {
        if (dao instanceof DVDLibraryDaoLambdaImpl) {
            Map<String,List<DVD>> dvdsWithRating =((DVDLibraryDaoLambdaImpl) dao).getMoviesWithDirector(view.getDirectorChoice());
            for (List<DVD> dvd: dvdsWithRating.values()) {
                view.displayRatingHeader(dvd);
                view.displayDVDList(dvd);
            }
        }
    }

    private void showMoviesWithRating() throws DVDLibraryDaoException {
        if (dao instanceof DVDLibraryDaoLambdaImpl) {
            List<DVD> dvdsWithRating =((DVDLibraryDaoLambdaImpl) dao).getMoviesWithRating(view.getRatingChoice());
            view.displayDVDList(dvdsWithRating);
        }
    }

    private void showMoviesReleasedInYear() throws DVDLibraryDaoException {
        view.displayMoviesCreatedInYearBanner();
        if (dao instanceof DVDLibraryDaoLambdaImpl) {
            List<DVD> dvdsInYear =((DVDLibraryDaoLambdaImpl) dao).getMoviesReleasedInYear(view.getYearChoice());
            view.displayDVDList(dvdsInYear);
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDVD() throws DVDLibraryDaoException{
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayAddSuccessBanner();
        view.displayWaitMessage();
    }

    private void removeDVD() throws DVDLibraryDaoException{
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVD removedDVD = dao.removeDVD(title);
        view.displayRemoveResult(removedDVD);
        view.displayWaitMessage();
    }

    private void editDVD() throws DVDLibraryDaoException{
        view.displayEditDVDBanner();
        String title = view.getTitleChoice();
        DVD preEditDVD = dao.getDVD(title);
        DVD editedDVD = view.getEditedDVDInfo(preEditDVD);
        dao.editDVD(title, editedDVD);
        view.displayEditResult(editedDVD);
        view.displayWaitMessage();

    }

    private void listDVDs() throws DVDLibraryDaoException{
        view.displayListDVDsBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
        view.displayWaitMessage();
    }

    private void showSingleDVD() throws DVDLibraryDaoException{
        view.displayShowSingleDVDBanner();
        String title = view.getTitleChoice();
        DVD dvdToShow = dao.getDVD(title);
        view.displayDVD(dvdToShow);
        view.displayWaitMessage();
    }

    private void searchMultipleDVDs() throws DVDLibraryDaoException{
        view.displaySearchMultipleDVDBanner();
        String searchString = view.getSearchString();
        List<DVD> dvdsWithPartialTitle = dao.searchTitles(searchString);
        view.displayDVDList(dvdsWithPartialTitle);
        view.displayWaitMessage();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }





}
