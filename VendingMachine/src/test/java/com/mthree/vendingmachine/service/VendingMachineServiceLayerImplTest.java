package com.mthree.vendingmachine.service;

import com.mthree.vendingmachine.dao.VendingMachineAuditDao;
import com.mthree.vendingmachine.dao.VendingMachineDao;
import com.mthree.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.mthree.vendingmachine.dto.VendingMachineItem;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineServiceLayerImplTest {

    VendingMachineDaoStub dao;
    VendingMachineAuditDaoStub auditDao;
    VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest (){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        service = ctx.getBean("serviceLayer", VendingMachineServiceLayer.class);
        dao = ctx.getBean("vendingMachineDaoStub", VendingMachineDaoStub.class);

    }

    @Test
    void sellItem() throws Exception {
        //try and sell with good item
        try {
            service.addFunds(new BigDecimal("1.50"));
            service.sellItem(1);
        } catch(NoItemInventoryException noItemE) {
            throw new Exception("Item was fine should not throw no item exception");
        } catch(InsufficientFundsException noFundsE) {
            throw new Exception("There were enough funds, no exception should be thrown");
        }

        //test not enough money
        try {
            service.sellItem(1);
            fail("should fail, not enough money");
        } catch(NoItemInventoryException noItemE) {
            fail("Item was fine should not throw no item exception");
        } catch(InsufficientFundsException noFundsE) {}

        //test not enough money
        try {
            service.sellItem(1);
            fail("should fail, not enough money");
        } catch(NoItemInventoryException noItemE) {
            fail("Item was fine should not throw no item exception");
        } catch(InsufficientFundsException noFundsE) {}

        //test no itemID
        try {
            service.addFunds(new BigDecimal("1.50"));
            service.sellItem(2);
            fail("should fail, no such item exists");
        } catch(NoItemInventoryException noItemE) {}
        catch(InsufficientFundsException noFundsE) {
            fail("funds were good should not throw no item exception");
        }

        //test stock is 0
        try {
            dao.onlyItem.setStock(0);
            service.addFunds(new BigDecimal("1.50"));
            service.sellItem(1);
            fail("should fail, stock is 0");
        } catch(NoItemInventoryException noItemE) {}
        catch(InsufficientFundsException noFundsE) {
            fail("funds were good should not throw no item exception");
        }


    }

    @Test
    void getAllItems() throws Exception{
        VendingMachineItem onlyItem = new VendingMachineItem(1);
        onlyItem.setStock(5);
        onlyItem.setPrice(new BigDecimal("1.50"));
        onlyItem.setItemName("Skittles");


        assertEquals(1, service.getAllItems().size());
        assertTrue(service.getAllItems().contains(onlyItem));
    }

    @Test
    void getAllSellableItems() throws Exception {
        VendingMachineItem onlyItem = new VendingMachineItem(1);
        onlyItem.setStock(5);
        onlyItem.setPrice(new BigDecimal("1.50"));
        onlyItem.setItemName("Skittles");


        assertEquals(1, service.getAllSellableItems().size());
        assertTrue(service.getAllSellableItems().contains(onlyItem));
    }

    @Test
    void addFunds() throws Exception{

        try{
            service.addFunds(new BigDecimal("1.25"));
        } catch (InsufficientFundsException e){
            fail("amount was good should not throw exception");
        }

        try{
            service.addFunds(new BigDecimal("0"));
            fail("amount was 0, should not add 0");
        } catch (InsufficientFundsException e){}

        try{
            service.addFunds(new BigDecimal("-1"));
            fail("amount was negative, should not add negative");
        } catch (InsufficientFundsException e){}
    }


}