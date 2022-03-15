package com.mthree.addressbook.service;

import com.mthree.addressbook.dao.AddressBookAuditDao;
import com.mthree.addressbook.dao.AddressBookAuditDaoFileImpl;
import com.mthree.addressbook.dao.AddressBookDao;
import com.mthree.addressbook.dao.AddressBookPersistenceException;
import com.mthree.addressbook.dto.Address;
import com.sun.jdi.request.ClassUnloadRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookServiceLayerImplTest {

    private AddressBookServiceLayer service;

    public AddressBookServiceLayerImplTest() {
        AddressBookDao dao = new AddressBookDaoStubImpl();
        AddressBookAuditDao auditDao = new AddressBookAuditDaoStubImpl();

        service = new AddressBookServiceLayerImpl(dao,auditDao);
    }

    @Test
    public void testCreateValidAddress(){
        //create address to add
        Address address = new Address("differentlastname");
        address.setStreetAddress("address");
        address.setFirstName("firstname");

        //try to add
        try{
            service.addAddress(address.getLastName(), address);
        } catch (AddressBookPersistenceException
                | AddressBookDataValidationException
                | AddressBookDuplicateException e){
            fail("Address was valid, there should have been no exception");
        }
    }

    @Test
    public void testCreateDuplicateAddress(){
        Address address = new Address("testLastName");
        address.setStreetAddress("address");
        address.setFirstName("firstname");

        try{
            service.addAddress(address.getLastName(),address);
            fail("expected duplicate exception not thrown");
        } catch (AddressBookDuplicateException e) {
            return;
        } catch (AddressBookDataValidationException
                | AddressBookPersistenceException e) {
            fail("wrong exception thrown");
        }

    }

    @Test
    public void testGetAllAddresses() throws Exception{
        Address testAddress = new Address("testLastName");
        testAddress.setStreetAddress("testAddress");
        testAddress.setFirstName("testFirstName");

        assertEquals(1, service.getAllAddresses().size(), "size should be 1");

        assertTrue(service.getAllAddresses().contains(testAddress), "the one address should be testLastName");

    }

    @Test
    public void testGetAddress() throws Exception {
        Address addressClone = new Address("testLastName");
        addressClone.setStreetAddress("testAddress");
        addressClone.setFirstName("testFirstName");

        Address testGet = service.getAddress("testLastName");

        assertNotNull(testGet);
        assertEquals(addressClone, testGet);

        Address shouldBeNull = service.getAddress("somebadlastname");
        assertNull(shouldBeNull);
    }




}
