package com.mthree.vendingmachine.service;

import com.mthree.vendingmachine.dao.VendingMachineAuditDao;
import com.mthree.vendingmachine.dao.VendingMachineDao;
import com.mthree.vendingmachine.dao.VendingMachinePersistenceException;
import com.mthree.vendingmachine.dto.Change;
import com.mthree.vendingmachine.dto.Coin;
import com.mthree.vendingmachine.dto.VendingMachineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer{

    VendingMachineDao dao;
    private VendingMachineAuditDao auditDao;
    private BigDecimal moneyInMachine = new BigDecimal("0");

    @Autowired
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public VendingMachineItem sellItem(int itemID) throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException {

        if(dao.getItem(itemID) == null)
            throw new NoItemInventoryException("Item does not exist");

        if(dao.getItem(itemID).getStock() == 0)
            throw new NoItemInventoryException("Item is not in stock");


        if(moneyInMachine.compareTo(dao.getItem(itemID).getPrice()) < 0){
            throw new InsufficientFundsException("Not enough money");
        }

        auditDao.writeAuditEntry("Item with ID: " + itemID + " sold");


        VendingMachineItem soldItem = dao.sellItem(itemID);
        moneyInMachine = moneyInMachine.subtract(soldItem.getPrice());
        return soldItem;
    }

    @Override
    public VendingMachineItem getItem(int itemID) throws NoItemInventoryException, VendingMachinePersistenceException {
        return dao.getItem(itemID);
    }

    @Override
    public List<VendingMachineItem> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public List<VendingMachineItem> getAllSellableItems() throws VendingMachinePersistenceException {
        return dao.getAllSellableItems();
    }

    @Override
    public void addFunds(BigDecimal moneyInserted) throws InsufficientFundsException {
        BigDecimal zero = new BigDecimal("0");
        if(moneyInserted.compareTo(zero) <= 0){
            throw new InsufficientFundsException("can not add negative amount");
        }
        moneyInMachine = moneyInMachine.add(moneyInserted);
    }

    @Override
    public BigDecimal getFunds() {
        return moneyInMachine;
    }

    @Override
    public Map<Coin,Integer> dispenseChange() {
        int cents = moneyInMachine.multiply(new BigDecimal("100")).intValue();
        moneyInMachine = new BigDecimal("0");
        Change change = new Change(cents);

        Map<Coin,Integer> changeMap = new HashMap<>();
        changeMap.put(Coin.QUARTER, change.getQuarters());
        changeMap.put(Coin.DIME, change.getDimes());
        changeMap.put(Coin.NICKEL, change.getNickels());
        changeMap.put(Coin.PENNIE, change.getPennies());

        return changeMap;
    }
}
