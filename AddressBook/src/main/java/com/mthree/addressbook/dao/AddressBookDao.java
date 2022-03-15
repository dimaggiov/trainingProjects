package com.mthree.addressbook.dao;

import com.mthree.addressbook.dto.Address;

import java.util.List;

public interface AddressBookDao {

    Address addAddress(String lastName, Address address) throws AddressBookPersistenceException;

    Address getAddress(String lastName) throws AddressBookPersistenceException;

    Address removeAddress(String lastName) throws AddressBookPersistenceException;

    Address editAddress(String lastName, Address newAddress) throws AddressBookPersistenceException;

    List<Address> getAllAddresses() throws AddressBookPersistenceException;


}
