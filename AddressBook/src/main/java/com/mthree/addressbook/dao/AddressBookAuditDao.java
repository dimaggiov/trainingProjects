package com.mthree.addressbook.dao;

public interface AddressBookAuditDao {

    public void writeAuditEntry(String entry) throws AddressBookPersistenceException;
}
