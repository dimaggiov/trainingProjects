package com.mthree.vendingmachine.controller;

import com.mthree.vendingmachine.dao.VendingMachinePersistenceException;
import com.mthree.vendingmachine.dto.VendingMachineItem;
import com.mthree.vendingmachine.service.InsufficientFundsException;
import com.mthree.vendingmachine.service.NoItemInventoryException;
import com.mthree.vendingmachine.service.VendingMachineServiceLayer;
import com.mthree.vendingmachine.ui.UserIO;
import com.mthree.vendingmachine.ui.UserIOConsoleImpl;
import com.mthree.vendingmachine.ui.VendingMachineView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class VendingMachineController {

    private VendingMachineView view;
    private UserIO io = new UserIOConsoleImpl();
    private VendingMachineServiceLayer service;

    @Autowired
    public VendingMachineController(VendingMachineView view, VendingMachineServiceLayer service) {
        this.view = view;
        this.service = service;
    }

    public void run(){
        boolean keepGoing = true;
        String menuSelection = "";

            while (keepGoing) {
                try {
                    menuSelection = getMenuSelection();
                    try{
                        int foodChoice = Integer.parseInt(menuSelection);
                        sellItem(foodChoice);
                        giveChange();

                    }catch(NumberFormatException formatException){
                        //in this catch menuSelection is not a number handle entering money or
                        switch (menuSelection.charAt(0)){
                            case 'F':
                            case 'f':
                                addFunds();
                                break;
                            case 'E':
                            case 'e':
                                giveChange();
                                view.displayExitMessage();
                                keepGoing = false;
                                break;

                        }
                    }
                } catch (VendingMachinePersistenceException | NoItemInventoryException e) {
                    view.displayErrorMessage(e.getMessage());
                } catch (InsufficientFundsException e){
                    view.displayErrorMessage(e.getMessage());
                    view.displayMoney(service.getFunds());
                }

        }
    }



    private String getMenuSelection() throws VendingMachinePersistenceException{
        return view.getMenuSelection(service.getAllSellableItems());
    }

    private void sellItem(int itemID) throws NoItemInventoryException, VendingMachinePersistenceException, InsufficientFundsException {
        VendingMachineItem vendedItem = service.sellItem(itemID);
        view.displaySuccessfulVend(vendedItem);

    }

    private void addFunds() throws InsufficientFundsException {
        BigDecimal moneyInserted;
        try{
            moneyInserted = view.getMoneyInserted();
            service.addFunds(moneyInserted);
            view.displayFundsAddedSuccess();
        } catch (NumberFormatException e){
            view.displayErrorMessage("Not a vaild number");
        }

    }

    private void giveChange() {
        view.showChangeDispensed(service.dispenseChange());
    }
}
