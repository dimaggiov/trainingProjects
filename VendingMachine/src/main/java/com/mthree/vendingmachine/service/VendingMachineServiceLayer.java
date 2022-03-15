package com.mthree.vendingmachine.service;

import com.mthree.vendingmachine.dao.VendingMachinePersistenceException;
import com.mthree.vendingmachine.dto.Change;
import com.mthree.vendingmachine.dto.Coin;
import com.mthree.vendingmachine.dto.VendingMachineItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VendingMachineServiceLayer {

    /**
     *
     * Takes an ID and returns the item sold if it exists, is in stock, and there is enough money inserted to pay for it
     *
     * @param itemID ID of item to sell
     * @return VendingMachineItem that was sold if it can be sold
     * @throws VendingMachinePersistenceException when the file fails to read or write from the file
     * @throws InsufficientFundsException when there are not enough funds to purchase the item
     * @throws NoItemInventoryException when there is no item with the specified ID or the item with the specified ID has 0 stock
     */
    VendingMachineItem sellItem(int itemID) throws VendingMachinePersistenceException, InsufficientFundsException, NoItemInventoryException;

    VendingMachineItem getItem(int itemID) throws NoItemInventoryException, VendingMachinePersistenceException;

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

    /**
     *  Adds funds to the vending machine
     * @param moneyInserted money to be added to machine
     */
    void addFunds(BigDecimal moneyInserted) throws InsufficientFundsException;

    /**
     * Gets the amount of money in the vending Machine
     *
     * @return amount of money in vending machine
     */
    BigDecimal getFunds();

    /**
     *
     * @return change to be dispensed
     */
    Map<Coin,Integer> dispenseChange();


}
