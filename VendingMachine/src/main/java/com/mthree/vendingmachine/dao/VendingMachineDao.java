package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.Change;
import com.mthree.vendingmachine.dto.VendingMachineItem;

import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineDao {

    /**
     *
     * Takes an ID and returns the item sold if it exists, is in stock, and there is enough money inserted to pay for it
     *
     * @param itemID ID of item to sell
     * @return VendingMachineItem that was sold if it can be sold
     * @throws VendingMachinePersistenceException when the file fails to read or write from the file
     */
    VendingMachineItem sellItem(int itemID) throws VendingMachinePersistenceException;

    /**
     *
     * Takes an ID and returns the item associated with it
     *
     * @param itemID id of item to get
     * @return item found, null if it doesn't exist
     * @throws VendingMachinePersistenceException
     */
    VendingMachineItem getItem(int itemID) throws VendingMachinePersistenceException;

    /**
     *
     * Returns a list of all items in the vending machine
     *
     * @return list of all items in the vending machine
     * @throws VendingMachinePersistenceException when the file fails to read or write from the file
     */
    List<VendingMachineItem> getAllItems() throws VendingMachinePersistenceException;

    /**
     * Returns all items that can be sold to the user
     *
     * @return a list of all items in the vending machine with a stock of 1 or more
     * @throws VendingMachinePersistenceException when the file fails to read or write from the file
     */
    List<VendingMachineItem> getAllSellableItems() throws VendingMachinePersistenceException;

}
