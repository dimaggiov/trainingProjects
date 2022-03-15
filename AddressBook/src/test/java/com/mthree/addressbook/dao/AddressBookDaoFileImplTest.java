package com.mthree.addressbook.dao;

import com.mthree.addressbook.dto.Address;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookDaoFileImplTest {

    AddressBookDao testDao;

    public AddressBookDaoFileImplTest() {
    }

    @BeforeEach
    void setUp() throws Exception{
        String testFile = "testbook.txt";
        new FileWriter(testFile);

        testDao = new AddressBookDaoFileImpl(testFile);
    }

    @Test
    void testAddGetAddress() throws Exception{
        //create input
        String lastName = "DiMaggio";
        Address address = new Address(lastName);
        address.setStreetAddress("address");
        address.setFirstName("Vinny");

        //add and retrieve
        testDao.addAddress(lastName, address);
        Address retrievedAddress = testDao.getAddress(lastName);

        //check
        assertEquals(address.getLastName(),retrievedAddress.getLastName(), "checking last name");
        assertEquals(address.getFirstName(),retrievedAddress.getFirstName(), "checking first name");
        assertEquals(address.getStreetAddress(),retrievedAddress.getStreetAddress(), "checking address");

    }

    @Test
    void testAddGetAllAddresses() throws Exception {
        //create input
        String lastName = "DiMaggio";
        Address address = new Address(lastName);
        address.setStreetAddress("address");
        address.setFirstName("Vinny");

        String lastName2 = "DiMaggio2";
        Address address2 = new Address(lastName2);
        address2.setStreetAddress("address2");
        address2.setFirstName("Vinny2");

        //add both
        testDao.addAddress(lastName, address);
        testDao.addAddress(lastName2, address2);

        //get the list of addresses
        List<Address> addresses = testDao.getAllAddresses();

        //general check for size
        assertEquals(2, addresses.size(), "There should be 2 addresses");

        //specific check for if each of them are in the list
        assertTrue(addresses.contains(address), "list should include first case \"DiMaggio\"");
        assertTrue(addresses.contains(address2), "list should include first case \"DiMaggio2\"");

    }

    @Test
    public void testRemoveStudent() throws Exception {

        //create input
        String lastName = "DiMaggio";
        Address address = new Address(lastName);
        address.setStreetAddress("address");
        address.setFirstName("Vinny");

        String lastName2 = "DiMaggio2";
        Address address2 = new Address(lastName2);
        address2.setStreetAddress("address2");
        address2.setFirstName("Vinny2");

        //add both
        testDao.addAddress(lastName, address);
        testDao.addAddress(lastName2, address2);

        //remove first
        Address removedAddress = testDao.removeAddress(lastName);

        //check that the correct one was removed
        assertEquals(removedAddress, address);

        //get list of all and check that it is removed from list
        List<Address> addressList = testDao.getAllAddresses();
        assertEquals(1, addressList.size());
        assertFalse(addressList.contains(address));
        assertTrue(addressList.contains(address2));

        //remove second and test again
        removedAddress = testDao.removeAddress(lastName2);
        addressList = testDao.getAllAddresses();
        assertEquals(0, addressList.size());
        assertFalse(addressList.contains(address));
        assertFalse(addressList.contains(address2));

        //try to retrieve should be null
        assertNull(testDao.getAddress(lastName));
        assertNull(testDao.getAddress(lastName2));


    }


}