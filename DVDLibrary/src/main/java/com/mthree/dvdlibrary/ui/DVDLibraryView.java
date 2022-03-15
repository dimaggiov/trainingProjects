package com.mthree.dvdlibrary.ui;

import com.mthree.dvdlibrary.dto.DVD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DVDLibraryView {

    private UserIO io;

    @Autowired
    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    //-----------------------------------------------------------------------------------------------------------------
    // READERS
    //-----------------------------------------------------------------------------------------------------------------

    /**
     * Prints the menu and asks user for selection
     *
     * @return menu selection
     */
    public int printMenuAndGetSelection() {
        io.print("===MAIN MENU===");
        io.print("\t1. Add DVD");
        io.print("\t2. Remove DVD");
        io.print("\t3. Edit DVD");
        io.print("\t4. List all DVDs");
        io.print("\t5. Show DVD Info by Title");
        io.print("\t6. Search for DVD by Title");
        io.print("\t7. Show Movies Released in Year");
        io.print("\t8. Show Movies With Rating");
        io.print("\t9. Show Movies by Director");
        io.print("\t0. Exit");

        return io.readInt("Please select from the above choices: ", 0, 9);
    }

    /**
     * Gets information from user and returns a DVD using that information
     *
     * @return A DVD containing all information read from user+
     */
    public DVD getNewDVDInfo() {
        String title = io.readString("Please enter DVD title: ");
        DVD newDVD = new DVD(title);
        newDVD.setReleaseDate(io.readString("Please enter release date: "));
        newDVD.setRating(io.readString("Please enter MPAA rating: "));
        newDVD.setDirector(io.readString("Please enter the directors name: "));

        String notes = io.readString("Please enter any additional notes: ");
        if (notes.isEmpty())
            newDVD.setNote(" ");
        else
            newDVD.setNote(notes);

        return newDVD;
    }

    /**
     * Prompts user for DVD title and returns their response
     *
     * @return a string containing users response
     */
    public String getTitleChoice() {
        return io.readString("Please enter the title of the DVD (case sensitive): ");
    }

    /**
     * Prompts the user for information to edit a dvd edits the dvd and returns it to the user
     *
     * @param preEditDVD dvd before the edit
     * @return edited DVD
     */
    public DVD getEditedDVDInfo(DVD preEditDVD) {
        if (preEditDVD != null) {
            io.print("DVD before edit: ");
            displayDVD(preEditDVD);
            DVD postEditDVD = new DVD(preEditDVD.getTitle());
            postEditDVD.setReleaseDate(io.readString("Please enter release date: "));
            postEditDVD.setRating(io.readString("Please enter MPAA rating: "));
            postEditDVD.setDirector(io.readString("Please enter the directors name: "));

            String notes = io.readString("Please enter any additional notes: ");
            if (notes.isEmpty())
                postEditDVD.setNote(" ");
            else
                postEditDVD.setNote(notes);

            return postEditDVD;
        } else {
            displayDVD(preEditDVD);
            return null;
        }

    }

    /**
     * Prompts the user for the movie to search for
     * @return a String containing users entry
     */
    public String getSearchString() {
        return io.readString("Please enter the movie to search for: ");
    }

    //-----------------------------------------------------------------------------------------------------------------
    // DISPLAYS
    //-----------------------------------------------------------------------------------------------------------------

    public void displayAddDVDBanner() {
        io.print("===ADD DVD===");
    }

    public void displayAddSuccessBanner() {
        io.print("DVD successfully added");
    }

    public void displayRemoveDVDBanner() {
        io.print("===REMOVE DVD===");
    }

    public void displayEditDVDBanner() {
        io.print("===EDIT DVD===");
    }

    public void displayListDVDsBanner() {
        io.print("===LIST ALL DVDS===");
    }

    public void displayShowSingleDVDBanner() {
        io.print("===SHOW DVD INFO===");
    }

    public void displaySearchMultipleDVDBanner() {
        io.print("===SEARCH FOR DVDS===");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown command");
    }

    public void displayExitBanner() {
        io.print("Thank you for using. Goodbye!");
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }
    public void displayWaitMessage(){
        io.readString("Press enter to continue");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD dvd: dvdList)
            io.print("\t" + dvd.getTitle());
    }

    public void displayDVD(DVD dvdToShow) {
        if(dvdToShow != null) {
            io.print("\t Title: " + dvdToShow.getTitle());
            io.print("\t Release date: " + dvdToShow.getReleaseDate());
            io.print("\t Rating: " + dvdToShow.getRating());
            io.print("\t Director: " + dvdToShow.getDirector());
            io.print("\t Notes: " + dvdToShow.getNote() + "\n");
        }
        else
            io.print("No such movie.");
    }

    public void displayEditResult(DVD editedDVD) {
        io.print("DVD after edit: ");
        displayDVD(editedDVD);
    }

    public void displayRemoveResult(DVD removedDVD) {
        if(removedDVD != null) {
            io.print("The following DVD was removed");
            displayDVD(removedDVD);
        }
        else
            io.print("No such DVD");
    }

    public void displayMoviesCreatedInYearBanner() {
        io.print("Movies in year: ");
    }

    public int getYearChoice() {
        return io.readInt("Enter year: ");
    }

    public String getRatingChoice() {
        return io.readString("Enter Rating: ");
    }

    public String getDirectorChoice() {
        return io.readString("Enter Director Name: ");
    }

    public void displayRatingHeader(List<DVD> dvd) {
        io.print(dvd.get(0).getRating() + ":");
    }
}

