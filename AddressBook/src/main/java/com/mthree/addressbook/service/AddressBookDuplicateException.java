package com.mthree.addressbook.service;

public class AddressBookDuplicateException extends Exception{
    public AddressBookDuplicateException(String message) {
        super(message);
    }

    public AddressBookDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }
}
