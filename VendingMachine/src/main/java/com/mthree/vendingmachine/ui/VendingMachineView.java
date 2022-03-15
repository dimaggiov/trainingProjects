package com.mthree.vendingmachine.ui;

import com.mthree.vendingmachine.dto.Coin;
import com.mthree.vendingmachine.dto.VendingMachineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
public class VendingMachineView {

    private UserIO io;

    @Autowired
    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public void displayExitMessage() {
        io.print("Thank you for using the vending machine. Goodbye!");
    }

    public String getMenuSelection(List<VendingMachineItem> allSellableItems) {

        for (VendingMachineItem item : allSellableItems) {
            io.print("(" + item.getId() + ") " + item.getItemName() + " $" + item.getPrice() );
        }
        io.print("(F) Add funds");
        io.print("(E) Exit");
        return io.readString("Enter Choice: ");
    }

    public void displaySuccessfulVend(VendingMachineItem item) {
        io.print(item.getItemName() + " successfully vended");

    }

    public BigDecimal getMoneyInserted() {
        String inputString = io.readString("Enter money to add: ");
        return new BigDecimal(inputString);
    }

    public void displayFundsAddedSuccess() {
        io.print("Money added successfully");
    }

    public void showChangeDispensed(Map<Coin, Integer> change) {
        io.print("Change Vended...");
        io.print("Q:" + change.get(Coin.QUARTER) + " D:" + change.get(Coin.DIME)
                + " N:" + change.get(Coin.NICKEL) + " P:" + change.get(Coin.PENNIE));
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }

    public void displayMoney(BigDecimal funds) {
        io.print("$" + funds + " currently in machine.");
    }
}
