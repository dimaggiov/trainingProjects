package com.mthree.addressbook.dao;

public class AddressBookPersistenceException extends Exception{

    public AddressBookPersistenceException(String message) {
        super(message);
    }

    public AddressBookPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
