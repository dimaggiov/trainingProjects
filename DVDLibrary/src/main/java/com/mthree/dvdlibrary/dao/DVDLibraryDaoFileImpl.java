package com.mthree.dvdlibrary.dao;

import com.mthree.dvdlibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public static final String DVDLIBRARY_FILE = "dvdLibrary.txt";
    public static final String DELIMITER = "::";
    private Map<String,DVD> dvds = new HashMap<>();


    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
        loadDVDs();
        DVD newDVD = dvds.put(title, dvd);
        writeDVDs();
        return newDVD;
    }

    @Override
    public DVD getDVD(String title) throws DVDLibraryDaoException {
        loadDVDs();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibraryDaoException {
        loadDVDs();
        DVD newDVD = dvds.remove(title);
        writeDVDs();
        return newDVD;
    }

    @Override
    public DVD editDVD(String title,DVD editedDVD) throws DVDLibraryDaoException {
        if(editedDVD != null) {
            loadDVDs();
            removeDVD(title);
            addDVD(title, editedDVD);
            writeDVDs();
            return editedDVD;
        }
        else
            return null;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
        loadDVDs();
        return new ArrayList(dvds.values());
    }

    @Override
    public List<DVD> searchTitles(String searchString) throws DVDLibraryDaoException{
        loadDVDs();
        List<DVD> dvdsFound = new ArrayList<>();
        List<String> titles = new ArrayList(dvds.keySet());

        for (String t : titles)
            if(t.toLowerCase().contains(searchString.toLowerCase()))
                dvdsFound.add(dvds.get(t));

        return dvdsFound;
    }


    private void loadDVDs() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("Could not load DVD data into memory.", e);
        }

        String currentLine;
        DVD currentDVD;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvds.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();

    }

    private void writeDVDs() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVDLIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save DVD data.", e);
        }


        String DVDAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            DVDAsText = marshallDVD(currentDVD);
            out.println(DVDAsText);
            out.flush();
        }

        out.close();

    }

    private String marshallDVD(DVD dvd) {
        String dvdAsString = dvd.getTitle() + DELIMITER;
        dvdAsString += dvd.getReleaseDate() + DELIMITER;
        dvdAsString += dvd.getRating() + DELIMITER;
        dvdAsString += dvd.getDirector() + DELIMITER;
        dvdAsString += dvd.getNote() + DELIMITER;
        return dvdAsString;
    }

    private DVD unmarshallDVD(String dvdAsString) {
        String[] dvdTokens = dvdAsString.split(DELIMITER);
        DVD dvdFromFile = new DVD(dvdTokens[0]);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setRating(dvdTokens[2]);
        dvdFromFile.setDirector(dvdTokens[3]);
        dvdFromFile.setNote(dvdTokens[4]);

        return dvdFromFile;
    }


}
