/*
Author: David Diaz
SNHU CS320
 */

import org.junit.Assert;
import org.junit.Test;
import Contact.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactServiceTest {
    @Test
    public void testAddContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        contactService.addContact(contact);
        Assert.assertEquals(1, contactService.getContacts().size());
    }

    @Test
    public void testRemoveContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        contactService.addContact(contact);
        Assert.assertEquals(1, contactService.getContacts().size());
        contactService.deleteContact("1");
        Assert.assertEquals(0, contactService.getContacts().size());
    }

    @Test
    public void testUpdateContact() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        contactService.addContact(contact);
        contactService.updateFirstName("1", "Emily");
        contactService.updateLastName("1", "Peredo");
        contactService.updatePhone("1", "7046486978");
        contactService.updateAddress("1", "1401 Virginia Ave");
        Assert.assertEquals("Emily", contact.getFirstName());
        Assert.assertEquals("Peredo", contact.getLastName());
        Assert.assertEquals("7046486978", contact.getPhone());
        Assert.assertEquals("1401 Virginia Ave", contact.getAddress());
    }

    @Test
    public void testDuplicateContactID() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        contactService.addContact(contact1);
        Contact contact2 = new Contact("1", "Emily", "Peredo", "7046484356", "416 Brookside Dr");
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    public void testFindMissingContactID() {
        ContactService contactService = new ContactService();
        Assert.assertNull(contactService.getContact("1"));
    }
}
