package com.mthree.vendingmachine.service;

import com.mthree.vendingmachine.dao.VendingMachineDao;
import com.mthree.vendingmachine.dao.VendingMachinePersistenceException;
import com.mthree.vendingmachine.dto.Change;
import com.mthree.vendingmachine.dto.VendingMachineItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDaoStub implements VendingMachineDao {

    public VendingMachineItem onlyItem;
    public BigDecimal money = new BigDecimal(0);

    public VendingMachineDaoStub() {
        onlyItem = new VendingMachineItem(1);
        onlyItem.setStock(5);
        onlyItem.setPrice(new BigDecimal("1.50"));
        onlyItem.setItemName("Skittles");
    }

    @Override
    public VendingMachineItem sellItem(int itemID) throws VendingMachinePersistenceException {
        if(itemID == onlyItem.getId()) {
            onlyItem.sell();
            money = money.subtract(onlyItem.getPrice());
            return onlyItem;
        }
        else
            return null;


    }

    @Override
    public VendingMachineItem getItem(int itemID) throws VendingMachinePersistenceException {
        if(itemID == onlyItem.getId()){
            return onlyItem;
        }
        return null;
    }

    @Override
    public List<VendingMachineItem> getAllItems() throws VendingMachinePersistenceException {
        List<VendingMachineItem> returnItems = new ArrayList<>();
        returnItems.add(onlyItem);
        return returnItems;
    }

    @Override
    public List<VendingMachineItem> getAllSellableItems() throws VendingMachinePersistenceException {
        List<VendingMachineItem> returnItems = new ArrayList<>();
        returnItems.add(onlyItem);
        return returnItems;
    }


}
