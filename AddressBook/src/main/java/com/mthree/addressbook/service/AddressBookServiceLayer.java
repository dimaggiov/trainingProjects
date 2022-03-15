package com.mthree.addressbook.service;

import com.mthree.addressbook.dao.AddressBookPersistenceException;
import com.mthree.addressbook.dto.Address;

import java.util.List;

public interface AddressBookServiceLayer {

    void addAddress(String lastName, Address address) throws
            AddressBookDataValidationException,
            AddressBookDuplicateException,
            AddressBookPersistenceException;

    List<Address> getAllAddresses() throws AddressBookPersistenceException;

    Address getAddress(String lastName) throws AddressBookPersistenceException;

    Address removeAddress(String lastName) throws AddressBookPersistenceException;

    Address editAddress(String lastName, Address address)throws AddressBookPersistenceException;

}
