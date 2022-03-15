package com.mthree.addressbook.service;

import com.mthree.addressbook.dao.AddressBookAuditDao;
import com.mthree.addressbook.dao.AddressBookPersistenceException;

public class AddressBookAuditDaoStubImpl implements AddressBookAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws AddressBookPersistenceException {
    }
}
