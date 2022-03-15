package com.mthree.addressbook.service;

import com.mthree.addressbook.dao.AddressBookDao;
import com.mthree.addressbook.dao.AddressBookPersistenceException;
import com.mthree.addressbook.dto.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressBookDaoStubImpl implements AddressBookDao {

    public Address onlyAddress;

    public AddressBookDaoStubImpl() {
        onlyAddress = new Address("testLastName");
        onlyAddress.setStreetAddress("testAddress");
        onlyAddress.setFirstName("testFirstName");
    }

    public AddressBookDaoStubImpl(Address onlyAddress) {
        this.onlyAddress = onlyAddress;
    }

    @Override
    public Address addAddress(String lastName, Address address) throws AddressBookPersistenceException {
        if(lastName.equals(onlyAddress.getLastName()))
            return onlyAddress;

        return null;
    }

    @Override
    public Address getAddress(String lastName) throws AddressBookPersistenceException {
        if(lastName.equals(onlyAddress.getLastName()))
            return onlyAddress;
        return null;
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookPersistenceException {
        if(lastName.equals(onlyAddress.getLastName()))
            return onlyAddress;
        return null;
    }

    @Override
    public Address editAddress(String lastName, Address newAddress) throws AddressBookPersistenceException {
        if(lastName.equals(onlyAddress.getLastName()))
            return onlyAddress;
        return null;
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookPersistenceException {
        List<Address> addressList = new ArrayList<>();
        addressList.add(onlyAddress);
        return addressList;
    }
}
