package com.mthree.dvdlibrary.dao;

import com.mthree.dvdlibrary.dto.DVD;

import java.util.List;

public interface DVDLibraryDao {

    /**
     * Adds the given DVD to the list and associates it with the given title.
     * If the DVD already exists it will overwrite it.
     * @param title title the movie will be associated with
     * @param dvd DVD to be added to library
     * @return the DVD object that was added to the library
     * @throws DVDLibraryDaoException
     */
    DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException;


    /**
     *  Returns the DVD associated with the title
     * @param title title of DVD
     * @return DVD object associated with title, null if no association exists
     * @throws DVDLibraryDaoException
     */
    DVD getDVD(String title) throws DVDLibraryDaoException;

    /**
     * Removes DVD from list that is associated with title
     *
     * @param title title of DVD
     * @return DVD that was removed
     * @throws DVDLibraryDaoException
     */
    DVD removeDVD(String title) throws DVDLibraryDaoException;

    /**
     * Changes a DVD associated with title to be associated with the new
     * edited DVD object
     *
     * @param title title of movie to be edited
     * @param editedDVD DVD that was edited
     * @return DVD that was edited
     * @throws DVDLibraryDaoException
     */
    DVD editDVD(String title, DVD editedDVD) throws DVDLibraryDaoException;

    /**
     * Retruns a list of all DVDs in the library
     *
     * @return A list of all DVDs in the library
     * @throws DVDLibraryDaoException
     */
    List<DVD> getAllDVDs() throws DVDLibraryDaoException;

    /**
     *  Searchs the library for DVDs with a title containing searchString
     * @param searchString string to search for
     * @return A list of DVDs with titles that contain searchString
     * @throws DVDLibraryDaoException
     */
    List<DVD> searchTitles(String searchString) throws DVDLibraryDaoException;

}
