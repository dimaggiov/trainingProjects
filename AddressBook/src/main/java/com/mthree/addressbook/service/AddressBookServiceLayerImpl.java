package com.mthree.addressbook.service;

import com.mthree.addressbook.dao.AddressBookAuditDao;
import com.mthree.addressbook.dao.AddressBookDao;
import com.mthree.addressbook.dao.AddressBookPersistenceException;
import com.mthree.addressbook.dto.Address;

import java.util.List;

public class AddressBookServiceLayerImpl implements AddressBookServiceLayer{

    private AddressBookDao dao;
    private AddressBookAuditDao auditDao;

    public AddressBookServiceLayerImpl(AddressBookDao dao, AddressBookAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void addAddress (String lastName, Address address) throws AddressBookDataValidationException, AddressBookDuplicateException, AddressBookPersistenceException {

        if(dao.getAddress(lastName) != null){
            throw new AddressBookDuplicateException("ERROR could not create new address: " + lastName + " address already exists");
        }

        validateAddressData(address);
        dao.addAddress(lastName,address);

        auditDao.writeAuditEntry("Address with last name: " + lastName + " CREATED.");
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookPersistenceException {
        return dao.getAllAddresses();
    }

    @Override
    public Address getAddress(String lastName) throws AddressBookPersistenceException {
        return dao.getAddress(lastName);
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookPersistenceException {
        Address removedAddress = dao.removeAddress(lastName);
        auditDao.writeAuditEntry("Address with last name: " + lastName + " REMOVED.");
        return removedAddress;
    }

    @Override
    public Address editAddress(String lastName, Address address) throws AddressBookPersistenceException{

        auditDao.writeAuditEntry("Address With last name: " + lastName + " EDITED");
        return dao.editAddress(lastName,address);
    }

    private void validateAddressData(Address address) throws AddressBookDataValidationException {
        if(address.getFirstName() == null
                || address.getStreetAddress() == null
                || address.getLastName() == null
                || address.getFirstName().trim().length() == 0
                || address.getLastName().trim().length() == 0
                || address.getStreetAddress().trim().length() == 0){

            throw new AddressBookDataValidationException( "Error Not all fields present");
        }

    }
}
