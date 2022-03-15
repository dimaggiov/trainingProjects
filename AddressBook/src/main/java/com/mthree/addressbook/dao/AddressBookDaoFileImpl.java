package com.mthree.addressbook.dao;

import com.mthree.addressbook.dto.Address;

import java.io.*;
import java.util.*;

public class AddressBookDaoFileImpl implements AddressBookDao{

    private final String ADDRESS_FILE;
    public static final String DELIMITER = "::";
    private Map<String, Address> addresses = new HashMap<>();

    public AddressBookDaoFileImpl(String addressBookFile) {
        ADDRESS_FILE = addressBookFile;
    }
    public AddressBookDaoFileImpl() {
        ADDRESS_FILE = "address.txt";
    }

    @Override
    public Address addAddress(String lastName, Address address) throws AddressBookPersistenceException {
        loadAddresses();
        Address newAddress = addresses.put(lastName, address);
        writeAddresses();
        return newAddress;
    }

    @Override
    public Address getAddress(String lastName) throws AddressBookPersistenceException {
        loadAddresses();
        return addresses.get(lastName);
    }

    @Override
    public Address editAddress(String lastName, Address newAddress) throws AddressBookPersistenceException {
        loadAddresses();
        removeAddress(lastName);
        addAddress(lastName, newAddress);
        writeAddresses();
        return newAddress;
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookPersistenceException {
        loadAddresses();
        Address removedAddress = addresses.remove(lastName);
        writeAddresses();
        return removedAddress;
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookPersistenceException {
        loadAddresses();
        return new ArrayList<>(addresses.values());
    }

    public void loadAddresses() throws AddressBookPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookPersistenceException("-_- Could not load roster data into memory.", e);
        }

        String currentLine;
        Address currentAddress;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentAddress = unmarshallAddress(currentLine);
            addresses.put(currentAddress.getLastName(), currentAddress);
        }

        scanner.close();
    }

    private void writeAddresses() throws AddressBookPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookPersistenceException("Could not save address data.", e);
        }

        String addressAsText;
        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            addressAsText = marshallAddress(currentAddress);
            out.println(addressAsText);
            out.flush();
        }

        out.close();
    }

    private Address unmarshallAddress(String addressString){
        String[] addressParts = addressString.split(DELIMITER);
        String lastName = addressParts[0];
        Address newAddress = new Address(lastName);
        newAddress.setFirstName(addressParts[1]);
        newAddress.setStreetAddress(addressParts[2]);

        return newAddress;
    }


    private String marshallAddress(Address address){

        String addressString = address.getLastName() + DELIMITER;
        addressString += address.getFirstName() + DELIMITER;
        addressString += address.getStreetAddress();
        return addressString;
    }


}
