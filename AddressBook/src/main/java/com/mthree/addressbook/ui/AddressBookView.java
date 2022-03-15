package com.mthree.addressbook.ui;

import com.mthree.addressbook.dto.Address;

import java.util.List;

public class AddressBookView {

    private UserIO io;

    public AddressBookView(UserIO io) {
        this.io = io;
    }


    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. Add Address");
        io.print("2. Edit Address");
        io.print("3. Delete Address");
        io.print("4. View Address");
        io.print("5. List Address Count");
        io.print("6. List All Addresses");
        io.print("7. Exit");
        return io.readInt("");

    }

    public void displayCreateAddressBanner() {
        io.print("Create Address Menu:");
    }

    public Address getNewAddressInfo() {
        String lastName = io.readString("Please enter last name: ");
        String firstName = io.readString("Please enter first name: ");
        String streetAddress = io.readString("Please enter street address: ");
        Address newAddress = new Address(lastName);
        newAddress.setFirstName(firstName);
        newAddress.setStreetAddress(streetAddress);
        return newAddress;
    }

    public void displayAddSuccessBanner() {
        io.readString("Address added, press enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("List Address Menu:");
    }

    public void displayAddressList(List<Address> addressList) {
        for(Address a : addressList){
           displayAddress(a);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAddressBanner() {
        io.print("Find Address Menu:");
    }

    public String getLastNameChoice() {
       return io.readString("Please enter last name: ");
    }

    public void displayAddress(Address address) {
        io.print(address.getFirstName() + " " + address.getLastName());
        io.print(address.getStreetAddress());
        io.readString("Please hit enter to continue.");

    }

    public void displayRemoveAddressBanner() {
        io.print("Remove Address Menu:");
    }

    public void displayRemoveResult(Address removedAddress) {
        if(removedAddress != null)
            io.print("Address successfully removed");
        else
            io.print("No such address");

        io.readString("Please hit enter to continue.");
    }

    public void displayListAddressCountBanner() {
        io.print("List Address Count Menu:");
    }

    public void displayAddressListCount(List<Address> addressList) {
        io.print("There are " + addressList.size() + " addresses in the list");
        io.readString("Please hit enter to continue.");
    }

    public void displayEditAddressBanner() {
        io.print("Edit Address Menu:");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown command");
    }

    public void displayExitBanner() {
        io.print("Thank you for using, Goodbye");
    }

    public void displayErrorMessage(String message) {
        io.print("...ERROR...");
        io.print(message);
    }

    public Address editAddressInfo() {
        String lastName = io.readString("Please enter the new last name: ");
        String firstName = io.readString("Please enter the new first name: ");
        String streetAddress = io.readString("Please enter the new street address: ");
        Address newAddress = new Address(lastName);
        newAddress.setFirstName(firstName);
        newAddress.setStreetAddress(streetAddress);
        return newAddress;
    }
}
