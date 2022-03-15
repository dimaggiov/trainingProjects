package com.mthree.dvdlibrary;

import com.mthree.dvdlibrary.controller.DVDLibraryController;
import com.mthree.dvdlibrary.dao.DVDLibraryDao;
import com.mthree.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import com.mthree.dvdlibrary.dao.DVDLibraryDaoLambdaImpl;
import com.mthree.dvdlibrary.ui.DVDLibraryView;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Set;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.mthree.dvdlibrary");
        context.refresh();
        DVDLibraryController controller = context.getBean("DVDLibraryController", DVDLibraryController.class);
        controller.run();

    }
}
