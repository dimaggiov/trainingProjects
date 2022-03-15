package com.mthree.addressbook;

import com.mthree.addressbook.controller.AddressBookController;
import com.mthree.addressbook.dao.AddressBookAuditDao;
import com.mthree.addressbook.dao.AddressBookAuditDaoFileImpl;
import com.mthree.addressbook.dao.AddressBookDao;
import com.mthree.addressbook.dao.AddressBookDaoFileImpl;
import com.mthree.addressbook.dto.Address;
import com.mthree.addressbook.service.AddressBookServiceLayer;
import com.mthree.addressbook.service.AddressBookServiceLayerImpl;
import com.mthree.addressbook.ui.AddressBookView;
import com.mthree.addressbook.ui.UserIO;
import com.mthree.addressbook.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookAuditDao myAuditDao = new AddressBookAuditDaoFileImpl();
        AddressBookServiceLayer myService = new AddressBookServiceLayerImpl(myDao,myAuditDao);
        AddressBookController controller = new AddressBookController(myView, myService);
        controller.run();
    }
}
