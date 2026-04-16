/*
Author: David Diaz
SNHU CS320
 */

import org.junit.Assert;
import org.junit.Test;
import Contact.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactTest {
    @Test
    public void testContact() {
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        Assert.assertEquals("1", contact.getContactID());
        Assert.assertEquals("David", contact.getFirstName());
    }

    @Test
    public void testContactContactIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678910", "David", "Diaz", "7046484356", "416 Brookside Dr");
        });
    }

    @Test
    public void testContactNamesTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "DavidTesting", "Diaz", "7046484356", "416 Brookside Dr");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "David", "DiazTestingToo", "7046484356", "416 Brookside Dr");
        });
    }

    @Test
    public void testContactPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "David", "Diaz", "704-648-4356", "416 Brookside Dr");
        });
    }

    @Test
    public void testContactAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "DavidTesting", "Diaz", "7046484356", "6112 North Brookside Parkway");
        });
    }

    @Test
    public void testContactNullID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "David", "Diaz", "7046484356", "416 Brookside Dr");
        });
    }

    @Test
    public void testContactNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, null, "7046484356", "416 Brookside Dr");
        });
    }

    @Test
    public void testContactNullPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "David", "Diaz", null, "416 Brookside Dr");
        });
    }

    @Test
    public void testContactNullAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "David", "Diaz", "7046484356", null);
        });
    }

    @Test
    public void testContactNameChange() {
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        Assert.assertEquals("David", contact.getFirstName());
        contact.setFirstName("Emily");
        Assert.assertEquals("Emily", contact.getFirstName());
    }

    @Test
    public void testContactPhoneChange() {
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        Assert.assertEquals("7046484356", contact.getPhone());
        contact.setPhone("7046486978");
        Assert.assertEquals("7046486978", contact.getPhone());
    }

    @Test
    public void testContactAddressChange() {
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        Assert.assertEquals("416 Brookside Dr", contact.getAddress());
        contact.setAddress("1401 Virginia Ave");
        Assert.assertEquals("1401 Virginia Ave", contact.getAddress());
    }

    @Test
    public void testContactInvalidNameChange() {
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        Assert.assertEquals("David", contact.getFirstName());
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("TestingName");
        });
    }

    @Test
    public void testContactInvalidPhoneChange() {
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("704-648-4356");
        });
    }

    @Test
    public void testContactInvalidAddressChange() {
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("40005 Jean Baptiste Point du Sable Lake Shore Drive");
        });
    }
}
