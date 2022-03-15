package com.mthree.addressbook.controller;

import com.mthree.addressbook.dao.AddressBookDao;
import com.mthree.addressbook.dao.AddressBookPersistenceException;
import com.mthree.addressbook.dto.Address;
import com.mthree.addressbook.service.AddressBookDataValidationException;
import com.mthree.addressbook.service.AddressBookDuplicateException;
import com.mthree.addressbook.service.AddressBookServiceLayer;
import com.mthree.addressbook.ui.AddressBookView;
import com.mthree.addressbook.ui.UserIO;
import com.mthree.addressbook.ui.UserIOConsoleImpl;

import java.util.List;

public class AddressBookController {

    private AddressBookView view;
    private UserIO io = new UserIOConsoleImpl();
    private AddressBookServiceLayer service;

    public AddressBookController(AddressBookView view, AddressBookServiceLayer service){
        this.view = view;
        this.service = service;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        addAddress();
                        break;
                    case 2:
                        editAddress();
                        break;
                    case 3:
                        deleteAddress();
                        break;
                    case 4:
                        viewAddress();
                        break;
                    case 5:
                        listAddressCount();
                        break;
                    case 6:
                        listAllAddresses();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (AddressBookPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addAddress() throws AddressBookPersistenceException {
        view.displayCreateAddressBanner();
        boolean hasErrors = false;
        do{
            Address newAddress = view.getNewAddressInfo();
            try {
                service.addAddress(newAddress.getLastName(), newAddress);
                view.displayAddSuccessBanner();
                hasErrors = false;
            } catch (AddressBookDuplicateException | AddressBookDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        }while(hasErrors);


    }

    private void listAllAddresses() throws AddressBookPersistenceException {
        view.displayDisplayAllBanner();
        List<Address> addressList = service.getAllAddresses();
        view.displayAddressList(addressList);
    }

    private void viewAddress() throws AddressBookPersistenceException {
        view.displayDisplayAddressBanner();
        String lastName = view.getLastNameChoice();
        Address address = service.getAddress(lastName);
        view.displayAddress(address);
    }

    private void deleteAddress() throws AddressBookPersistenceException {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoice();
        Address removedAddress = service.removeAddress(lastName);
        view.displayRemoveResult(removedAddress);
    }

    private void listAddressCount() throws AddressBookPersistenceException {
        view.displayListAddressCountBanner();
        List<Address> addressList = service.getAllAddresses();
        view.displayAddressListCount(addressList);
    }

    private void editAddress() throws AddressBookPersistenceException {
        view.displayEditAddressBanner();
        String lastName = view.getLastNameChoice();
        Address newAddress = view.editAddressInfo();
        Address editedAddress = service.editAddress(lastName, newAddress);
        view.displayAddress(editedAddress);
    }
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
