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
    public void testContactNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "DavidTesting", "Diaz", "7046484356", "416 Brookside Dr");
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
    public void testContactNameChange() {
        Contact contact = new Contact("1", "David", "Diaz", "7046484356", "416 Brookside Dr");
        Assert.assertEquals("David", contact.getFirstName());
        contact.setFirstName("Emily");
        Assert.assertEquals("Emily", contact.getFirstName());
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
}
