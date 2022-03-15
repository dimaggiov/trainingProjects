package com.mthree.vendingmachine.dao;

import com.mthree.vendingmachine.dto.VendingMachineItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;

class VendingMachineDaoFileImplTest {

    VendingMachineDao dao = new VendingMachineDaoFileImpl("TESTMACHINE.txt");

    @BeforeEach
    void setUp() throws Exception {

        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter("TESTMACHINE.txt"));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException("Could not open test file", e);
        }

        //add 3 valid entries to the list for testing
        out.println("1::5::1.50::Skittles");
        out.println("2::1::1.25::M&Ms");
        out.println("3::0::.75::Pringles");
        out.flush();
    }

    @Test
    void sellItem() throws Exception {
        //create VendingMachineItem object same as one in file
        VendingMachineItem skittles = new VendingMachineItem(1);
        skittles.setStock(5);
        skittles.setPrice(new BigDecimal("1.50"));
        skittles.setItemName("Skittles");

        VendingMachineItem soldItem = dao.sellItem(1);

        //check correct item is sold
        assertEquals(skittles, soldItem);
        //check stock decremented
        assertEquals(4, soldItem.getStock());
    }



}