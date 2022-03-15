package com.mthree.vendingmachine.service;

import com.mthree.vendingmachine.dao.VendingMachineAuditDao;
import com.mthree.vendingmachine.dao.VendingMachinePersistenceException;

public class VendingMachineAuditDaoStub implements VendingMachineAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException {
    }
}
